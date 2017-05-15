/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

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
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ConectaBBDD cc;
            cc = new ConectaBBDD();
            cc.cargarConductores();
        } catch (ExcepcionPersonal ex) {
            Logger.getLogger(Q13Transporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
