package gm.inventarios;

import gm.inventarios.modelo.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventariosApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventariosApplication.class, args);

		// Prueba de Lombok: Crear un objeto Producto y usar toString()
		Producto producto = new Producto();
		producto.setIdProducto(1);
		producto.setDescripcion("Pantalon");
		producto.setPrecio(300.0);
		producto.setExistencia(100);

		// Imprimir el objeto usando toString() de Lombok
		System.out.println(producto);

		// Probar los getters y setters generados por Lombok
		producto.setDescripcion("Laptop Gamer");
		producto.setPrecio(2000.00);
		System.out.println("Descripción nueva: " + producto.getDescripcion());
		System.out.println("Precio nuevo: " + producto.getPrecio());
	}
}
