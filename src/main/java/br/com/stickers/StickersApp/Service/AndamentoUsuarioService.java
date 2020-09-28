package br.com.stickers.StickersApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stickers.StickersApp.Model.AndamentoUsuario;
import br.com.stickers.StickersApp.Repository.AndamentoUsuarioRepository;

@Service
public class AndamentoUsuarioService {
	
	@Autowired
	private AndamentoUsuarioRepository andamentoUsuarioRepository;

	
	public Iterable<AndamentoUsuario> getListAndamentoUsuario() {
		
		Iterable<AndamentoUsuario> andamentoUsuario = andamentoUsuarioRepository.findAll();
		
		return andamentoUsuario;
	}
	
	public Optional<AndamentoUsuario> getAndamentoUsuarioById (Long id) {
		
		Optional<AndamentoUsuario> andamentoUsuario = andamentoUsuarioRepository.findById(id);
		
		return andamentoUsuario;
	}
	
	public AndamentoUsuario updateAndamentoUsuario (Long andamentoUsuarioId, Integer epAssistidos, Integer epTotal) {
		
		AndamentoUsuario andamentoUsuario = andamentoUsuarioRepository.findAndamentoUsuarioById(andamentoUsuarioId);
		
		if (andamentoUsuario != null) {
			
			andamentoUsuario.setEpAssistidos(epAssistidos);
			
			if (epAssistidos.equals(epTotal)) {
				
				andamentoUsuario.setStickerOK(true);
			}
		}
		
		return andamentoUsuario;
	}

}
