import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from './servicios/authService';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterModule, CommonModule],
  templateUrl: './app.html',
  standalone: true
})
export class App {
  title = 'inventario-app';

  constructor(public authService: AuthService, private router: Router) {}

  esAdmin(): boolean {
    return this.authService.esAdmin();
  }

  cerrarSesion() {
    this.authService.setUsuario(null); // limpia sesión
    this.router.navigate(['/login']);
  }
}
