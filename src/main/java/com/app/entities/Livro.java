package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
	
	private long IdLivro;
	private String ISSN;
	private String Titulo;
	private String Sinopse;
	private int ano;
	private int NumPag;
}
