package com.backSwagger.gapsi.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Data
@Table(name = "proveedores")
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 5764431782932395757L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nombre;
    private String razonsocial;
    private String direccion;
}