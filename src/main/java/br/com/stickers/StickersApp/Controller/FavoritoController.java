package br.com.stickers.StickersApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stickers.StickersApp.DTO.FavoritoDTO;
import br.com.stickers.StickersApp.Model.Favorito;
import br.com.stickers.StickersApp.Service.FavoritoService;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

	@Autowired
	private FavoritoService favoritoService;
	
	@GetMapping(path = "/list/{id}", produces = "application/json")
	public ResponseEntity<List<Favorito>> getListFavoritos(@PathVariable Long id) {
		
		List<Favorito> response = favoritoService.getListFavoritos(id);
		
		if (response != null) {
			
			return ResponseEntity.ok().body(response);
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> updateListFavoritos(@PathVariable Long id, @RequestBody FavoritoDTO favoritoDTO) {
		
		Boolean response = favoritoService.updateListFavoritos(id, favoritoDTO);
		
		if (response == true) {
			
			return ResponseEntity.ok().build();
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
