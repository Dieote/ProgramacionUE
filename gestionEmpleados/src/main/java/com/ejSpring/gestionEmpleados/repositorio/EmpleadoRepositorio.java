package com.ejSpring.gestionEmpleados.repositorio;

import com.ejSpring.gestionEmpleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleadoRepositorio  extends JpaRepository<Empleado,Integer> {

    @Query("SELECT e FROM Empleado e WHERE " +
            "(:nombreEmpleado IS NULL OR :nombreEmpleado = '' OR LOWER(e.nombreEmpleado) LIKE LOWER(CONCAT('%', " +
            ":nombreEmpleado, '%'))) " +
            "AND " +
            "(:departamento IS NULL OR e.departamento = :departamento)")
    List<Empleado> buscarPorNombreYDepartamento(@Param("nombreEmpleado") String nombreEmpleado, @Param("departamento") String departamento);

    @Query("SELECT DISTINCT e.departamento FROM Empleado e")
    List<String> listarDepartamentosUnicos();

}