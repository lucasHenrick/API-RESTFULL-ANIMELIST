package br.com.teste.animes.api;

import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.animes.domain.Anime;
import br.com.teste.animes.domain.AnimeService;
import br.com.teste.animes.domain.dto.AnimeDTO;

@RestController
@RequestMapping("/api/v1/animes")
public class AnimeControler {
	@Autowired
	private AnimeService service;
	
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<AnimeDTO>> get() {
		return new ResponseEntity<>(service.getAnimes(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnimeDTO> getPorId(@PathVariable("id") Long id) {
		Optional<AnimeDTO> anime = service.getAnimesById(id);

		 return anime.map(a -> ResponseEntity.ok(a)).
					orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<AnimeDTO>> getPorTipo(@PathVariable("tipo") String tipo) {
		List<AnimeDTO> anime =  service.getAnimesByTipo(tipo);
		
		return anime.isEmpty()? 
			ResponseEntity.noContent().build():
			ResponseEntity.ok(anime);
		
	}
	
	@PostMapping()
	public String post(@RequestBody Anime anime) {
		   service.save(anime);
		return "Anime Adicionado com Sucesso";
	}
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Anime anime) {
		anime.setId(id);
		@SuppressWarnings("unused")
		AnimeDTO a = service.update(anime, id);
		return "Anime Atualizado com Sucesso";
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "Anime deletado com sucesso";
	}



}
