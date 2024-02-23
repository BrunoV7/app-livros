package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Editora;

@Service
public class EditoraService {
	List<Editora> lista = new ArrayList<>();

	public String salvar(Editora Editora) {
		lista.add(Editora);
		return Editora.getEditora() + "Salvo!";
	}

	public String updade(int id, Editora Editora) {
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getIdEditora() == id) {
						lista.set(i, Editora);
						return Editora.getEditora();
					}
				}
			}
		return null;
	}

	public List<Editora> listAll() {
		// TODO Auto-generated method stub
		Editora editora = new Editora (1, "LIVROS&CO","ENDEREÇO1", "01999011111");
		Editora editora2 = new Editora (2, "LEGARD22","ENDEREÇO2", "01999012222");
		Editora editora3 = new Editora (3, "DREAMTALE","ENDEREÇO3", "01999013333");
		
		lista.add(editora);
		lista.add(editora2);
		lista.add(editora3);
		
		return lista;
	}

	public Editora buscar(long idEditora) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size();) {
					if(lista.get(i).getIdEditora() == idEditora) {}
					return lista.get(i);
				}
			}
			
		return null;
	}

	public String delete(long idEditora) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getIdEditora() == idEditora) {
					lista.remove(i);
					return "item deletado!";
				}
			}
		}
		return "Not Found!";
	}

}
