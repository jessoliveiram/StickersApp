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
	
	
	public List<Favorito> getListFavoritos(Long usuarioId) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
		
		List<Favorito> listFavoritos = usuario.getListFavoritos();
		
		return listFavoritos;
		
	}
	
	public Favorito getFavorito(Long favoritoId) {
		
		Favorito favorito = favoritoRepository.findFavoritoById(favoritoId);
		
		return favorito;
		
	}

	public Boolean deleteFavorito(Long usuarioId, FavoritoDTO favoritoDTO) {
		
		try {
			favoritoRepository.deleteById(favoritoDTO.getFavoritoId());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
		
	public Boolean postFavorito(Long usuarioId, FavoritoDTO favoritoDTO) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
		Multimidia multimidia = multimidiaRepository.findMultimidiaById(favoritoDTO.getMultimidiaId());
		Favorito favorito = new Favorito();
		favorito.setMultimidia(multimidia);
		favorito.setUsuario(usuario);
		
		try {
			favoritoRepository.save(favorito);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}