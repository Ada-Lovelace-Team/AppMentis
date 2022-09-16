package com.AppMentis.Modelos;

import javax.persistence.*;


@Entity
@Table(name= "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String correo;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @Column(name ="Rol")
    private String cargo;

    private String cedula;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String correo, Empresa empresa, String cargo, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.cargo = cargo;
        this.cedula = cedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


}