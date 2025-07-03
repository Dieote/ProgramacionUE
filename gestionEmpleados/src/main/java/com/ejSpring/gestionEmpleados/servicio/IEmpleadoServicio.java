package com.ejSpring.gestionEmpleados.servicio;

import com.ejSpring.gestionEmpleados.modelo.Empleado;
import java.util.List;

public interface IEmpleadoServicio {

    public List<Empleado> listarEmpleado();

    public Empleado buscarIdEmpleado(Integer idEmpleado);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);


}
