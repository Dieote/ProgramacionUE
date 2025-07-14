package com.ejSpring.gestionEmpleados.controlador;

import com.ejSpring.gestionEmpleados.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class EstadisticasControlador {

    private static final Logger logger =
    LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    EmpleadoServicio empleadoServicio;

    @RequestMapping(value="/estadisticas", method = RequestMethod.GET)
    public String verEstadisticas(Model model) {

        Double promedioSueldos = empleadoServicio.obtenerPromedioSueldos();
        Map<String, Long> empleadosPorDepartamento = empleadoServicio.contarEmpleadosPorDepartamento();
        Long cantidadDepartamentos = empleadoServicio.contarDepartamentos();

        model.addAttribute("promedioSueldos", promedioSueldos);
        model.addAttribute("empleadosPorDepartamento", empleadosPorDepartamento);
        model.addAttribute("cantidadDepartamentos", cantidadDepartamentos);

        return "estadisticas"; // estadisticas.jsp
    }
}

