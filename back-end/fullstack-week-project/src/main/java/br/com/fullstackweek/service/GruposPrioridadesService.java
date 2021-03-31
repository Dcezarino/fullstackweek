package br.com.fullstackweek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackweek.entity.GruposPrioridades;
import br.com.fullstackweek.exception.GruposPrioridadesNotFound;
import br.com.fullstackweek.repository.GruposPrioridadesRepository;
import br.com.fullstackweek.request.GruposPrioridadesRequest;
import br.com.fullstackweek.response.GruposPrioridadesResponse;

@Service
public class GruposPrioridadesService {

	@Autowired
	private GruposPrioridadesRepository gruposPrioridadesRepository;

	public List<GruposPrioridadesResponse> getAll() {
		return this.gruposPrioridadesRepository.findAll().stream().map(GruposPrioridadesResponse::new)
				.collect(Collectors.toList());

	}

	public GruposPrioridadesResponse create(GruposPrioridadesRequest gruposPrioridadesRequest) {

		GruposPrioridades gruposPrioridades = new GruposPrioridades(gruposPrioridadesRequest);
		GruposPrioridades gruposPrioridadesCreated = this.gruposPrioridadesRepository.save(gruposPrioridades);

		return new GruposPrioridadesResponse(gruposPrioridadesCreated);
	}

	public GruposPrioridadesResponse update(GruposPrioridadesRequest gruposPrioridadesRequest, Long codigo) {

		GruposPrioridades gruposPrioridades = this.gruposPrioridadesRepository.findById(codigo)
				.orElseThrow(() -> new GruposPrioridadesNotFound());

		gruposPrioridades.fillGruposPrioridadesFromDto(gruposPrioridadesRequest);
		this.gruposPrioridadesRepository.save(gruposPrioridades);
		return new GruposPrioridadesResponse(gruposPrioridades);
	}

	public void deleteById(Long codigo) {
		GruposPrioridades gruposPrioridades = this.gruposPrioridadesRepository.findById(codigo)
				.orElseThrow(() -> new GruposPrioridadesNotFound());
		this.gruposPrioridadesRepository.delete(gruposPrioridades);

	}

}
