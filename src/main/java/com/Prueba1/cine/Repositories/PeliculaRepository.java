package com.Prueba1.cine.Repositories;

import com.Prueba1.cine.Models.Pelicula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {

    List<Pelicula> findByNombre(String nombre);
    void deleteById(Long id);
    Optional<Pelicula> findById(Long id);
    List<Pelicula> findAll();
    Pelicula save(Pelicula pelicula);

}
