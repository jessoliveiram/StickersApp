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

import br.com.stickers.StickersApp.DTO.AndamentoUsuarioDTO;
import br.com.stickers.StickersApp.Model.AndamentoUsuario;
import br.com.stickers.StickersApp.Service.AndamentoUsuarioService;

@RestController
@RequestMapping("/assistidos")
public class AndamentoUsuarioController {

	@Autowired
	private AndamentoUsuarioService andamentoUsuarioService;
	
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<AndamentoUsuario> getAndamentoUsuario(@PathVariable Long id) {
		
		AndamentoUsuario response = andamentoUsuarioService.getAndamentoUsuario(id);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.notFound().build();				
	}
	
	@GetMapping(path = "/list/{id}", produces = "application/json")
	public ResponseEntity<List<AndamentoUsuario>> getListAndamentoUsuario(@PathVariable Long id) {
		
		List<AndamentoUsuario> response = andamentoUsuarioService.getListAndamentoUsuarioByUsuario(id);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path="/finalizados/{id}", produces = "application/json")
	public ResponseEntity<List<AndamentoUsuario>> getListAndamentoUsuarioCompleto(@PathVariable Long id) {
		
		List<AndamentoUsuario> response = andamentoUsuarioService.getListAndamentoUsuarioCompletoByUsuario(id);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<List<AndamentoUsuario>> getListAndamentoUsuario() {
		
		List<AndamentoUsuario> response = andamentoUsuarioService.getListAndamentoUsuario();
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping(path="/{id}", produces = "application/json")
	public ResponseEntity<AndamentoUsuario> createAndamentoUsuario(@PathVariable Long id, @RequestBody AndamentoUsuarioDTO andamentoUsuarioDTO) {
		
		AndamentoUsuario response = andamentoUsuarioService.createAndamentoUsuario(id, andamentoUsuarioDTO);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path="/{id}", produces = "application/json")
	public ResponseEntity<Boolean> deleteAndamentoUsuario(@PathVariable Long id) {
		
		Boolean response = andamentoUsuarioService.deleteAndamentoUsuario(id);
		
		if (response == true) {
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<AndamentoUsuario> updateEpisodios(@PathVariable Long id, @RequestBody AndamentoUsuarioDTO andamentoUsuarioDTO) {
		
		AndamentoUsuario response = andamentoUsuarioService.updateEpisodios(id, andamentoUsuarioDTO);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.notFound().build();
	}
}
