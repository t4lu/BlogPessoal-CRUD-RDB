package br.com.generation.redePessoal.controller;
/*Função: CRUD e dados relacionais no blog pessoal (testagem no Postman)
 * Autora: Talu - Turma 25
 * Data: 28.06.2021
*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.redePessoal.model.Assunto;
import br.com.generation.redePessoal.repository.AssuntoRepository;

@RestController
@RequestMapping ("/assunto")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class AssuntoController {
	
	@Autowired
	private AssuntoRepository repository;
	
	@GetMapping ("/list")
	public List<Assunto> listar(){
	return repository.findAll();
	}
	@GetMapping ("/{id}")
	public Assunto getById (@PathVariable long id) {
		return repository.findById(id);
	}
	@GetMapping ("/assunto/{assunto}")
	public List<Assunto> getByAssunto (@PathVariable String assunto ){
		return repository.findAllByDescricaoContainingIgnoreCase(assunto);
	}
	@PostMapping ("/new")
	public Assunto newPublicacao (@RequestBody Assunto assunto) {
		return repository.save(assunto);
	}
	@PutMapping ("/edit")
	public Assunto editPublicacao (@RequestBody Assunto assunto) {
		return repository.save(assunto);
	}
	@DeleteMapping("/delete/{id}")
	public Assunto deletePublicacao (@PathVariable long id) {
		return repository.deleteById(id);
	}
}