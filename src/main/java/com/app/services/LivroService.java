package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Livro;

@Service
public class LivroService {
	List<Livro> lista = new ArrayList<>();

	public String salvar(Livro novoLivro) {
		lista.add(novoLivro);
		return novoLivro.getTitulo() + " foi salvo!";
	}

	public String updade(int id, Livro novoLivro) {
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getIdLivro() == id) {
						lista.set(i, novoLivro);
						return novoLivro.getTitulo();
					}
				}
			}
		return null;
	}

	public List<Livro> listAll() {
		// TODO Auto-generated method stub
		Livro livro = new Livro (1, "SNSS010101", "TITULO1", "SINOPSE1", 2022, 300);
		Livro livro2 = new Livro (2, "SNSS010102", "TITULO2", "SINOPSE2", 2019, 450);
		Livro livro3 = new Livro (3, "SNSS010103", "TITULO3", "SINOPSE3", 2023, 193);
		
		lista.add(livro);
		lista.add(livro2);
		lista.add(livro3);
		
		return lista;
	}

	public Livro buscar(long idLivro) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size();) {
					if(lista.get(i).getIdLivro() == idLivro) {}
					return lista.get(i);
				}
			}
			
		return null;
	}

	public String delete(long idLivro) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getIdLivro() == idLivro) {
					lista.remove(i);
					return "item deletado!";
				}
			}
		}
		return "Not Found!";
	}

}
