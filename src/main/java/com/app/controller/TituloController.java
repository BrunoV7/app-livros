package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Titulo;
import com.app.services.TituloService;

@RestController
@RequestMapping("/Titulo")
public class TituloController {

	@Autowired
	private TituloService tituloServices;

	@PostMapping("/save")
	public ResponseEntity<String> salvar(@RequestBody Titulo titulo) {

		try {
			String sTitulo = this.tituloServices.salvar(titulo);
			return new ResponseEntity<String>(sTitulo + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updade/{id}")
	public ResponseEntity<String> update(@RequestBody Titulo titulo, @PathVariable int id) {
		try {
			String idTitulo = this.tituloServices.updade(id, titulo);
			return new ResponseEntity<String>(idTitulo + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/ListAll")
	public ResponseEntity<List<Titulo>> listAll() {
		try {
			List<Titulo> listaTitulo = this.tituloServices.listAll();
			return new ResponseEntity<>(listaTitulo, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{IdTitulo}")
	public ResponseEntity<Titulo> buscar(@PathVariable long IdTitulo) {

		try {
			Titulo titulo = this.tituloServices.buscar(IdTitulo);
			return new ResponseEntity<Titulo>(titulo, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/delete/{idTitulo}")
	public ResponseEntity<String> delete(@PathVariable long idTitulo) {
		try {
			String msg = this.tituloServices.delete(idTitulo);
			return new ResponseEntity<>(msg, HttpStatus.CONTINUE);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		}
	}
}
