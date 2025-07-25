import { Component, inject } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Producto } from "../producto";
import { FormsModule } from "@angular/forms";
import { productoServicio } from "../producto.servicio";

@Component({
  selector: 'app-editar-producto',
  imports: [FormsModule],
  standalone: true,
  templateUrl: './editar-producto.html'
})
export class EditarProducto {
  producto: Producto = new Producto();
  id: number;

  private productoServicio = inject(productoServicio);
  private ruta = inject(ActivatedRoute);
  private enrutador= inject(Router);

  ngOnInit() {
    this.id = this.ruta.snapshot.params['id'];
    this.productoServicio.obtenerProductoPorId(this.id).subscribe(
      {
        next: (datos) => this.producto = datos
        ,
        error: (errores: any) => console.log(errores)
      }
    );
  }

   onSubmit(){
    this.guardarProducto();
  }

  guardarProducto(){
    this.productoServicio.editarProducto(this.id, this.producto).subscribe(
      {
        next: (datos) => this.irProductoLista(),
        error: (errores) => console.log(errores)
      }
    );
  }

  irProductoLista(){
    this.enrutador.navigate(['/productos']);
  }
}