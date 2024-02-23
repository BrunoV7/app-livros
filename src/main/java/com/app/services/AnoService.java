package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Ano;

@Service
public class AnoService {
	List<Ano> lista = new ArrayList<>();

	public String salvar(Ano ano) {
		lista.add(ano);
		return ano.getAno() + "Salvo!";
	}

	public int updade(int id, Ano ano) {
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getIdAno() == id) {
						lista.set(i, ano);
						return ano.getAno();
					}
				}
			}
		return id;
	}

	public List<Ano> listAll() {
		// TODO Auto-generated method stub
		Ano Ano = new Ano (1, 2022);
		Ano Ano2 = new Ano (2, 2017);
		Ano Ano3 = new Ano (3, 2024);
		
		lista.add(Ano);
		lista.add(Ano2);
		lista.add(Ano3);
		
		return lista;
	}

	public Ano buscar(long idano) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		if(lista != null) {
			for(int i = 0; i < lista.size();) {
					if(lista.get(i).getIdAno() == idano) {}
					return lista.get(i);
				}
			}
			
		return null;
	}

	public String delete(long idano) {
		// TODO Auto-generated method stub
		lista = this.listAll();
		
		if(lista != null) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getIdAno() == idano) {
					lista.remove(i);
					return "item deletado!";
				}
			}
		}
		return "Not Found!";
	}

}
