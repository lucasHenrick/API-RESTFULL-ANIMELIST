package br.com.teste.animes.domain.dto;





import org.modelmapper.ModelMapper;

import br.com.teste.animes.domain.Anime;


public class AnimeDTO {
	
	
	
	private long id;
	
	private String nome;
	
	private String tipo;
	
	public AnimeDTO() {
		
	}
	
	public AnimeDTO(Anime a) {
		this.id = a.getId();
		this.nome = a.getNome();
		this.tipo = a.getTipo();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	 public static AnimeDTO create(Anime anime) {
	        ModelMapper modelMapper = new ModelMapper();
	        return modelMapper.map(anime, AnimeDTO.class);
	    }
	
	
}
