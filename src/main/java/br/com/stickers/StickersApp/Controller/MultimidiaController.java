package br.com.stickers.StickersApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stickers.StickersApp.DTO.MultimidiaDTO;
import br.com.stickers.StickersApp.Model.Multimidia;
import br.com.stickers.StickersApp.Service.MultimidiaService;

@RestController
@RequestMapping("/multimidia")
public class MultimidiaController {
	
	@Autowired
	private MultimidiaService multimidiaService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Multimidia>> getListMultimidia() {
		
		List<Multimidia> response = multimidiaService.getListMultimidia();
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = "/{genero}", produces = "application/json")
	public ResponseEntity<List<Multimidia>> getListMultimidiaByGenero(@PathVariable String genero) {
		
		List<Multimidia> response = multimidiaService.getListMultimidiaByGenero(genero);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = "/{tipo}", produces = "application/json")
	public ResponseEntity<List<Multimidia>> getListMultimidia(@PathVariable String tipo) {
		
		List<Multimidia> response = multimidiaService.getListMultimidiaByTipo(tipo);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Boolean> deleteMultimidia(@PathVariable Long multimidiaId) {
		
		Boolean response = multimidiaService.deleteMultimidia(multimidiaId);
		
		if (response == true) {
			
			return ResponseEntity.ok().build();
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<Boolean> postMultimidia(@RequestBody MultimidiaDTO multimidiaDTO) {
		
		Boolean response = multimidiaService.postMultimidia(multimidiaDTO);
		
		if (response == true) {
			
			return ResponseEntity.ok().build();
			
		}
		
		return ResponseEntity.notFound().build();
		
	}

}
