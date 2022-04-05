package com.Prueba1.cine.Controllers;

import com.Prueba1.cine.Models.PeliculaGenero;
import com.Prueba1.cine.Services.PeliculaGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PeliculaGenero")
public class PeliculaGeneroController {
    @Autowired
    PeliculaGeneroService pgs;

    @GetMapping
    public ResponseEntity<List<PeliculaGenero>> findAll(){
        return new ResponseEntity<>(pgs.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<PeliculaGenero>> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(pgs.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PeliculaGenero> save(@RequestBody PeliculaGenero pg){
        return new ResponseEntity<>(pgs.save(pg), HttpStatus.OK);
    }
}
