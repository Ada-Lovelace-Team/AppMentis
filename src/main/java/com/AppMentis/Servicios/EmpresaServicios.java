package com.AppMentis.Servicios;

import com.AppMentis.Modelos.Empresa;
import com.AppMentis.Repo.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicios {
    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }

    public Optional<Empresa> getEmpresaByID(Integer id){
        return empresaRepository.findById(id);

    }

    //Metodo para guardar o actualizar objetos de tipo Empresa
    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp=empresaRepository.save(empresa);
        if (empresaRepository.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }

    public boolean deleteEmpresa(Integer id){
        if(getEmpresaByID(id).isPresent()){
            empresaRepository.deleteById(id);
            if(getEmpresaByID(id).isPresent()){
                return false;
            }else{
                return true;
            }
        }else {
            return false;
        }

    }

}