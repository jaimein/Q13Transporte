/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author jaime
 */
public class Conductor {
//Atributos miembros (solo accesibles desde dentro de la clase)
    private String codConductor;
    private String nombre;
    private float salario;
    private Date fecha_alta;

//Constructores

    public Conductor() {
    }

    public Conductor(String nombre, float salario) {
        this.codConductor = null;
        this.nombre = nombre;
        this.salario = salario;
        this.fecha_alta = Date.valueOf(LocalDate.now());
    }

    public Conductor(String nombre, float salario, Date fecha_alta) {
        this.codConductor = null;
        this.nombre = nombre;
        this.salario = salario;
        this.fecha_alta = fecha_alta;
    }

    public Conductor(String codConductor, String nombre, float salario, Date fecha_alta) {
        this.codConductor = codConductor;
        this.nombre = nombre;
        this.salario = salario;
        this.fecha_alta = fecha_alta;
    }
    
//Fin Constructores

//Getter y Setter
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getCodConductor() {
        return codConductor;
    }

    public void setCodConductor(String codConductor) {
        this.codConductor = codConductor;
    }
    
//Fin Getter y Setter
}