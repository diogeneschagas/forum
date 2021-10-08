package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCurso_Nome(String nomeCurso);
	/*
	 * // Interface criada para utilizar os métodos da interface 'mãe'
	 * JpaRepository, para não chamar os métodos diretamente. "Personalizando" 
	 * as chamadas 
	 */	
}
