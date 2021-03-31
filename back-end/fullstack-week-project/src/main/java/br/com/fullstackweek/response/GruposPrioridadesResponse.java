package br.com.fullstackweek.response;

import br.com.fullstackweek.entity.GruposPrioridades;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GruposPrioridadesResponse {
	
	public GruposPrioridadesResponse(GruposPrioridades gruposPrioridades) {
		this.setCodigo(gruposPrioridades.getCodigo());
		this.setNome(gruposPrioridades.getNome());
		this.setDescricao(gruposPrioridades.getDescricao());		
	}
	

	private Long codigo;
	
	private String nome;

	private String descricao;


}
