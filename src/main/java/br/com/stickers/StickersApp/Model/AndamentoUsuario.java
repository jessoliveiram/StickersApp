package br.com.stickers.StickersApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AndamentoUsuario {
	
	@Id
	@GeneratedValue
	private Long andamentoUsuario_id;

	private Multimidia multimidia;
	
	private Integer epAssistidos;

	private Boolean stickerOK;

}
