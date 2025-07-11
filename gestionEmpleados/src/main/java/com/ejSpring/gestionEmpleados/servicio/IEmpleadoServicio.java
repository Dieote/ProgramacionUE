package com.ejSpring.gestionEmpleados.servicio;

import com.ejSpring.gestionEmpleados.modelo.Empleado;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface IEmpleadoServicio {

    public List<Empleado> listarEmpleado(Sort sort);

    public Empleado buscarIdEmpleado(Integer idEmpleado);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);

    public List<Empleado> buscarPorNombreYDepartamento(String nombreEmpleado, String departamento, Sort sort);

    public List<String> listarDepartamentosUnicos();

    List<Empleado> buscarConFiltro(String nombreEmpleado, String departamento, Sort sort);

    Double obtenerPromedioSueldos();

    Map<String, Long> contarEmpleadosPorDepartamento();

    Long contarDepartamentos();
}
