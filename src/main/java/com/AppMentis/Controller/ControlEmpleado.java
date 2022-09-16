package com.AppMentis.Controller;

import com.AppMentis.Modelos.Empleado;
import com.AppMentis.Servicios.EmpleadoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ControlEmpleado {

     @Autowired
    EmpleadoServicios empleadoServicios;

    @GetMapping("/users")
    public List<Empleado> verEmpleados(){
        return empleadoServicios.getAllEmpleado();
    }
    //Guarda empleado
    @PostMapping("/users")
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado emple){
        return Optional.ofNullable(this.empleadoServicios.saveorUpdateEmpleado(emple));
    }
    //Buscar empleados por ID
    @GetMapping(path = "users/{id}")
    public Optional <Empleado> empleadoPorID(@PathVariable("id") Integer id){
        return this.empleadoServicios.getEmpleadoById(id);
    }
    // Consultar empleados por empresa
    @GetMapping("/enterprises/{id}/users")
    public ArrayList<Empleado> EmpleadoPorEmpresa(@PathVariable("id") Integer id){
    return this.empleadoServicios.obtenerPorEmpresa(id);
    }

    @PatchMapping("/users/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado){
        Empleado empl= empleadoServicios.getEmpleadoById(id).get();
        empl.setNombre(empleado.getNombre());
        empl.setCedula(empleado.getCedula());
        empl.setCorreo(empleado.getCorreo());
        empl.setCargo(empleado.getCargo());
        empl.setEmpresa(empleado.getEmpresa());
        return empleadoServicios.saveorUpdateEmpleado(empleado);

    }

    @DeleteMapping (path= "users/{id}") //Eliminar registro de la base de datos
    public String DeleteEmpleado(@PathVariable("id") Integer id){
        boolean respuesta=empleadoServicios.deleteEmpleado(id); //eliminamos usando el servicio
        if (respuesta){ //si la respuesta booleana es true, si se eliminó
            return "Se eliminó exitosamente el empleado con el id "+id;
        }//Si la respuesta booleana es false, no se eliminó
        return "No se puedo eliminar el empleado con el id "+id;
    }
}



