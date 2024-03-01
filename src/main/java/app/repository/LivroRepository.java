package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
