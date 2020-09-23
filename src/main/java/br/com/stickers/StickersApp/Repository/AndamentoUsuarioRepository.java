package br.com.stickers.StickersApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.stickers.StickersApp.Entity.AndamentoUsuario;

@Repository
public interface AndamentoUsuarioRepository extends CrudRepository<Long, AndamentoUsuario> {

}
