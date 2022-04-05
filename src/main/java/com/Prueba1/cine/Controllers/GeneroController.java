package com.Prueba1.cine.Controllers;

import com.Prueba1.cine.Models.Genero;
import com.Prueba1.cine.Services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<Genero>> findAll(){
        return new ResponseEntity<>(generoService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Genero>> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(generoService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/query")
    public ResponseEntity<Optional<Genero>> findByNombre(@PathVariable("nombre") String nombre){
        return new ResponseEntity<>(generoService.findByNombre(nombre), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Genero> save(@RequestBody Genero genero){
        genero.setFechaCreacion(LocalDateTime.now());
        return new ResponseEntity<>(generoService.save(genero),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        generoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}