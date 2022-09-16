package com.AppMentis.Controller;

import com.AppMentis.Modelos.MovimientoDinero;
import com.AppMentis.Servicios.MovimientoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControlMovimientos {
    @Autowired
    MovimientoServicios movimientoServicios;

    //Consultar todos los movimientos
    @GetMapping("/movements") //Consultar todos los movimientos
    public List<MovimientoDinero> verMovimientos(){
        return movimientoServicios.getAllMovimientos();
    }
    //
    @PostMapping("/movements")
    public MovimientoDinero guardarMovimiento(@RequestBody MovimientoDinero movimiento){
        return movimientoServicios.saveOrUpdateMovimiento(movimiento);
    }
    @GetMapping("/movements/{id}") //Consultar movimiento por id
    public MovimientoDinero movimientoPorId(@PathVariable("id") Integer id){
        return movimientoServicios.getMovimientoById(id);
    }
    @PatchMapping("/movements/{id}")//Editar o actualizar un movimiento
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimiento){
        MovimientoDinero mov=movimientoServicios.getMovimientoById(id);
        mov.setConcepto(movimiento.getConcepto());
        mov.setMonto(movimiento.getMonto());
        mov.setUsuario(movimiento.getUsuario());
        return movimientoServicios.saveOrUpdateMovimiento(mov);
    }
    // Elimina el movimiento por ID
    @DeleteMapping("/movements/{id}")
    public String deleteMovimiento(@PathVariable("id") Integer id){
        boolean respuesta= movimientoServicios.deleteMovimiento(id);
        if (respuesta){
            return "Se elimino correctamente el movimiento con id " +id;
        }
        return "No se pudo eliminar el movimiento con id "+id;
    }
    //Consultar movimientos por id del empleado
    @GetMapping("/users/{id}/movements")
    public ArrayList<MovimientoDinero> movimientosPorEmpleado(@PathVariable("id") Integer id){
        return movimientoServicios.obtenerPorEmpleado(id);
    }
    //Permite consultar los movimientos que pertenecen a una empresa por el ID de la empresa
    @GetMapping("/enterprises/{id}/movements")
    public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("id") Integer id){
        return movimientoServicios.obtenerPorEmpresa(id);
    }

}








