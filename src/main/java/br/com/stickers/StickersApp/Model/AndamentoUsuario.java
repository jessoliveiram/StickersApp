package br.com.stickers.StickersApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "id")
	private Multimidia multimidia;
	
	private Integer epAssistidos;

	private Boolean stickerOK;

}
