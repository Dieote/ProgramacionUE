import { Component, inject } from '@angular/core';
import { Producto } from '../producto';
import { productoServicio } from '../producto.servicio';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  standalone: true,
  templateUrl: './producto-lista.html'
})
export class ProductoLista {
  productos : Producto[];

  private productoServicio = inject(productoServicio);
  private enrutador = inject(Router);

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
        next: (datos) => this.obtenerProductos(),
        error: (errores) => console.log(errores)
      }
    );
  }

}
