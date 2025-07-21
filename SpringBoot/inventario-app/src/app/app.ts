import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from './servicios/authService';

@Component({
  selector: 'app-root',
  imports: [RouterModule],
  templateUrl: './app.html',
  standalone: true
})
export class App {
  title = 'inventario-app';

  constructor(public authService: AuthService, public router: Router) {}

  esAdmin(): boolean {
    return this.authService.esAdmin();
  }

  cerrarSesion() {
    this.authService.setUsuario(null); // limpia sesión
    this.router.navigate(['/login']);
  }
}
