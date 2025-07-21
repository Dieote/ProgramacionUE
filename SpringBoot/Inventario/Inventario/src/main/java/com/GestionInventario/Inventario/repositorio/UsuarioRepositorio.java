package com.GestionInventario.Inventario.repositorio;

import com.GestionInventario.Inventario.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUserName(String userName);
}
