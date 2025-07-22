import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Producto } from '../producto';
import { Router } from '@angular/router';
import { productoServicio } from '../producto.servicio';

@Component({
  selector: 'app-agregar-producto',
  imports: [FormsModule],
  templateUrl: './agregar-producto.html',
})
export class AgregarProducto {
  producto: Producto = new Producto();

  private productoServicio = inject(productoServicio);
  private enrutador = inject(Router);
  
  onSubmit() {
    this.guardarProducto();
  }

  guardarProducto() {
    this.productoServicio.agregarProducto(this.producto).subscribe(
      {
        next: () => {
          this.irListaProductos();
        },
        error: (error: any) => { console.log(error) }
      }
    );
  }

  irListaProductos() {
    this.enrutador.navigate(['/productos']);
  }
}
