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
@Table(name="vistas")
public class Vista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*@Column(name="cliente_id")
    private Long clienteId;
    @Column(name = "pelicula_id")
    private Long peliculaId;*/
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name= "cliente_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "cliente_fk1"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="pelicula_id", insertable = false,updatable = false, foreignKey = @ForeignKey(name = "pelicula_fk1"))
    private Pelicula pelicula;
}
