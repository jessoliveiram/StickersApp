package br.com.stickers.StickersApp.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stickers.StickersApp.DTO.UsuarioDTO;
import br.com.stickers.StickersApp.Model.Usuario;
import br.com.stickers.StickersApp.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public Usuario getUsuario(Long usuarioId) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
		
		return usuario;
	}
	
	public List<Usuario> getListUsuario() {
		
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		
		return usuarios;
	}
	
	public Usuario createUsuario(UsuarioDTO usuarioDTO) {
		
		ModelMapper mm = new ModelMapper();
		Usuario usuario = mm.map(usuarioDTO, Usuario.class);
		try {
			return usuarioRepository.save(usuario);
		} catch (Exception e) {
			return null;
		}
	}

	public Boolean updateUsuario(Long usuarioId, UsuarioDTO usuarioDTO) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
		ModelMapper mm = new ModelMapper();
		mm.map(usuarioDTO, usuario);
		try {
			usuarioRepository.save(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean deleteUsuario(Long usuarioId) {
		
		try {
			usuarioRepository.deleteById(usuarioId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
