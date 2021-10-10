package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.alura.forum.modelo.Topico;

public class TopicoDto { // No DTO ficam as informações REALMENTE necessárias para a resposta que o recurso necessita
	/*
	 * Possíveis bugs em uma API:
	 * 		- Falta de algum campo representacional para enviar pro Front End
	 * 		- Não tratamento da resposta para ser enviada ao front (ex. Data e hora com segundos, quando este último não é necessário) 
		*/
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCiacao() {
		return dataCriacao;
	}

	public static Page<TopicoDto> converter(Page<Topico> topicos) {
		/*
		 * Aqui retornava um LIST
		 * return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
		 */	
		
		// Agora, retorna um PAGE
		return topicos.map(TopicoDto::new);
	}
	
	
	
	
	
}
