package br.com.fullstackweek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackweek.entity.GruposPrioridades;
import br.com.fullstackweek.entity.Pessoa;
import br.com.fullstackweek.exception.NotFound;
import br.com.fullstackweek.repository.GruposPrioridadesRepository;
import br.com.fullstackweek.repository.PessoaRepository;
import br.com.fullstackweek.request.PessoaRequest;
import br.com.fullstackweek.response.PessoaResponse;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private GruposPrioridadesRepository gruposPrioridadesRepository;

	public List<PessoaResponse> findAll() {
		return this.pessoaRepository.findAll().stream().map(PessoaResponse::new).collect(Collectors.toList());
	}

	public PessoaResponse create(PessoaRequest pessoaRequest) {
		GruposPrioridades gruposPrioridades = this.gruposPrioridadesRepository.findById(pessoaRequest.getIdGrupoPrioridade())
				.orElseThrow(() -> new NotFound());

		Pessoa pessoa = new Pessoa(pessoaRequest, gruposPrioridades);
		Pessoa pessoacreated = this.pessoaRepository.save(pessoa);

		return new PessoaResponse(pessoacreated);
	}
	
	public List<PessoaResponse> findById(Long codigo) {
		return this.pessoaRepository.findById(codigo).stream().map(PessoaResponse::new).collect(Collectors.toList());
	}
	
	public void deleteById(Long codigo) {
		Pessoa pessoa = this.pessoaRepository.findById(codigo).orElseThrow(() -> new NotFound());
		this.pessoaRepository.delete(pessoa);				
	}
	
}
