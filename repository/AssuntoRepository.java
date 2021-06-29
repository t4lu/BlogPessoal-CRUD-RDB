package br.com.generation.redePessoal.repository;
/*Função: CRUD e dados relacionais no blog pessoal (testagem no Postman)
 * Autora: Talu - Turma 25
 * Data: 28.06.2021
*/
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.redePessoal.model.Assunto;

@Repository
public interface AssuntoRepository extends JpaRepository<Assunto, Long>{

	public List<Assunto> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	public Assunto findById (long id);
	
	public Assunto deleteById (long id);
}
