package br.com.stickers.StickersApp.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stickers.StickersApp.DTO.MultimidiaDTO;
import br.com.stickers.StickersApp.Model.Multimidia;
import br.com.stickers.StickersApp.Repository.MultimidiaRepository;

@Service
public class MultimidiaService {

	@Autowired
	private MultimidiaRepository multimidiaRepository;
	
	
	public List<Multimidia> getListMultimidia() {
		
		List<Multimidia> listMultimidia = multimidiaRepository.findAll();
			
		return listMultimidia;
		
	}
	
	public List<Multimidia> getListMultimidiaByGenero(String genero) {
		
		List<Multimidia> listMultimidia = multimidiaRepository.findByGenero(genero);
				
		return listMultimidia;
		
	}
	
	public List<Multimidia> getListMultimidiaByTipo(String tipo) {
		
		List<Multimidia> listMultimidia = multimidiaRepository.findByTipo(tipo);
		
		return listMultimidia;
		
	}

	public Multimidia createMultimidia(MultimidiaDTO multimidiaDTO) {
		
		ModelMapper mm = new ModelMapper();
		Multimidia Multimidia = mm.map(multimidiaDTO, Multimidia.class);
		try {
			return multimidiaRepository.save(Multimidia);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Boolean deleteMultimidia(Long multimidiaId) {
		
		try {
			multimidiaRepository.deleteById(multimidiaId);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
