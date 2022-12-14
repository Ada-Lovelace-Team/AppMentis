package com.AppMentis.Modelos;

import javax.persistence.*;

@Entity
@Table (name ="Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "direccion")
    private String dirreccion;
    @Column(name= "telefono")
    private String telefono;
    @Column(name= "Nit")
    private String NIT;

    public Empresa() {
    }

    public Empresa(String nombre, String dirreccion, String telefono, String NIT) {
        this.nombre = nombre;
        this.dirreccion = dirreccion;
        this.telefono = telefono;
        this.NIT = NIT;
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

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIF) {
        this.NIT = NIT;
    }
}
