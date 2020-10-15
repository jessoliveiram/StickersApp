package br.com.stickers.StickersApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.stickers.StickersApp.Model.Multimidia;
import br.com.stickers.StickersApp.Model.Usuario;
import br.com.stickers.StickersApp.Repository.AndamentoUsuarioRepository;
import br.com.stickers.StickersApp.Repository.MultimidiaRepository;
import br.com.stickers.StickersApp.Repository.UsuarioRepository;

public class FavoritosService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	MultimidiaRepository multimidiaRepository;
	
	@Autowired
	AndamentoUsuarioRepository andamentoUsuarioRepository;
	
	
	public List<Multimidia> getListFavoritos(Long usuarioID) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioID);
		
		List<Multimidia> listFavoritos = usuario.getListFavoritos();
		
		return listFavoritos;
		
	}

	public Iterable<Multimidia> updateListFavoritos(Long usuarioID, Multimidia multimidia) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioID);
		
		List<Multimidia> listFavoritos = usuario.getListFavoritos();
		
		listFavoritos.add(multimidia);
		
		return multimidiaRepository.saveAll(listFavoritos);
		
	}
		
	public Iterable<Multimidia> removeFromListFavoritos(Long usuarioID, Long multimidiaID) {
		
		Usuario usuario = ((UsuarioRepository) usuarioRepository).findUsuarioById(usuarioID);
		Multimidia multimidia = multimidiaRepository.findMultimidiaById(multimidiaID);
		
		List<Multimidia> listFavoritos = usuario.getListFavoritos();
		
		listFavoritos.remove(multimidia);
		
		return multimidiaRepository.saveAll(listFavoritos);
		
	}

}
