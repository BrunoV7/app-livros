package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Biblioteca;

public interface BibiotecaRepository extends JpaRepository<Biblioteca, Long>{

}
