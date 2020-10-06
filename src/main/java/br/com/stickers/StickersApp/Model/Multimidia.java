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
public class Multimidia {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "id")
	private TipoMultimidia tipoMultimidia;
	
	@OneToOne
	@JoinColumn(name = "id")
	private GeneroMultimidia generoMultimidia;
	
	private Integer epTotal;
	
	private String sticker;
}
