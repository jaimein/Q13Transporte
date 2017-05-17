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
public class Matricula {

    private String letras;
    private long numero;

    /**
     * @return the letras
     */
    public String getLetras() {
        return letras;
    }

    /**
     * @param letras the letras to set
     */
    public void setLetras(String letras) {
        this.letras = letras;
    }

    /**
     * @return the numero
     */
    public long getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Matricula(String letras, long numero) throws ExcepcionPersonal {
        if (letras.length()!=3) {
            throw new ExcepcionPersonal("La matricula tiene que contener 3 letras");
        }
        if (numero>10000){
            throw new ExcepcionPersonal("El numero de la matricula no puede tener mas de 4 cifras");
        }
        this.letras = letras;
        this.numero = numero;
    }
    
    public String MatriculaToString(){
        return letras+numero;
    }
    
    
}
