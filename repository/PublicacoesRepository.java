package br.com.generation.redePessoal.repository;
/*Função: CRUD e dados relacionais no blog pessoal (testagem no Postman)
 * Autora: Talu - Turma 25
 * Data: 28.06.2021
*/
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.redePessoal.model.Publicacoes;

@Repository
public interface PublicacoesRepository extends JpaRepository<Publicacoes, Long>{
	public List<Publicacoes> findAll();
	
	public List<Publicacoes> findAllByTituloContainingIgnoreCase(String titulo);
	
	public Publicacoes findById (long id);
	
	public Publicacoes deleteById (long id);

}