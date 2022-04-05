package com.Prueba1.cine.Controllers;

import com.Prueba1.cine.Models.Vista;
import com.Prueba1.cine.Services.VistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vista")
public class VistaController {
    @Autowired
    VistaService vistaService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Vista>> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(vistaService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Vista>> findAll(){
        return new ResponseEntity<>(vistaService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vista> save(@RequestBody Vista vista){
        return new ResponseEntity<>(vistaService.save(vista), HttpStatus.OK);
    }

}
