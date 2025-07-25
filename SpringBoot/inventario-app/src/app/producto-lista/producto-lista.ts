import { Component, inject } from '@angular/core';
import { Producto } from '../producto';
import { Router } from '@angular/router';
import { productoServicio } from '../producto.servicio';
import { AuthService } from '../servicios/authService';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-producto-lista',
  standalone: true,
  templateUrl: './producto-lista.html',
  imports: [CommonModule]
})
export class ProductoLista {
  productos : Producto[];

  private productoServicio = inject(productoServicio);
  private enrutador = inject(Router);
  public authService = inject(AuthService);

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

   editarProducto(id: number){
    this.enrutador.navigate(['editar-producto', id]);
  }

  eliminarProducto(id: number) {
    this.productoServicio.eliminarProducto(id).subscribe(
      {
        next: () => this.obtenerProductos(),
        error: (errores) => console.log(errores)
      }
    );
  }

}
