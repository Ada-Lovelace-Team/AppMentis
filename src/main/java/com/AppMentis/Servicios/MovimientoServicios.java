package com.AppMentis.Servicios;

import com.AppMentis.Modelos.MovimientoDinero;
import com.AppMentis.Repo.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServicios {
    @Autowired
    MovimientosRepository movimientosRepository;
    //muestra todos los movimientos
    public List<MovimientoDinero> getAllMovimientos(){
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movimientosRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));
        return movimientosList;
    }
    // permite ver los movimientos por ID
    public MovimientoDinero getMovimientoById(Integer id){
        return movimientosRepository.findById(id).get();
    }

    //Guarda o actualiza movimientos
    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){
        MovimientoDinero mov=movimientosRepository.save(movimientoDinero);
        return mov;
    }
    //Elimina el  movimiento por id
    public boolean deleteMovimiento(Integer id){ //Eliminar movimiento por id
        movimientosRepository.deleteById(id);
        if(this.movimientosRepository.findById(id).isPresent()){
            return false; //Si al buscar el movimiento lo encontramos, no se eliminó (false)
        }
        return true; //Si al buscar el movimiento no lo encontramos, quiede decir que lo elimino (true)
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) { //Obterner teniendo en cuenta el id del empleado
        return movimientosRepository.findByEmpleado(id);
    }
    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) { //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
        return movimientosRepository.findByEmpresa(id);
    }
}
