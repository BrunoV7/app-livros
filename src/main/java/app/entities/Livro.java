package app.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLivro;
	
	private String issn;
	private String titulo;
	private int ano;
	private int numPag;

	private String sinopse;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livros")
	private Biblioteca biblioteca;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livros")
	private Editora editora;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="autor_livro")
	private List<Autor> autores;
}
