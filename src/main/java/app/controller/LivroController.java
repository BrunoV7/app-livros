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

import app.entities.Livro;
import app.services.LivroService;

@RestController
@RequestMapping("/Livro")
public class LivroController {

	@Autowired
	private LivroService tituloServices;

	@PostMapping("/save")
	public ResponseEntity<String> salvar(@RequestBody Livro titulo) {

		try {
			String sTitulo = this.tituloServices.save(titulo);
			return new ResponseEntity<String>(sTitulo + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updade/{id}")
	public ResponseEntity<String> update(@RequestBody Livro titulo, @PathVariable int id) {
		try {
			String idTitulo = this.tituloServices.update(id, titulo);
			return new ResponseEntity<String>(idTitulo + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Livro>> listAll() {
		try {
			List<Livro> listaTitulo = this.tituloServices.listAll();
			return new ResponseEntity<>(listaTitulo, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{IdTitulo}")
	public ResponseEntity<Livro> buscar(@PathVariable long IdTitulo) {

		try {
			Livro titulo = this.tituloServices.findById(IdTitulo);
			return new ResponseEntity<Livro>(titulo, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@DeleteMapping("/delete/{idTitulo}")
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
