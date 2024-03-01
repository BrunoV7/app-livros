package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Editora;
import com.app.repository.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository editoraRepository;

	public String save(Editora Editora) {
		this.editoraRepository.save(Editora);
		return Editora.getEditora() + "Salvo!";
	}

	public String update(int id, Editora Editora) {
		
		Editora.setIdEditora(id);
		this.editoraRepository.save(Editora);
		return Editora.getEditora() + " adicionada!";
		
	}

	public List<Editora> listAll() {
		
		return this.editoraRepository.findAll();
		
	}

	public Editora findById(long idEditora) {
		
		Editora Editora = this.editoraRepository.findById(idEditora).get();
		return Editora;
	}

	public String delete(long idEditora) {
		this.editoraRepository.deleteById(idEditora);
		return null;
	}

}
