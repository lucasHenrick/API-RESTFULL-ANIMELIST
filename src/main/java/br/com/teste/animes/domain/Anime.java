package br.com.teste.animes.domain;

import javax.persistence.*;

import org.modelmapper.ModelMapper;

import br.com.teste.animes.domain.dto.AnimeDTO;

@Entity(name = "anime")
public class Anime {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nome")
	private String nome;
	
	private String tipo;
	
	public Anime() {
		
	}
	
	public Anime(long id, String nome) {
		this.id = id;
		this.nome = nome;
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
	public static AnimeDTO create(Anime a) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(a, AnimeDTO.class);
    }
	
}
