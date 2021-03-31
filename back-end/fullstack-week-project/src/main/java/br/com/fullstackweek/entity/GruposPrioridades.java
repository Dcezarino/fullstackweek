package br.com.fullstackweek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.fullstackweek.request.GruposPrioridadesRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(of = { "codigo" })
@NoArgsConstructor
@Data
public class GruposPrioridades {

	public GruposPrioridades(GruposPrioridadesRequest gruposPrioridadesRequest) {
		this.fillGruposPrioridadesFromDto(gruposPrioridadesRequest);
	}

	public void fillGruposPrioridadesFromDto(GruposPrioridadesRequest gruposPrioridadesRequest) {
		this.setNome(gruposPrioridadesRequest.getNome());
		this.setDescricao(gruposPrioridadesRequest.getDescricao());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable = false)
	private String nome;

	private String descricao;

}
