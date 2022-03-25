package com.Prueba1.cine.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String nombre;
    private String imagen;
    //private String url;
    @Column(name ="fecha_estreno")
    private LocalDate fechaEstreno;
    @Column(name ="fecha_creacion")
    private LocalDateTime fechaCreacion;
    private Boolean estado;

    @OneToMany(mappedBy = "pelicula")
    private List<Vista> vistas;

    @OneToMany(mappedBy = "pelicula")
    private List<PeliculaGenero> peliculaGeneros;
}
