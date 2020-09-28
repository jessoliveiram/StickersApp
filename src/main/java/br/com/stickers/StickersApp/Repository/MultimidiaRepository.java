package br.com.stickers.StickersApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.stickers.StickersApp.Model.Multimidia;

@Repository
public interface MultimidiaRepository extends CrudRepository<Long, Multimidia> {
	
	public Multimidia findMultimidiaById(Long id);
	
}
