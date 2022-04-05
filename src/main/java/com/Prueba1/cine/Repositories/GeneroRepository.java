package com.Prueba1.cine.Repositories;

import com.Prueba1.cine.Models.Genero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long> {
    Optional<Genero> findByNombre(String nombre);
    Optional<Genero> findById(Long id);
    List<Genero> findAll();
    Genero save(Genero genero);
    void deleteById(Long id);
}
