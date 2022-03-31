package com.Prueba1.cine.Services;

import com.Prueba1.cine.Errors.DefaultException;
import com.Prueba1.cine.Models.Cliente;
import com.Prueba1.cine.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {
    private final static String NOMBRE_YA_EXISTE = "El apodo ya existe en la base de datos";
    private final static String NOMBRE_NO_ENCONTRADO = "El apodo no fue encontrado";
    private final static String ID_NO_ENCONTRADO = "El Id no fue encontrado";
    private final static String ID_YA_EXISTE = "El Id ya existe en la base de datos";

    @Autowired
    ClienteRepository clienteRepository;


    public List<Cliente> findAll(){
        return (List<Cliente>) clienteRepository.findAll();
    }
    public Optional<Cliente> findById(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            return clienteRepository.findById(id);
        }else{
            throw new DefaultException(ID_NO_ENCONTRADO);
        }
    }

    public Cliente save(Cliente cliente){
        Optional<Cliente> result = clienteRepository.findById(cliente.getId());
        if(result.isPresent()){
            throw new DefaultException(ID_YA_EXISTE);
        }else{
            return clienteRepository.save(cliente);
        }
    }

    public List<Cliente> findByNombre(String nombre){
        List<Cliente> clientes = clienteRepository.findByNombre(nombre);
        if(clientes.isEmpty()){
            throw new DefaultException(NOMBRE_NO_ENCONTRADO);
        }else{
            return clienteRepository.findByNombre(nombre);
        }
    }

    public void deleteById(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.deleteById(id);
        }else{
            throw new DefaultException(ID_NO_ENCONTRADO);
        }
    }
}
