/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vlc
 */
public class Q13Transporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExcepcionPersonal {
        System.out.println("asdfgk");
        ListaConductores Chofers = new ListaConductores();
        Date fecha = Date.valueOf(LocalDate.now());
    Conductor cond = new Conductor("15dd","pepaee", 1234,fecha);
        Chofers.insertar(cond);
        Chofers.borrarPorNombre("pepe");

            
            System.out.println("ok");
        
    }
    
}
