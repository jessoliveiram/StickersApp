package br.com.stickers.StickersApp.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<ArrayList<AndamentoUsuario>> getListAndamentoUsuario() {
		
		ArrayList<AndamentoUsuario> response = (ArrayList<AndamentoUsuario>) andamentoUsuarioService.getListAndamentoUsuario();
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
			
		}
		
		return ResponseEntity.notFound().build();
	}
	@GetMapping(path="/finalizados", produces = "application/json")
	public ResponseEntity<ArrayList<AndamentoUsuario>> getListAndamentoUsuarioCompleto() {
		
		ArrayList<AndamentoUsuario> response = (ArrayList<AndamentoUsuario>) andamentoUsuarioService.getListAndamentoUsuarioCompleto();
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Optional<AndamentoUsuario>> getAndamentoUsuarioById(@PathVariable Long id) {
		
		Optional<AndamentoUsuario> response = andamentoUsuarioService.getAndamentoUsuarioById(id);
		
		if (response.isPresent()) {
			
			return ResponseEntity.ok().body(response);
			
		}
		
		return ResponseEntity.notFound().build();				
	}
	
	@PostMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<AndamentoUsuario> updateAndamentoUsuario(@RequestBody AndamentoUsuarioDTO andamentoUsuarioDTO) {
		
		AndamentoUsuario response = andamentoUsuarioService.updateAndamentoUsuario(andamentoUsuarioDTO);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
			
		}
		
		return ResponseEntity.notFound().build();
	}
}
