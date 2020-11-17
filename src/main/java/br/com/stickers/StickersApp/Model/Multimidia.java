package br.com.stickers.StickersApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Multimidia {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@OneToOne
	private String tipoMultimidia;
	
	@OneToOne
	private String generoMultimidia;
	
	private Integer epTotal;
	
	private String sticker;
}
