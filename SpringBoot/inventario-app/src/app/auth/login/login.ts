import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Usuario } from '../../usuario';
import { Router } from '@angular/router';
import { AuthServicio } from '../../servicios/authService';

@Component({
  selector: 'app-login',
  imports: [
    BrowserModule,
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

  constructor(private authServicio: AuthServicio, private router: Router) {}

  login() {
    this.authServicio.login(this.usuario).subscribe({
      next: (res) => {
        this.authServicio.setUsuario(res);
        alert('Login exitoso');
        this.router.navigate(['/productos']);
      },
      error: () => {
        alert('Credenciales incorrectas');
      }
    });
  }
}
