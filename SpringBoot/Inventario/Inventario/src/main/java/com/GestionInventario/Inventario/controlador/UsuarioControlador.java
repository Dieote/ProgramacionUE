package com.GestionInventario.Inventario.controlador;

import com.GestionInventario.Inventario.modelo.Usuario;
import com.GestionInventario.Inventario.servicio.IUsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/inventario-app")
@CrossOrigin("http://localhost:4200")
public class UsuarioControlador {

    private IUsuarioServicio usuarioServicio;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioServicio.guardarUsuario(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        Optional<Usuario> encontrado = usuarioServicio.buscarPorUsername(usuario.getUserName());
        if (encontrado.isPresent() && encontrado.get().getPassword().equals(usuario.getPassword())) {
            return ResponseEntity.ok(encontrado.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

