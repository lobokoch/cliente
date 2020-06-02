package br.com.kerubin.api.cadastros.agenda.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import br.com.kerubin.api.cadastros.cliente.CompromissoSituacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompromissoDTO {
	
	private UUID id;
	private String titulo;
	private String cliente;
	private LocalDate dataIni;
	private LocalTime horaIni;
	private LocalDate dataFim;
	private LocalTime horaFim;
	private Boolean diaTodo;
	private CompromissoSituacao situacao;
	private String descricao;
	private String local;
	private List<RecursoDTO> recursos;
	private String organizadorNome;
	private String organizadorEmail;
}
