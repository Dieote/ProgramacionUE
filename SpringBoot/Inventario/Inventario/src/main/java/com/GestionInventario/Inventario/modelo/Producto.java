package com.GestionInventario.Inventario.modelo;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("precio")
    private Double precio;
    @JsonProperty("existencia")
    private Integer existencia;
}
