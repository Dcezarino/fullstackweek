package br.com.fullstackweek.response;

import br.com.fullstackweek.entity.GruposPrioridades;
import br.com.fullstackweek.entity.Pessoa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaResponse {
	
	
	public PessoaResponse(Pessoa pessoa) {
		this.setCodigo(pessoa.getCodigo());
		this.setNome(pessoa.getNome());
		this.setCpf(pessoa.getCpf());
		this.setTelefone(pessoa.getTelefone());
		this.setEmail(pessoa.getEmail());
		this.setIdade(pessoa.getIdade());
		this.setDataNascimento(pessoa.getDataNascimento());
		this.setIsVacinada(pessoa.getIsVacinada());
		this.setGrupo(pessoa.getGrupo());		
	}
	
	private Long codigo;
	
	private String nome;
	
	private String cpf;
	
	private String telefone;
	
	private String email;
	
	private Integer idade;
	
	private String dataNascimento;	
	
	private Boolean isVacinada;
	
	private GruposPrioridades grupo;	
	

}
