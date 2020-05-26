package br.com.kerubin.api.cadastros.agenda.service;

import static br.com.kerubin.api.servicecore.util.CoreUtils.isNotEmpty;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgenda;
import br.com.kerubin.api.cadastros.agenda.model.RecursoDTO;
import br.com.kerubin.api.cadastros.cliente.CompromissoSituacao;
import br.com.kerubin.api.cadastros.cliente.entity.compromisso.CompromissoEntity;
import br.com.kerubin.api.cadastros.cliente.entity.compromisso.QCompromissoEntity;
import br.com.kerubin.api.cadastros.cliente.entity.recurso.QRecursoEntity;

@Component
public class AgendaDataProviderImpl implements AgendaDataProvider {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<RecursoDTO> getAllRecursosDTO() {
		JPAQueryFactory query = new JPAQueryFactory(em);
		QRecursoEntity qRecurso = QRecursoEntity.recursoEntity;
		
		return query
			.select(Projections.bean(RecursoDTO.class, qRecurso.id, qRecurso.nome, qRecurso.email))
			.from(qRecurso)
			.where(qRecurso.ativo.isTrue())
			.orderBy(qRecurso.nome.asc())
			.fetch();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<CompromissoEntity> getComprimissosDoMes(ParametrosAgenda params) {
		JPAQueryFactory query = new JPAQueryFactory(em);
		QCompromissoEntity qCompromissoEntity = QCompromissoEntity.compromissoEntity;
		
		BooleanExpression expression = buildExpressionForComprimissosDoMes(qCompromissoEntity, params);
		
		// 04/05/2020
		return query.selectFrom(qCompromissoEntity)
			.where(expression)
			.orderBy(qCompromissoEntity.dataIni.asc(), qCompromissoEntity.horaIni.asc())			
			.fetchAll().fetch();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Long countCompromissosDoRecurso(ParametrosAgenda params) {
		JPAQueryFactory query = new JPAQueryFactory(em);
		QCompromissoEntity qCompromissoEntity = QCompromissoEntity.compromissoEntity;
		LocalDate data = params.getData() != null ? params.getData() : LocalDate.now();
		
		List<CompromissoSituacao> situacoes = Arrays.asList(CompromissoSituacao.NAO_INICIADO, CompromissoSituacao.EXECUTANDO);
		String email = isNotEmpty(params.getRecursoEmails()) ? params.getRecursoEmails().get(0) : null;
		
		BooleanExpression expression = qCompromissoEntity.dataIni.loe(data)
				.and(qCompromissoEntity.dataFim.goe(data))
				.and(qCompromissoEntity.situacao.in(situacoes));
		
		if (isNotEmpty(email)) { //
			expression = expression //
					.and(qCompromissoEntity.recursos.any().email.eq(params.getRecursoEmails().get(0))); //
		}
		
		return query.select(qCompromissoEntity.count())
			.from(qCompromissoEntity)
			.where(expression)
			.fetchOne();
	}
	
	private BooleanExpression buildExpressionForComprimissosDoMes(QCompromissoEntity qEntity, ParametrosAgenda params) {
		BooleanExpression expression = qEntity.dataIni.year().eq(params.getAno())
				.and(qEntity.dataIni.month().eq(params.getMes()));
		
		
		if (isNotEmpty(params.getRecursoEmails())) {
			expression = expression.and(qEntity.recursos.any().email.in(params.getRecursoEmails()));
		}
		
		return expression;
	}

}
