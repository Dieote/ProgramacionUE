import { Component } from '@angular/core';
import { ProductoLista } from "./producto-lista/producto-lista";

@Component({
  selector: 'app-root',
  imports: [ProductoLista],
  templateUrl: './app.html',
  standalone: true
})
export class App {
  title = 'inventario-app';
}
