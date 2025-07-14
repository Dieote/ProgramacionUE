package com.GestionInventario.Inventario.repositorio;

import com.GestionInventario.Inventario.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
