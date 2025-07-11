package com.ejSpring.gestionEmpleados.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ejSpring.gestionEmpleados.servicio.EmpleadoServicio;
import com.ejSpring.gestionEmpleados.modelo.Empleado;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class IndexControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    EmpleadoServicio empleadoServicio;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String listarEmpleados(
            @RequestParam(required = false) String nombreEmpleado,
            @RequestParam(required = false) String departamento,
            @RequestParam(required = false, defaultValue = "idEmpleado") String sort,
            @RequestParam(required = false, defaultValue = "asc") String order,
            Model model){

        if (nombreEmpleado != null && nombreEmpleado.trim().isEmpty()) { nombreEmpleado = null; }
        if (departamento != null && departamento.trim().isEmpty()) { departamento = null; }

        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sortOrden = Sort.by(direction,sort);

        List<Empleado> empleados;

        empleados = empleadoServicio.buscarPorNombreYDepartamento(nombreEmpleado, departamento, sortOrden);

        model.addAttribute("empleados", empleados);
        model.addAttribute("nombreBuscado", nombreEmpleado);
        model.addAttribute("departamentoBuscado", departamento);
        model.addAttribute("sort", sort);
        model.addAttribute("order", order);

        List<String> departamentos = empleadoServicio.listarDepartamentosUnicos();
        model.addAttribute("departamentos", departamentos);

        return "index";//index.jsp
    }

    @RequestMapping(value="/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar";
    }

    @RequestMapping(value="/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a agregar: " + empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";//redirige al path "/"
    }
    @RequestMapping(value="/editar", method = RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo){
        Empleado empleado = empleadoServicio.buscarIdEmpleado(idEmpleado);
        logger.info("Empleado a editar: " + empleado);
        modelo.put("empleado", empleado);
        return "editar";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a guardar (editar): " + empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado){
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleadoServicio.eliminarEmpleado(empleado);
        return "redirect:/";
    }
}