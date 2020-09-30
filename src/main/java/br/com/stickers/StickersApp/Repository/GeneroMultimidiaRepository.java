package br.com.stickers.StickersApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.stickers.StickersApp.Model.GeneroProducao;

@Repository
public interface GeneroMultimidiaRepository extends CrudRepository<GeneroProducao, Long> {

}
