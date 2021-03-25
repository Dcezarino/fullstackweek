package br.com.fullstackweek.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(of = {"codigo","cpf", "email"})
@Data
public class Pessoa {
	
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
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;	

}
