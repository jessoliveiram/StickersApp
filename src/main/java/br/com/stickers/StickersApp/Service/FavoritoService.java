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
	
	
	public Favorito getFavorito(Long favoritoId) {
		
		Favorito favorito = favoritoRepository.findFavoritoById(favoritoId);
		
		return favorito;
		
	}
	
	public List<Favorito> getListFavoritos(Long usuarioId) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
		
		List<Favorito> listFavoritos = usuario.getListFavoritos();
		
		return listFavoritos;
		
	}

	public Favorito createFavorito(FavoritoDTO favoritoDTO) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(favoritoDTO.getUsuarioId());
		Multimidia multimidia = multimidiaRepository.findMultimidiaById(favoritoDTO.getMultimidiaId());
		Favorito favorito = new Favorito();
		favorito.setMultimidia(multimidia);
		favorito.setUsuario(usuario);
		
		try {
			return favoritoRepository.save(favorito);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Boolean deleteFavorito(Long favoritoId) {
		
		try {
			favoritoRepository.deleteById(favoritoId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}