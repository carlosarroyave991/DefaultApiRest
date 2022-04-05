package com.Prueba1.cine.Services;

import com.Prueba1.cine.Errors.DefaultException;
import com.Prueba1.cine.Models.Genero;
import com.Prueba1.cine.Repositories.GeneroRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {
    private final static String NOMBRE_YA_EXISTE = "El apodo ya existe en la base de datos";
    private final static String NOMBRE_NO_ENCONTRADO = "El apodo no fue encontrado";
    private final static String ID_NO_ENCONTRADO = "El Id no fue encontrado";
    private final static String ID_YA_EXISTE = "El Id ya existe en la base de datos";

    @Autowired
    GeneroRepository generoRepository;

    public List<Genero> findAll(){
        return (List<Genero>) generoRepository.findAll();
    }

    public Optional<Genero> findById(Long id){
        Optional<Genero> genero = generoRepository.findById(id);
        if (genero.isPresent()){
            return generoRepository.findById(id);
        }else{
            throw new DefaultException(ID_NO_ENCONTRADO);
        }
    }

    public Optional<Genero> findByNombre(String nombre){
        Optional<Genero> result = generoRepository.findByNombre(nombre);
        if (result.isEmpty()){
            throw new DefaultException(NOMBRE_NO_ENCONTRADO);
        }else{
            return generoRepository.findByNombre(nombre);
        }
    }

    public Genero save(@NotNull Genero genero){
        Optional<Genero> result = generoRepository.findById(genero.getId());
        if(result.isPresent()){
            throw new DefaultException(ID_YA_EXISTE);
        }
        return generoRepository.save(genero);

    }

    public void deleteById(Long id){
        Optional<Genero> result = generoRepository.findById(id);
        if(result.isPresent()){
            generoRepository.deleteById(id);
        }else{
            throw new DefaultException(ID_NO_ENCONTRADO);
        }
    }

}
