package com.Prueba1.cine.Controllers;

import com.Prueba1.cine.Models.Cliente;
import com.Prueba1.cine.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Optional<Cliente> findById(@PathVariable("id") Long id){
        return clienteService.findById(id);
    }

    @GetMapping("/query")
    public List<Cliente> findByNombre(@RequestParam("nombre") String nombre){
        return clienteService.findByNombre(nombre);
    }
    @PostMapping
    public Cliente saveClient(@RequestBody Cliente cliente){
        return clienteService.saveClient(cliente);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = clienteService.deleteClient(id);
        if(ok == true){
            return "se elimino el cliente con id "+id;
        }else{
            return "No se encontro el usuario con id "+id;
        }
    }
}
