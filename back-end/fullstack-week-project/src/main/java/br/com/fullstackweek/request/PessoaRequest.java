package br.com.fullstackweek.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PessoaRequest {
		
	@NotBlank
	@Size(min = 2, max = 255)
	private String nome;

	@NotBlank		
	@Size(min = 11, message= "cpf cannot be greater than twelve") 
	private String cpf;

	@NotBlank
	private String telefone;

	@NotBlank
	private String email;

	@NotNull
	private Integer idade;
	
	@NotBlank
	private String dataNascimento;	
	
	@NotNull
	private Boolean isVacinada;	
	
	//@NotNull
    private Long codigoGrupoPrioridade;

}
