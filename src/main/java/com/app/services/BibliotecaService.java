package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Biblioteca;
import com.app.repository.BibiotecaRepository;

@Service
public class BibliotecaService {
	
	@Autowired
	private BibiotecaRepository bibiotecaRepository;

	public String save(Biblioteca biblioteca) {
		this.bibiotecaRepository.save(biblioteca);
		return biblioteca.getBiblioteca() + "Salvo!";
	}

	public String update(int id, Biblioteca biblioteca) {
		
		biblioteca.setIdBiblioteca(id);
		this.bibiotecaRepository.save(biblioteca);
		return biblioteca.getBiblioteca() + " adicionada!";
		
	}

	public List<Biblioteca> listAll() {
		
		return this.bibiotecaRepository.findAll();
		
	}

	public Biblioteca findById(long idbiblioteca) {
		
		Biblioteca biblioteca = this.bibiotecaRepository.findById(idbiblioteca).get();
		return biblioteca;
	}

	public String delete(long idbiblioteca) {
		this.bibiotecaRepository.deleteById(idbiblioteca);
		return null;
	}

}
