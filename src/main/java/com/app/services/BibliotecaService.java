package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Biblioteca;

@Service
public class BibliotecaService {
	List<Biblioteca> lista = new ArrayList<>();

	public String salvar(Biblioteca biblioteca) {
		lista.add(biblioteca);
		return biblioteca.getBiblioteca() + " Salvo!";
	}	
	
	
	
	public String updade(int id, Biblioteca biblioteca) {
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getIdBiblioteca() == id) {
						lista.set(i, biblioteca);
						return biblioteca.getBiblioteca();
					}
				}
			}
		return null;
	}
	
	public List<Biblioteca> listAll() {
		// TODO Auto-generated method stub
		Biblioteca novaBibilioteca = new Biblioteca (1, "LongTown", "45998335959");
		Biblioteca novaBibilioteca2 = new Biblioteca (2, "Biblioteca Lang", "44999435959");
		Biblioteca novaBibilioteca3 = new Biblioteca (3, "Livros&Co", "43987454343");
		
		lista.add(novaBibilioteca);
		lista.add(novaBibilioteca2);
		lista.add(novaBibilioteca3);
		
		return lista;
	}

	public Biblioteca buscar(long idnovaBibilioteca) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size();) {
					if(lista.get(i).getIdBiblioteca() == idnovaBibilioteca) {}
					return lista.get(i);
				}
			}
			
		return null;
	}

	public String delete(long idnovaBibilioteca) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getIdBiblioteca() == idnovaBibilioteca) {
					lista.remove(i);
					return " removido!";
				}
			}
		}
		return "Not Found!";
	}

}
