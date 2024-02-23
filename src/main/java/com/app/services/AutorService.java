package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Autor;

@Service
public class AutorService {
	List<Autor> lista = new ArrayList<>();

	public String salvar(Autor autor) {
		lista.add(autor);
		return autor.getAutor() + "Salvo!";
	}

	public String updade(int id, Autor autor) {
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getIdAutor() == id) {
						lista.set(i, autor);
						return autor.getAutor();
					}
				}
			}
		return null;
	}

	public List<Autor> listAll() {
		// TODO Auto-generated method stub
		Autor autor = new Autor (1, "Jacob Williams");
		Autor autor2 = new Autor (2, "Haven Accord");
		Autor autor3 = new Autor (3, "Fabel Carol");
		
		lista.add(autor);
		lista.add(autor2);
		lista.add(autor3);
		
		return lista;
	}

	public Autor buscar(long idAutor) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size();) {
					if(lista.get(i).getIdAutor() == idAutor) {}
					return lista.get(i);
				}
			}
			
		return null;
	}

	public String delete(long idAutor) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getIdAutor() == idAutor) {
					lista.remove(i);
					return "item deletado!";
				}
			}
		}
		return "Not Found!";
	}

}
