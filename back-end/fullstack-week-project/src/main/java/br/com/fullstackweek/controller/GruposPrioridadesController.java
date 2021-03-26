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

import br.com.fullstackweek.entity.GruposPrioridades;
import br.com.fullstackweek.exception.NotFound;
import br.com.fullstackweek.repository.GruposPrioridadesRepository;

@RestController
@RequestMapping("/gruposPrioridades")
public class GruposPrioridadesController {

	@Autowired
	private GruposPrioridadesRepository gruposPrioridadesRepository;

	@GetMapping
	public List<GruposPrioridades> getAll() {
		return gruposPrioridadesRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GruposPrioridades post(@RequestBody GruposPrioridades gruposPrioridades) {
		return gruposPrioridadesRepository.save(gruposPrioridades);
	}

	@PutMapping("/{codigo}")
	public GruposPrioridades update(@PathVariable Long codigo, @RequestBody GruposPrioridades gruposPrioridades) {
		return gruposPrioridadesRepository.findById(codigo).map(
				record -> {
					record.setNome(gruposPrioridades.getNome());
					record.setDescricao(gruposPrioridades.getDescricao());
					return gruposPrioridadesRepository.save(record);
		}).orElseThrow(() -> new NotFound());

	}
	
	@DeleteMapping("/{codigo}")
	public void delete(@PathVariable Long codigo) {
		gruposPrioridadesRepository.deleteById(codigo);
		
	}

}
