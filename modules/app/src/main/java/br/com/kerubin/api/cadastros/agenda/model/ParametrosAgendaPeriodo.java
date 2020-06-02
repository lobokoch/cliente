package br.com.kerubin.api.cadastros.agenda.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParametrosAgendaPeriodo {
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataIni;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataFim;
	
	private List<String> recursoEmails;

}
