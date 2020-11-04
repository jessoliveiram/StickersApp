package br.com.stickers.StickersApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.stickers.StickersApp.Model.Multimidia;

@Repository
public interface MultimidiaRepository extends CrudRepository<Multimidia, Long> {
	
	public Multimidia findMultimidiaById(Long id);
	
	public List<Multimidia> findAll();
	
	@Query(value="select m from Multimidia m join m.generoMultimidia gm where gm.codigo = :genero")
	public List<Multimidia> findByGenero(String genero);
	
	@Query(value="select m from Multimidia m join m.tipoMultimidia tm where tm.codigo = :tipo")
	public List<Multimidia> findByTipo(String tipo);
	
}
