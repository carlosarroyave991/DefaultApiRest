package com.Prueba1.cine.Controllers;


import com.Prueba1.cine.Models.Pelicula;
import com.Prueba1.cine.Services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>>finAll(){
        return new ResponseEntity<>(peliculaService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Pelicula>> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(peliculaService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity<List<Pelicula>> findByNombre(@RequestParam("nombre") String nombre){
        return new ResponseEntity<>(peliculaService.findByNombre(nombre),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pelicula> save(@RequestBody Pelicula pelicula){
        pelicula.setEstado(true);
        pelicula.setFechaCreacion(LocalDateTime.now());
        return new ResponseEntity<>(peliculaService.save(pelicula), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        peliculaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
