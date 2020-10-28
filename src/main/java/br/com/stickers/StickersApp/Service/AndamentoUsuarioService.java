package br.com.stickers.StickersApp.Service;

import java.util.List;
import java.util.stream.Collectors;

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

	
	public List<AndamentoUsuario> getListAndamentoUsuario (Long usuarioId) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
		List<AndamentoUsuario> listAndamentoUsuario = usuario.getListAndamentoUsuario();
		
		return listAndamentoUsuario;
	}
	
	public List<AndamentoUsuario> getListAndamentoUsuarioCompleto(Long usuarioId) {
		
		List<AndamentoUsuario> completos = getListAndamentoUsuario(usuarioId)
				                                .stream().filter(au -> au.getStickerOK().equals(true))
				                                .collect(Collectors.toList());

		return completos;
	}
	
	public AndamentoUsuario getAndamentoUsuarioById (Long id) {
		
		AndamentoUsuario andamentoUsuario = andamentoUsuarioRepository.findAndamentoUsuarioById(id);
		
		return andamentoUsuario;
		
	}
	
	public Boolean postAndamentoUsuario(Long usuarioId, AndamentoUsuarioDTO andamentoUsuarioDTO) {
			
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
		Multimidia multimidia = multimidiaRepository.findMultimidiaById(andamentoUsuarioDTO.getMultimidiaId());
		
		AndamentoUsuario andamentoUsuario = new AndamentoUsuario();
		andamentoUsuario.setUsuario(usuario);
		andamentoUsuario.setMultimidia(multimidia);
		andamentoUsuario.setEpAssistidos(andamentoUsuarioDTO.getEpAssistidos());
		try {
			andamentoUsuarioRepository.save(andamentoUsuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
	public Boolean deleteAndamentoUsuario(Long usuarioId, AndamentoUsuarioDTO andamentoUsuarioDTO) {
			
		try {
			andamentoUsuarioRepository.deleteById(andamentoUsuarioDTO.getAndamentoUsuarioId());
			return true;
		} catch (Exception e) {
			return false;
		}
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
