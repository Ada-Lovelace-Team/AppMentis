package com.AppMentis.Servicios;

import com.AppMentis.Modelos.Empleado;
import com.AppMentis.Repo.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;
@Service
public class EmpleadoServicios {

    @Autowired
    EmpleadoRepository empleadoRepository;

    //Permite ver todos los empleados registrados
    public List<Empleado> getAllEmpleado(){
        List<Empleado> empleadoList= new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }

    //Permite buscar empleados por ID
    public Optional<Empleado> getEmpleadoById(Integer id){

        return empleadoRepository.findById(id);
    }
    //Permite buscar empleados por ID
    public ArrayList<Empleado>obtenerPorEmpresa(Integer id){
        return empleadoRepository.findByEmpresa(id);

}



    //metodo para guardar o actualizar
    public Empleado saveorUpdateEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);

    }


    //Permite eliminar un registro por Id
    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id);
        if(this.empleadoRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }

}
