package br.com.stickers.StickersApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

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
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<AndamentoUsuario> listAndamentoUsuario;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Multimidia> listFavoritos;
	
}
