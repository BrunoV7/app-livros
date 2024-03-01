package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Livro;
import com.app.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	public String save(Livro livro) {
		this.livroRepository.save(livro);
		return livro.getEditora() + "Salvo!";
	}

	public String update(int id, Livro livro) {
		
		livro.setIdLivro(id);
		this.livroRepository.save(livro);
		return livro.getEditora() + " adicionada!";
		
	}

	public List<Livro> listAll() {
		
		return this.livroRepository.findAll();
		
	}

	public Livro findById(long idEditora) {
		
		Livro livro = this.livroRepository.findById(idEditora).get();
		return livro;
	}

	public String delete(long idEditora) {
		this.livroRepository.deleteById(idEditora);
		return null;
	}

}
