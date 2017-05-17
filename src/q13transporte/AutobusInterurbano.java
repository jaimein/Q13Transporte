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
// hereda de Autobus e implementa el método abstracto calcularPrecioViaje.
public class AutobusInterurbano extends Autobus {
//Atributo miembro nuevo (solo accesible desde dentro de la clase)

    private int km;
//Constructor clase derivada

    AutobusInterurbano(String id, Conductor conductor, float precioBaseViaje, Matricula matricula, int km) {
        super(id, conductor, precioBaseViaje, matricula); //Llamada constructor clase base
        this.km = km;
    }
//Métodos de encapsulamiento

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
//Método para calcular el precio del viaje en función del número de km

    @Override
    public float calcularPrecioViaje() {
        float total;
        total = precioBaseViaje * km;
        return total;
    }
}
