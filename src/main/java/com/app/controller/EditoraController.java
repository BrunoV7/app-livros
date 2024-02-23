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

import com.app.entities.Editora;
import com.app.services.EditoraService;

@RestController
@RequestMapping("/Editora")
public class EditoraController {

	@Autowired
	private EditoraService EditoraServices;

	@PostMapping("/save")
	public ResponseEntity<String> salvar(@RequestBody Editora editora) {

		try {
			String sEditora = this.EditoraServices.salvar(editora);
			return new ResponseEntity<String>(sEditora + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updade/{id}")
	public ResponseEntity<String> update(@RequestBody Editora editora, @PathVariable int id) {
		try {
			String idEditora = this.EditoraServices.updade(id, editora);
			return new ResponseEntity<String>(idEditora + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Editora>> listAll() {
		try {
			List<Editora> listaEditora = this.EditoraServices.listAll();
			return new ResponseEntity<>(listaEditora, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{IdEditora}")
	public ResponseEntity<Editora> buscar(@PathVariable long IdEditora) {

		try {
			Editora editora = this.EditoraServices.buscar(IdEditora);
			return new ResponseEntity<Editora>(editora, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/delete/{idEditora}")
	public ResponseEntity<String> delete(@PathVariable long idEditora) {
		try {
			String msg = this.EditoraServices.delete(idEditora);
			return new ResponseEntity<>(msg, HttpStatus.CONTINUE);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		}
	}
}
