package com.Prueba1.cine.Repositories;

import com.Prueba1.cine.Models.PeliculaGenero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaGeneroRepository extends CrudRepository<PeliculaGenero, Long> {
    Optional<PeliculaGenero> findById(Long id);
    List<PeliculaGenero> findAll();
    PeliculaGenero save(PeliculaGenero peliculaGenero);
}
