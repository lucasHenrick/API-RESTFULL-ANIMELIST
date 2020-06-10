package br.com.teste.animes.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




public interface AnimeRepository  extends JpaRepository<Anime, Long>{

	List<Anime> findByTipo(String tipo);

	

}
