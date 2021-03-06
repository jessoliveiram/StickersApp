package br.com.stickers.StickersApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stickers.StickersApp.DTO.UsuarioDTO;
import br.com.stickers.StickersApp.Model.Usuario;
import br.com.stickers.StickersApp.Service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
		
		Usuario response = usuarioService.getUsuario(id);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Usuario>> getListUsuario() {
		
		List<Usuario> response = usuarioService.getListUsuario();
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		
		Usuario response = usuarioService.createUsuario(usuarioDTO);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.notFound().build(); 
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Boolean> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
		
		Boolean response = usuarioService.updateUsuario(id, usuarioDTO);
		
		if (response == true) {
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Boolean> updateUsuario(@PathVariable Long id) {
		
		Boolean response = usuarioService.deleteUsuario(id);
		
		if (response == true) {
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
