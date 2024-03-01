package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Biblioteca;
import app.services.BibliotecaService;

@RestController
@RequestMapping("/Biblioteca")
public class BibliotecaController {

	@Autowired
	private BibliotecaService BibliotecaService;

	@PostMapping("/save")
	public ResponseEntity<String> salvar(@RequestBody Biblioteca biblioteca) {

		try {
			String NovaBiblioteca = this.BibliotecaService.save(biblioteca);
			return new ResponseEntity<String>(NovaBiblioteca + " foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updade/{id}")
	public ResponseEntity<String> update(@RequestBody Biblioteca biblioteca, @PathVariable int id) {
		try {
			String IdBlibioteca = this.BibliotecaService.update(id, biblioteca);
			return new ResponseEntity<String>(IdBlibioteca + " foi atualizado!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Biblioteca>> listAll() {
		try {
			List<Biblioteca> listaAno = this.BibliotecaService.listAll();
			return new ResponseEntity<>(listaAno, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{IdBlibioteca}")
	public ResponseEntity<Biblioteca> buscar(@PathVariable long IdBlibioteca) {

		try {
			Biblioteca ano = this.BibliotecaService.findById(IdBlibioteca);
			return new ResponseEntity<Biblioteca>(ano, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@DeleteMapping("/delete/{IdBlibioteca}")
	public ResponseEntity<String> delete(@PathVariable long IdBlibioteca) {
		try {
			String msg = this.BibliotecaService.delete(IdBlibioteca);
			return new ResponseEntity<>(msg, HttpStatus.CONTINUE);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		}
	}
}
