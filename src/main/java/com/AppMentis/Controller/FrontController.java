package com.AppMentis.Controller;

import com.AppMentis.Modelos.Empresa;
import com.AppMentis.Servicios.EmpresaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FrontController {
    @Autowired
    EmpresaServicios empresaServicios;

    //Llamamos al HTML con el return "listaEmpresas
    @GetMapping({"/","VerEmpresas"})
    public String viewEmpresas(Model model){
        List<Empresa> ListaEmpresas=empresaServicios.getAllEmpresas();
        model.addAttribute("emplist",ListaEmpresas);
        return "verEmpresas";


    }
    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model, @ModelAttribute("mensaje") String mensaje){
        Empresa emp= new Empresa();
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje",mensaje);
        return "agregarEmpresa";
    }
    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaServicios.saveOrUpdateEmpresa(emp)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/verEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpresa";
    }

}


