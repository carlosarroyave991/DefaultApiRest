package com.Prueba1.cine.Services;

import com.Prueba1.cine.Errors.DefaultException;
import com.Prueba1.cine.Models.Pelicula;
import org.jetbrains.annotations.NotNull;
import com.Prueba1.cine.Repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    private final static String NOMBRE_YA_EXISTE = "El apodo ya existe en la base de datos";
    private final static String NOMBRE_NO_ENCONTRADO = "El apodo no fue encontrado";
    private final static String ID_NO_ENCONTRADO = "El Id no fue encontrado";
    private final static String ID_YA_EXISTE = "El Id ya existe en la base de datos";

    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Pelicula> findAll(){
        return (List<Pelicula>) peliculaRepository.findAll();
    }

    public Optional<Pelicula> findById(Long id){
        Optional<Pelicula> pelicula = peliculaRepository.findById(id);
        if (pelicula.isPresent()){
            return peliculaRepository.findById(id);
        }else{
            throw new DefaultException(ID_NO_ENCONTRADO);
        }
    }

    public List<Pelicula> findByNombre(String nombre){
        List<Pelicula> pelicula = peliculaRepository.findByNombre(nombre);
        if (pelicula.isEmpty()){
            throw new DefaultException(NOMBRE_NO_ENCONTRADO);
        }else{
            return peliculaRepository.findByNombre(nombre);
        }
    }

    public Pelicula save(@NotNull Pelicula pelicula){
        Optional<Pelicula> result = peliculaRepository.findById(pelicula.getId());
        if (result.isPresent()){
            throw new DefaultException(ID_YA_EXISTE);
        }
        return peliculaRepository.save(pelicula);

    }

    public void deleteById(Long id){
        Optional<Pelicula> result = peliculaRepository.findById(id);
        if (result.isPresent()){
            peliculaRepository.deleteById(id);
        }else{
            throw new DefaultException(ID_NO_ENCONTRADO);
        }
    }


}
