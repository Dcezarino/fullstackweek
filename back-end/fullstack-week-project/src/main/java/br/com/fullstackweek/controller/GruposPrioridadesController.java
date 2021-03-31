package br.com.fullstackweek.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.fullstackweek.request.GruposPrioridadesRequest;
import br.com.fullstackweek.response.GruposPrioridadesResponse;
import br.com.fullstackweek.service.GruposPrioridadesService;

@RestController
@RequestMapping("/gruposPrioridades")
public class GruposPrioridadesController {

	@Autowired
	private GruposPrioridadesService gruposPrioridadesService;

	@GetMapping
	public List<GruposPrioridadesResponse> getAll() {
		return gruposPrioridadesService.getAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GruposPrioridadesResponse post(@Valid @RequestBody GruposPrioridadesRequest gruposPrioridadesRequest) {
		return gruposPrioridadesService.create(gruposPrioridadesRequest);
		
	}
	
	@PutMapping("/{codigo}")
	public GruposPrioridadesResponse update(@PathVariable Long codigo, @RequestBody GruposPrioridadesRequest gruposPrioridadesRequest) {
		return gruposPrioridadesService.update(gruposPrioridadesRequest, codigo);

	}
	
	@DeleteMapping("/{codigo}")
	public void delete(@PathVariable Long codigo) {
		gruposPrioridadesService.deleteById(codigo);
		
	}

}
