package br.com.fullstackweek.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class GruposPrioridadesRequest {
	

	@NotBlank
	@Size(min = 2, max = 255)
	private String nome;

	@NotBlank
	@Size(min = 3, max = 255)
	private String descricao;
	

}
