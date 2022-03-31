package com.Prueba1.cine.Repositories;

import com.Prueba1.cine.Models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public abstract List<Cliente> findByNombre(String nombre);
    void deleteById(Long id);
    Optional<Cliente> findById(Long id);
    List<Cliente> findAll();
    Cliente save(Cliente cliente);

}
