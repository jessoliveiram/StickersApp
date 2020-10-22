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

	
	public Usuario getUsuario(Long id) {
		
		Usuario usuario = usuarioRepository.findUsuarioById(id);
		
		return usuario;
	}
	
	public Usuario updateUsuario(Long id, UsuarioDTO usuarioDTO) {
		
		ModelMapper mm = new ModelMapper();
		Usuario usuario = mm.map(usuarioDTO, Usuario.class);
		usuario.setId(id);
		try {
			return usuarioRepository.save(usuario);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Usuario> getListUsuario() {
		
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		
		return usuarios;
	}

}
