package com.GestionInventario.Inventario.servicio;

import com.GestionInventario.Inventario.modelo.Usuario;

import java.util.Optional;

public interface IUsuarioServicio {

    Optional<Usuario> buscarPorUsername(String userName);

    Usuario guardarUsuario(Usuario usuario);

}
