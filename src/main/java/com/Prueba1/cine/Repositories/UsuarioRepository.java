package com.Prueba1.cine.Repositories;

import com.Prueba1.cine.Models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    public abstract List<Usuario> findByPrioridad(Integer prioridad);
}
