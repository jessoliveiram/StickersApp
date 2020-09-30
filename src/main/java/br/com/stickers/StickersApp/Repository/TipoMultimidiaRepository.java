package br.com.stickers.StickersApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.stickers.StickersApp.Model.TipoMultimidia;

@Repository
public interface TipoMultimidiaRepository extends CrudRepository<TipoMultimidia, Long> {

}
