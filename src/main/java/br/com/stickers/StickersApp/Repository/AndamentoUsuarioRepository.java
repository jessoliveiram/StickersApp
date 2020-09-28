package br.com.stickers.StickersApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.stickers.StickersApp.Model.AndamentoUsuario;

@Repository
public interface AndamentoUsuarioRepository extends CrudRepository<AndamentoUsuario, Long> {
	
	public AndamentoUsuario findAndamentoUsuarioById(Long id);

}
