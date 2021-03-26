package br.com.fullstackweek.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fullstackweek.request.PessoaRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(of = {"codigo","cpf", "email"})
@NoArgsConstructor
@Data
public class Pessoa {
	
	
	public Pessoa(PessoaRequest pessoaRequest, GruposPrioridades gruposPrioridades) {
		this.fillPessoaFromDto(pessoaRequest);
		this.setGrupo(gruposPrioridades);
	}

	public void fillPessoaFromDto(PessoaRequest pessoaRequest) {
		this.setNome(pessoaRequest.getNome());
		this.setCpf(pessoaRequest.getCpf());
		this.setTelefone(pessoaRequest.getTelefone());
		this.setEmail(pessoaRequest.getEmail());
		this.setIdade(pessoaRequest.getIdade());
		this.setDataNascimento(pessoaRequest.getDataNascimento());
		this.setIsVacinada(pessoaRequest.getIsVacinada());		
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, length = 11, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false, length = 80, unique = true)
	private String email;
	
	@Column(nullable = false, length = 3)
	private Integer idade;
	
	@Column(name = "data_nascimento", columnDefinition = "TIMESTAMP")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dataNascimento;	
	
	private Boolean isVacinada;	
	
	// Quando a pessoa se cadastrar a mesma tem que estar associada ao um grupo de prioridades
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_grupo_prioridade", referencedColumnName = "codigo")	
	private GruposPrioridades grupo;

}
