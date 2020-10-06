package br.com.stickers.StickersApp.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stickers.StickersApp.DTO.AndamentoUsuarioDTO;
import br.com.stickers.StickersApp.Model.AndamentoUsuario;
import br.com.stickers.StickersApp.Model.Multimidia;
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
	
	public AndamentoUsuario updateAndamentoUsuario (AndamentoUsuarioDTO andamentoUsuarioDTO) {
		
		AndamentoUsuario andamentoUsuario = andamentoUsuarioRepository.findAndamentoUsuarioById(andamentoUsuarioDTO.getAndamentoUsuarioId());
		Multimidia multimidia = andamentoUsuario.getMultimidia();
		
		if (andamentoUsuario != null) {
			
			andamentoUsuario.setEpAssistidos(andamentoUsuarioDTO.getEpAssistidos());
			
			if (andamentoUsuarioDTO.getEpAssistidos().equals(multimidia.getEpTotal())) {
				
				andamentoUsuario.setStickerOK(true);
			}
		}
		
		return andamentoUsuario;
	}
	
	public ArrayList<AndamentoUsuario> getListAndamentoUsuarioCompleto() {
		
		ArrayList<AndamentoUsuario> completos = new ArrayList<AndamentoUsuario>();
		for (AndamentoUsuario andamento : getListAndamentoUsuario()) {
			if (andamento.getEpAssistidos().equals(andamento.getMultimidia().getEpTotal())) {
				completos.add(andamento);
			}
		}
		return completos;
	}

}
