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

import br.com.generation.redePessoal.model.Publicacoes;
import br.com.generation.redePessoal.repository.PublicacoesRepository;

@RestController
@RequestMapping ("/publicacoes")
@CrossOrigin ("*")
public class PublicacoesController {
	
	@Autowired
	private PublicacoesRepository repositorio;
	
	@GetMapping ("/listar")
	public List<Publicacoes> listar(){
	return repositorio.findAll();
	}
	@GetMapping ("/{id}")
	public Publicacoes getById (@PathVariable long id) {
		return repositorio.findById(id);
	}
	@GetMapping ("/titulo/{titulo}")
	public List<Publicacoes> getByTitulo (@PathVariable String titulo) {
		return repositorio.findAllByTituloContainingIgnoreCase(titulo);
	}
	@PostMapping ("/new")
	public Publicacoes newPublicacao (@RequestBody Publicacoes publicacoes) {
		return repositorio.save(publicacoes);
	}
	@PutMapping ("/edit")
	public Publicacoes editPublicacao (@RequestBody Publicacoes publicacoes) {
		return repositorio.save(publicacoes);
	}
	@DeleteMapping ("/del/{id}")
	public Publicacoes deletePublicacao (@PathVariable long id) {
		return repositorio.deleteById(id);
	}
}