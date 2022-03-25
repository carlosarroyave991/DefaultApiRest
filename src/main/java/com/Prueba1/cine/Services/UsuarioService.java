package com.Prueba1.cine.Services;

import com.Prueba1.cine.Models.Usuario;
import com.Prueba1.cine.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

    public List<Usuario> obtenerUsuarios(){
        return (List<Usuario>)usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public List<Usuario> findByPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }


}
