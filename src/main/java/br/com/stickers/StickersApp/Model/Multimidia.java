package br.com.stickers.StickersApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Multimidia {

	@Id
	@GeneratedValue
	private Long multimidia_id;
	
	private String nome;
	
	private TipoMultimidia tipoMultimidia;
	
	private GeneroProducao generoMultimidia;
	
	private Integer epTotal;
	
	private String sticker;
}
