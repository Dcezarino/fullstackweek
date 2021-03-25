package br.com.fullstackweek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackweek.entity.Pessoa;
import br.com.fullstackweek.exception.NotFound;
import br.com.fullstackweek.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> getAll(){
		return pessoaRepository.findAll();		
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa post(@RequestBody Pessoa pessoa) {		
		return pessoaRepository.save(pessoa);
	}
	
	@PutMapping(path = "/{codigo}")
	public Pessoa update(@PathVariable Long codigo, @RequestBody Pessoa pessoa ) {
		return pessoaRepository.findById(codigo).map(
				record -> {
					record.setCpf(pessoa.getCpf());
					record.setDataNascimento(pessoa.getDataNascimento());
					record.setCpf(pessoa.getCpf());
					record.setEmail(pessoa.getEmail());
					record.setIdade(pessoa.getIdade());
					record.setNome(pessoa.getNome());
					record.setTelefone(pessoa.getTelefone());				
					return pessoaRepository.save(record);					
				}).orElseThrow(() -> new NotFound());		
		
	}
	
	@GetMapping(path = "/{codigo}")
	public Pessoa findByID(@PathVariable Long codigo) {
		return pessoaRepository.findById(codigo).orElseThrow(() -> new NotFound());		
	}
	
	@DeleteMapping(path = "/{codigo}")
	public void delete(@PathVariable Long codigo) {
		pessoaRepository.deleteById(codigo);	
	}
	
	
}