package com.ejSpring.gestionEmpleados.repositorio;

import com.ejSpring.gestionEmpleados.modelo.Empleado;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepositorio  extends JpaRepository<Empleado,Integer> {

    List<Empleado> findByNombreEmpleadoContainingIgnoreCaseAndDepartamento(String nombreEmpleado, String departamento, Sort sort);

    List<Empleado> findByNombreEmpleadoContainingIgnoreCase(String nombreEmpleado, Sort sort);

    List<Empleado> findByDepartamento(String departamento, Sort sort);

    @Query("SELECT DISTINCT e.departamento FROM Empleado e")
    List<String> listarDepartamentosUnicos();
}
