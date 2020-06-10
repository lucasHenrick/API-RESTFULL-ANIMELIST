package br.com.teste.animes.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.teste.animes.domain.dto.AnimeDTO;
@Service
public class AnimeService {
	
	@Autowired
	private AnimeRepository rep;
	@GetMapping()
	public List<AnimeDTO> getAnimes(){
		List<Anime> a = rep.findAll();
		
		List<AnimeDTO> list = new ArrayList<>();
		
		for(Anime anime : a ) {
			list.add(new AnimeDTO(anime));
			
		}
		return list;
	}
	

	public Optional<AnimeDTO> getAnimesById(Long id) {
		return rep.findById(id).map(AnimeDTO :: new);
	}

	public List<AnimeDTO> getAnimesByTipo(String tipo) {
			
			return rep.findByTipo(tipo).stream().map(AnimeDTO::new).collect(Collectors.toList());
	}

	public Anime save(Anime anime) {
		Anime a = rep.save(anime);
		return a;
	}

	public AnimeDTO update(Anime anime, Long id) {
		Assert.notNull(id, "Não foi possivel atualizar o anime!");
		
		
		Optional<Anime> optional = rep.findById(id);
		
		if(optional.isPresent()) {
			Anime db = optional.get();
			
			db.setNome(anime.getNome());
			db.setTipo(anime.getTipo());
			
			rep.save(db);
			return AnimeDTO.create(db);
	         
			
		} else {
			throw new RuntimeException("Não Foi possivel atualizar o anime ! :c ");
		}
		
	}

	public void delete(Long id) {
		Optional<AnimeDTO> anime = getAnimesById(id);
		if(anime.isPresent()) {
			rep.deleteById(id);
		}
		
	}
}
