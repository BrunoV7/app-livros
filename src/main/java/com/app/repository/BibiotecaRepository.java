package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Biblioteca;

public interface BibiotecaRepository extends JpaRepository<Biblioteca, Long>{

}
