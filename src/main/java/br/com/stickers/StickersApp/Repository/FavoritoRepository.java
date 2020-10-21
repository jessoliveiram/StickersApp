package br.com.stickers.StickersApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.stickers.StickersApp.Model.Favorito;

@Repository
public interface FavoritoRepository extends CrudRepository<Favorito, Long>{

	public Favorito findFavoritoById(Long id);
}
