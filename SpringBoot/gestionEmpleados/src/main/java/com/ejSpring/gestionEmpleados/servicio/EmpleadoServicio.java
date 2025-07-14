package com.ejSpring.gestionEmpleados.servicio;

import com.ejSpring.gestionEmpleados.modelo.Empleado;
import com.ejSpring.gestionEmpleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleado(Sort sort) {
        return empleadoRepositorio.findAll(sort);
    }

    @Override
    public Empleado buscarIdEmpleado(Integer idEmpleado) {
        Empleado empleado = empleadoRepositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }

    @Override
    public List<Empleado> buscarPorNombreYDepartamento(String nombreEmpleado, String departamento, Sort sort) {
        if (nombreEmpleado != null && departamento != null) {
            return empleadoRepositorio.findByNombreEmpleadoContainingIgnoreCaseAndDepartamento(nombreEmpleado, departamento, sort);
        } else if (nombreEmpleado != null) {
            return empleadoRepositorio.findByNombreEmpleadoContainingIgnoreCase(nombreEmpleado, sort);
        } else if (departamento != null) {
            return empleadoRepositorio.findByDepartamento(departamento, sort);
        } else {
            return empleadoRepositorio.findAll(sort);
        }    }

    @Override
    public List<String> listarDepartamentosUnicos() {
        return empleadoRepositorio.listarDepartamentosUnicos();
    }

    @Override
    public List<Empleado> buscarConFiltro(String nombreEmpleado, String departamento, Sort sort) {
        if (nombreEmpleado != null && departamento != null){
            return empleadoRepositorio.findByNombreEmpleadoContainingIgnoreCaseAndDepartamento(nombreEmpleado, departamento, sort);
        } else if (nombreEmpleado != null){
            return empleadoRepositorio.findByNombreEmpleadoContainingIgnoreCase(nombreEmpleado, sort);
        } else if (departamento != null) {
            return empleadoRepositorio.findByDepartamento(departamento, sort);
        } else {
            return empleadoRepositorio.findAll(sort);
        }
    }

    @Override
    public Double obtenerPromedioSueldos() {
        return empleadoRepositorio.calcularPromedioSueldos();
    }

    @Override
    public Map<String, Long> contarEmpleadosPorDepartamento() {
        List<Object[]> resultado = empleadoRepositorio.contarEmpleadosPorDepartamento();
        return resultado.stream().collect(Collectors.toMap(
                fila -> (String) fila[0],
                fila -> (Long) fila[1]
        ));
    }

    @Override
    public Long contarDepartamentos() {
        return (long) empleadoRepositorio.listarDepartamentosUnicos().size();
    }

}
