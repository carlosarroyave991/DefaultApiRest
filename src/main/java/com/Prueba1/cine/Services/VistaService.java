package com.Prueba1.cine.Services;

import com.Prueba1.cine.Errors.DefaultException;
import com.Prueba1.cine.Models.Vista;
import com.Prueba1.cine.Repositories.VistaRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VistaService {
    private final static String NOMBRE_YA_EXISTE = "El apodo ya existe en la base de datos";
    private final static String NOMBRE_NO_ENCONTRADO = "El apodo no fue encontrado";
    private final static String ID_NO_ENCONTRADO = "El Id no fue encontrado";
    private final static String ID_YA_EXISTE = "El Id ya existe en la base de datos";

    @Autowired
    VistaRepository vistaRepository;

    public List<Vista> findAll(){
        return (List<Vista>) vistaRepository.findAll();
    }

    public Optional<Vista> findById(Long id){
        Optional<Vista> result = vistaRepository.findById(id);
        if(result.isPresent()){
            return result;
        }else{
            throw new DefaultException(ID_NO_ENCONTRADO);
        }
    }

    public Vista save(@NotNull Vista vista){
        Optional<Vista> result = vistaRepository.findById(vista.getId());
        if (result.isPresent()){
            throw new DefaultException(ID_YA_EXISTE);
        }
        return vistaRepository.save(vista);
    }
}
