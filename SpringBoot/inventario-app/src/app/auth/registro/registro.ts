import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../../usuario';
import { AuthServicio } from '../../servicios/authService';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-registro',
  imports: [
    BrowserModule,
    FormsModule
  ],
  templateUrl: './registro.html'
})
export class Registro {
  usuario: Usuario = {
    userName: '',
    password: '',
    rol: 'USER' // asignado automáticamente
  };

  constructor(private authServicio: AuthServicio, private router: Router) {}

  registrar() {
    this.authServicio.registrar(this.usuario).subscribe({
      next: () => {
        alert('Usuario registrado correctamente');
        this.router.navigate(['/login']);
      },
      error: () => {
        alert('Error al registrar usuario');
      }
    });
  }
}
