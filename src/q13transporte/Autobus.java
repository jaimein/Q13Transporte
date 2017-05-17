/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

/**
 *
 * @author jaime
 */
abstract class Autobus {
//Atributos miembros (solo accesibles desde dentro de la clase)
    
    protected String id;
    protected Conductor conductor;
    protected float precioBaseViaje;
    private Matricula matricula;
//Constructor con todos los valores iniciales por defecto

    public Autobus() {
        id = "0";
        conductor = null;
        precioBaseViaje = 0;
    }
//Constructor con todos los valores recibidos como parámetros

    public Autobus(String id, Conductor conductor, float precioBaseViaje, Matricula matricula) {
        this.id = id;
        this.conductor = conductor;
        this.precioBaseViaje = precioBaseViaje;
        this.matricula = matricula;
    }
//Métodos de encapsulamiento

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public float getPrecioBaseViaje() {
        return precioBaseViaje;
    }

    public void setPrecioBaseViaje(float precioBaseViaje) {
        this.precioBaseViaje = precioBaseViaje;
    }
//Método abstracto para calcular el precio total del viaje

    abstract float calcularPrecioViaje();
//Método para mostrar el nombre del conductor

    public void mostrarNombreConductor() {
        System.out.println(conductor.getNombre());
    }

    /**
     * @return the matricula
     */
    public Matricula getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
}
