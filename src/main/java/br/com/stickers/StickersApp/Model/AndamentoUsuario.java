package br.com.stickers.StickersApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AndamentoUsuario {
	
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Multimidia multimidia;
	
	@ManyToOne
	private Usuario usuario;
	
	private Integer epAssistidos;

	private Boolean stickerOK;

}
