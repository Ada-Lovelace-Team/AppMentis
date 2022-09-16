package com.AppMentis.Controller;


import com.AppMentis.Modelos.Empresa;
import com.AppMentis.Servicios.EmpresaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControlEmpresa {

    @Autowired
    EmpresaServicios empresaServicios;

    @GetMapping("/enterprises")
    public List<Empresa> verEmpresas(){
        List<Empresa> listadoverEmpresas = empresaServicios.getAllEmpresas();
        return listadoverEmpresas;
    }
    //Nos permitira guardar los datos
    @PostMapping("/enterprises")
    public Optional<Empresa> agregarEmpresa(@RequestBody Empresa nuevaEmpresa){
        return empresaServicios.saveorUpdateEmpresa(nuevaEmpresa);
    }
    @GetMapping("/enterprises/{id}")
    public Optional<Empresa> verEmpresaById(@PathVariable(value="id") Integer id){
        return empresaServicios.getEmpresaByID(id);
    }
    @PatchMapping("/enterprises/")
    public Optional<Empresa> actualizarEmpresa(@RequestBody Empresa edisionEmpresa){
        return empresaServicios.saveorUpdateEmpresa(edisionEmpresa);
    }
    @DeleteMapping("enterprises/{id}")
    public Boolean removerEmpresa(@PathVariable(value="id") Integer id){
        return empresaServicios.deleteEmpresa(id);
    }

}




