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

import com.app.entities.Autor;
import com.app.services.AutorService;

@RestController
@RequestMapping("/Autor")
public class AutorController {

	@Autowired
	private AutorService AutorServices;

	@PostMapping("/save")
	public ResponseEntity<String> salvar(@RequestBody Autor autor) {

		try {
			String sAutor = this.AutorServices.salvar(autor);
			return new ResponseEntity<String>(sAutor + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updade/{id}")
	public ResponseEntity<String> update(@RequestBody Autor autor, @PathVariable int id) {
		try {
			String idAutor = this.AutorServices.updade(id, autor);
			return new ResponseEntity<String>(idAutor + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/ListAll")
	public ResponseEntity<List<Autor>> listAll() {
		try {
			List<Autor> listaAutor = this.AutorServices.listAll();
			return new ResponseEntity<>(listaAutor, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{IdAutor}")
	public ResponseEntity<Autor> buscar(@PathVariable long IdAutor) {

		try {
			Autor autor = this.AutorServices.buscar(IdAutor);
			return new ResponseEntity<Autor>(autor, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/delete/{idAutor}")
	public ResponseEntity<String> delete(@PathVariable long idAutor) {
		try {
			String msg = this.AutorServices.delete(idAutor);
			return new ResponseEntity<>(msg, HttpStatus.CONTINUE);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		}
	}
}
