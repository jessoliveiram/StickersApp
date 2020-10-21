package br.com.stickers.StickersApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stickers.StickersApp.DTO.FavoritoDTO;
import br.com.stickers.StickersApp.Model.Favorito;
import br.com.stickers.StickersApp.Model.Multimidia;
import br.com.stickers.StickersApp.Model.Usuario;
import br.com.stickers.StickersApp.Repository.FavoritoRepository;
import br.com.stickers.StickersApp.Repository.MultimidiaRepository;
import br.com.stickers.StickersApp.Repository.UsuarioRepository;

@Service
public class FavoritoService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MultimidiaRepository multimidiaRepository;
	
	@Autowired
	private FavoritoRepository favoritoRepository;
	
	
	public List<Favorito> getListFavoritos(Long usuarioID) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioID);
		
		List<Favorito> listFavoritos = usuario.getListFavoritos();
		
		return listFavoritos;
		
	}

	public Boolean updateListFavoritos(Long usuarioId, FavoritoDTO favoritoDTO) {
		
		if(favoritoDTO.getAcao() == "REM") 
		{
			favoritoRepository.deleteById(favoritoDTO.getFavoritoId());
			return true;
		}
		
		else if(favoritoDTO.getAcao() == "ADD") 
		{

			Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
			Multimidia multimidia = multimidiaRepository.findMultimidiaById(favoritoDTO.getMultimidiaId());
			Favorito favorito = new Favorito();
			favorito.setMultimidia(multimidia);
			favorito.setUsuario(usuario);
			favoritoRepository.save(favorito);
			return true;
			
		}
		return false;
	}

}