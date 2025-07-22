import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../../usuario';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../servicios/authService';

@Component({
  selector: 'app-registro',
  imports: [
    CommonModule,
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

  constructor(private authService: AuthService, private router: Router) {}

  registrar() {
    this.authService.registrar(this.usuario).subscribe({
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
