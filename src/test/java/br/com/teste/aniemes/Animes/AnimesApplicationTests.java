package br.com.teste.aniemes.Animes;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.teste.animes.domain.Anime;
import br.com.teste.animes.domain.AnimeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimesApplicationTests {

	@Autowired
	private AnimeService service;
	
	
	@Test
	public void contextLoads() {
		Anime a = new Anime();
		a.setNome("Demon Slayer");
		a.setTipo("Novos");
		service.save(a);
		
	}


}
