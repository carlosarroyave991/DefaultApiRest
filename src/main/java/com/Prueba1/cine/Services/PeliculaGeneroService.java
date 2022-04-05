package com.Prueba1.cine.Services;

import com.Prueba1.cine.Errors.DefaultException;
import com.Prueba1.cine.Models.PeliculaGenero;
import com.Prueba1.cine.Repositories.PeliculaGeneroRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaGeneroService {
    private final static String NOMBRE_YA_EXISTE = "El apodo ya existe en la base de datos";
    private final static String NOMBRE_NO_ENCONTRADO = "El apodo no fue encontrado";
    private final static String ID_NO_ENCONTRADO = "El Id no fue encontrado";
    private final static String ID_YA_EXISTE = "El Id ya existe en la base de datos";

    @Autowired
    PeliculaGeneroRepository pgr;

    public List<PeliculaGenero> findAll(){
        return pgr.findAll();
    }

    public Optional<PeliculaGenero> findById(Long id){
        Optional<PeliculaGenero> result = pgr.findById(id);
        if(result.isPresent()){
            return result;
        }else {
            throw new DefaultException(ID_NO_ENCONTRADO);
        }
    }

    public PeliculaGenero save(@NotNull PeliculaGenero pg){
        Optional<PeliculaGenero> result = pgr.findById(pg.getId());
        if(result.isEmpty()){
            throw new DefaultException(ID_YA_EXISTE);
        }
        return pgr.save(pg);
    }

}
