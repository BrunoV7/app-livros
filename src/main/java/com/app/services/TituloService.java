package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Titulo;

@Service
public class TituloService {
	List<Titulo> lista = new ArrayList<>();

	public String salvar(Titulo titulo) {
		lista.add(titulo);
		return titulo.getTitulo() + "Salvo!";
	}

	public String updade(int id, Titulo titulo) {
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getIdTitulo() == id) {
						lista.set(i, titulo);
						return titulo.getTitulo();
					}
				}
			}
		return null;
	}

	public List<Titulo> listAll() {
		// TODO Auto-generated method stub
		Titulo titulo = new Titulo (1, "LIVRO1");
		Titulo titulo2 = new Titulo (2, "LIVRO2");
		Titulo titulo3 = new Titulo (3, "LIVRO3");
		
		lista.add(titulo);
		lista.add(titulo2);
		lista.add(titulo3);
		
		return lista;
	}

	public Titulo buscar(long idTitulo) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size();) {
					if(lista.get(i).getIdTitulo() == idTitulo) {}
					return lista.get(i);
				}
			}
			
		return null;
	}

	public String delete(long idTitulo) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getIdTitulo() == idTitulo) {
					lista.remove(i);
					return "item deletado!";
				}
			}
		}
		return "Not Found!";
	}

}
