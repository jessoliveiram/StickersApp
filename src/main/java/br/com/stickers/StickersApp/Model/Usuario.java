package br.com.stickers.StickersApp.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {

	@Id
	@GeneratedValue 
	private Long id;
	
	private String nome;
	
	private String celular;
	
	private String email;
	
	private String pais;
	
	@OneToMany(mappedBy = "usuario")
	private List<AndamentoUsuario> listAndamentoUsuario;
	
	@OneToMany(mappedBy = "usuario")
	private List<Favorito> listFavoritos;
	
}
