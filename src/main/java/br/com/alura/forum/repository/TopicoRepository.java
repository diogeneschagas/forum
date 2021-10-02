package br.com.alura.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{
	/*
	 * // Interface criada para utilizar os métodos da interface 'mãe'
	 * JpaRepository, para não chamar os métodos diretamente. "Personalizando" 
	 * as chamadas 
	 */	
}
