package com.ejSpring.gestionEmpleados.repositorio;

import com.ejSpring.gestionEmpleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio  extends JpaRepository<Empleado,Integer> {
}
