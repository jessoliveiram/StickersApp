package br.com.stickers.StickersApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class GeneroProducao {
	
	@Id
	@GeneratedValue
	private Long generoProducao_id;
	
	private String nome;
	
	private String codigo;

}
