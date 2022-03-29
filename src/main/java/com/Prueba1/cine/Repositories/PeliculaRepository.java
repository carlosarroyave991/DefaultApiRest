package com.Prueba1.cine.Repositories;

import com.Prueba1.cine.Models.Pelicula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {

    public abstract List<Pelicula> findByNombre(String nombre);
}
