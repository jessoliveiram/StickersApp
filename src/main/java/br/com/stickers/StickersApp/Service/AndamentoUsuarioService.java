package br.com.stickers.StickersApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stickers.StickersApp.DTO.AndamentoUsuarioDTO;
import br.com.stickers.StickersApp.Model.AndamentoUsuario;
import br.com.stickers.StickersApp.Model.Multimidia;
import br.com.stickers.StickersApp.Model.Usuario;
import br.com.stickers.StickersApp.Repository.AndamentoUsuarioRepository;
import br.com.stickers.StickersApp.Repository.MultimidiaRepository;
import br.com.stickers.StickersApp.Repository.UsuarioRepository;

@Service
public class AndamentoUsuarioService {
	
	@Autowired
	private AndamentoUsuarioRepository andamentoUsuarioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MultimidiaRepository multimidiaRepository;

	
	public List<AndamentoUsuario> getListAndamentoUsuarioByUsuario (Long usuarioId) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
		List<AndamentoUsuario> listAndamentoUsuario = usuario.getListAndamentoUsuario();
		
		return listAndamentoUsuario;
	}
	
	public List<AndamentoUsuario> getListAndamentoUsuarioCompletoByUsuario(Long usuarioId) {
		
		ArrayList<AndamentoUsuario> completos = new ArrayList<AndamentoUsuario>();
		for (AndamentoUsuario andamento : getListAndamentoUsuarioByUsuario(usuarioId)) {
			if (andamento.getEpAssistidos().equals(andamento.getMultimidia().getEpTotal())) {
				completos.add(andamento);
			}
		}
		return completos;
	}
	
	public AndamentoUsuario getAndamentoUsuarioById (Long id) {
		
		AndamentoUsuario andamentoUsuario = andamentoUsuarioRepository.findAndamentoUsuarioById(id);
		
		return andamentoUsuario;
		
	}
	
	public Boolean updateListAndamentoUsuario(Long usuarioId, AndamentoUsuarioDTO andamentoUsuarioDTO) {
		
		if (andamentoUsuarioDTO.getAcao() == "ADD") {
			
			Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
			Multimidia multimidia = multimidiaRepository.findMultimidiaById(andamentoUsuarioDTO.getMultimidiaId());
			
			AndamentoUsuario andamentoUsuario = new AndamentoUsuario();
			andamentoUsuario.setUsuario(usuario);
			andamentoUsuario.setMultimidia(multimidia);
			andamentoUsuario.setEpAssistidos(andamentoUsuarioDTO.getEpAssistidos());
			andamentoUsuarioRepository.save(andamentoUsuario);
			
			return true;
		}
		
		else if (andamentoUsuarioDTO.getAcao() == "REM") {
			
			usuarioRepository.deleteById(andamentoUsuarioDTO.getAndamentoUsuarioId());
			
			return true;
		}
		return false;
	}
	
	public AndamentoUsuario updateEpisodios (AndamentoUsuarioDTO andamentoUsuarioDTO) {
		
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
	
}
