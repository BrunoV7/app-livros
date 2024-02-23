package com.app.controller;

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

import com.app.entities.Ano;
import com.app.services.AnoService;

@RestController
@RequestMapping("/Ano")
public class AnoController {

	@Autowired
	private AnoService AnoServices;

	@PostMapping("/save")
	public ResponseEntity<String> salvar(@RequestBody Ano ano) {

		try {
			String sAno = this.AnoServices.salvar(ano);
			return new ResponseEntity<String>(sAno + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updade/{id}")
	public ResponseEntity<String> update(@RequestBody Ano ano, @PathVariable int id) {
		try {
			int idAno = this.AnoServices.updade(id, ano);
			return new ResponseEntity<String>(idAno + "foi incluido!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Ano>> listAll() {
		try {
			List<Ano> listaAno = this.AnoServices.listAll();
			return new ResponseEntity<>(listaAno, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{IdAno}")
	public ResponseEntity<Ano> buscar(@PathVariable long IdAno) {

		try {
			Ano ano = this.AnoServices.buscar(IdAno);
			return new ResponseEntity<Ano>(ano, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@DeleteMapping("/delete/{idAno}")
	public ResponseEntity<String> delete(@PathVariable long idAno) {
		try {
			String msg = this.AnoServices.delete(idAno);
			return new ResponseEntity<>(msg, HttpStatus.CONTINUE);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		}
	}
}
