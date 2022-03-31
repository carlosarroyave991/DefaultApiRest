package com.Prueba1.cine.Controllers;

import com.Prueba1.cine.Models.Cliente;
import com.Prueba1.cine.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity<List<Cliente>> findByNombre(@RequestParam("nombre") String nombre){
        return new ResponseEntity<>(clienteService.findByNombre(nombre), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        cliente.setEstado(true);
        cliente.setFechaCreacion(LocalDateTime.now());
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        clienteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
