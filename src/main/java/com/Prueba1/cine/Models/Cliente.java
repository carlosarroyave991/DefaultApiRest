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
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String documento;
    private String nombre;
    private String apellido;
    private String apodo;
    private String correo;
    private String contrasena;
    private Boolean estado;
    @Column(name ="fecha_creacion")
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "cliente")
    private List<Vista> vistas;
}
