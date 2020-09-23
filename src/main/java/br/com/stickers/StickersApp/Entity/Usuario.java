package br.com.stickers.StickersApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long usuario_id;
	
	private String nome;
	
	private String celular;
	
	private String email;
	
	private String pais;
}
