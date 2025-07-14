package com.GestionInventario.Inventario.servicio;

import com.GestionInventario.Inventario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    List<Producto> listarProductos();

    Producto buscarProductoPorId(Integer idProducto);

    void guardarProducto(Producto producto);

    void eliminarProductoPorId(Integer idProducto);

}
