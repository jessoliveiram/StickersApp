package br.com.stickers.StickersApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producao {

	@Id
	@GeneratedValue
	private Long producao_id;
	
	private String nome;
	
	private TipoProducao tipoProducao;
	
	private GeneroProducao generoProducao;
	
	private Integer epTotal;
	
	private String sticker;
}
