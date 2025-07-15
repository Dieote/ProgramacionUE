import { Component, inject } from '@angular/core';
import { Producto } from '../producto';
import { productoServicio } from '../producto.servicio';

@Component({
  selector: 'app-producto-lista',
  standalone: true,
  imports: [],
  templateUrl: './producto-lista.html'
})
export class ProductoLista {
  productos : Producto[];

  private productoServicio = inject(productoServicio);

  ngOnInit() {
    this.obtenerProductos();
  }
  private obtenerProductos(): void {
    this.productoServicio.obtenerProductos().subscribe({
        next: (datos) => {
            this.productos = datos;
        },
        error: (error) => {
            console.error('Error al obtener productos:', error);
        }
    });
  }
}
