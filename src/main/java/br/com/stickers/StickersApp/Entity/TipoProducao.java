package br.com.stickers.StickersApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class TipoProducao {
	
	@Id
	@GeneratedValue
	private Long tipoProducao_id;
	
	private String nome;
	
	private String codigo;

}
