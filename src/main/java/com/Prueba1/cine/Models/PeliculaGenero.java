package com.Prueba1.cine.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pelicula_genero")
public class PeliculaGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pelicula_id")
    private Integer peliculaId;
    @Column(name= "genero_id")
    private Integer generoId;
    @ManyToOne
    @JoinColumn(name="pelicula_id", insertable = false,updatable = false, foreignKey = @ForeignKey(name = "pelicula_id"))
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "genero_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "genero_id"))
    private Genero genero;
}
