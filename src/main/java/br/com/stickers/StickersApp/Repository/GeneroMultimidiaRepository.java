package br.com.stickers.StickersApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.stickers.StickersApp.Model.GeneroMultimidia;

@Repository
public interface GeneroMultimidiaRepository extends CrudRepository<GeneroMultimidia, Long> {

}
