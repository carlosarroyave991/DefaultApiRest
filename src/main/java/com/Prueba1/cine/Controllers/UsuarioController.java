package com.Prueba1.cine.Controllers;

import com.Prueba1.cine.Models.Usuario;
import com.Prueba1.cine.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuarioModel){
        return usuarioService.guardarUsuario(usuarioModel);
    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> findById(@PathVariable("id") Long id){
        return usuarioService.findById(id);
    }

    @GetMapping("/query")
    public List<Usuario> findByPrioridad(@RequestParam("prioridad") Integer priority){
        return usuarioService.findByPrioridad(priority);
    }

    @DeleteMapping(path = "/{id}")
    public String deletebyId(@PathVariable("id") Long id){
        boolean ok = usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se elimino el usuario con id "+id;
        }else{
            return "No se encontro el usuario con id "+id;
        }
    }
}
