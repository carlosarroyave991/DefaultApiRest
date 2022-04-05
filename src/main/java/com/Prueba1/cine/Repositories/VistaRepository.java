package com.Prueba1.cine.Repositories;

import com.Prueba1.cine.Models.Vista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VistaRepository extends CrudRepository<Vista , Long> {
    Optional<Vista> findById(Long id);
    List<Vista>findAll();
    Vista save(Vista vista);
}
