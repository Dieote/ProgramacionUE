import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Usuario } from '../../usuario';
import { Router } from '@angular/router';
import { AuthService } from '../../servicios/authService';

@Component({
  selector: 'app-login',
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './login.html',
})
export class Login {
  usuario: Usuario = {
    userName: '',
    password: '',
    rol: ''
  };

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.usuario).subscribe({
      next: (res) => {
        this.authService.setUsuario(res);
        alert('Login exitoso');
        this.router.navigate(['/productos']);
      },
      error: () => {
        alert('Credenciales incorrectas');
      }
    });
  }
}
