package br.com.fullstackweek.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackweek.request.PessoaRequest;
import br.com.fullstackweek.response.PessoaResponse;
import br.com.fullstackweek.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public List<PessoaResponse> getAll() {
		return this.pessoaService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaResponse post(@Valid @RequestBody PessoaRequest pessoaRequest) {		
		return this.pessoaService.create(pessoaRequest);
	}
	
	
	@GetMapping("/{codigo}")	
	public List<PessoaResponse> getById(@PathVariable Long codigo) {
		return this.pessoaService.findById(codigo);
				
	}
	
	
	@DeleteMapping("/{codigo}")	
	public void deleteById(@PathVariable Long codigo) {
		this.pessoaService.deleteById(codigo);				
	}
}