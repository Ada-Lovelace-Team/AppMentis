package com.AppMentis;

import com.AppMentis.Modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication(exclude ={SecurityAutoConfiguration.class} )
public class AppMentisApplication {
	@GetMapping("/hello") public String hello(){
		return "Hola, soy Ana ";

	}
	@GetMapping ("/test")
	public String test (){
		Empresa empresa= new Empresa ("Cocacola","Calle", "100","111");
		empresa.setNombre("Cocacola");
		return empresa.getNombre();
	}


	public static void main(String[] args) {
		SpringApplication.run(AppMentisApplication.class, args);
	}

}
