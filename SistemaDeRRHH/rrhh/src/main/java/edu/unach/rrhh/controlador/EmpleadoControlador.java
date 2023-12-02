package edu.unach.rrhh.controlador;

import edu.unach.rrhh.modelo.Empleado;
import edu.unach.rrhh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rrhh")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private IEmpleadoServicio iEmpleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados(){
        return iEmpleadoServicio.listarEmpleados();
    }
}
