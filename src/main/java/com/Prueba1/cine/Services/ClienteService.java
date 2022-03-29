package com.Prueba1.cine.Services;

import com.Prueba1.cine.Models.Cliente;
import com.Prueba1.cine.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Optional<Cliente> findById(Long id){
        return clienteRepository.findById(id);
    }

    public List<Cliente> findAll(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Cliente saveClient(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findByNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }

    public boolean deleteClient(Long id){
        try {
            clienteRepository.findById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
