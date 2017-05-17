/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            System.out.println("asdfgk");
            ListaConductores Chofers = new ListaConductores();
            //    Date fecha = Date.valueOf(LocalDate.now());
            //Conductor cond = new Conductor("1ddd","pepeae", 1234,fecha);
            //    Chofers.insertar(cond);
            //    Chofers.borrarPorNombre("pepeae");
            ListaAutobus Buses = new ListaAutobus();
            
            //AutobusInterurbano bus = new AutobusInterurbano("2345", Chofers.devConductorId("1"), 20, new Matricula("add", 8465), 50);
            //Buses.insertar(bus);
            //AutobusInterurbano bus2 = new AutobusInterurbano("2345", Chofers.devConductorId("1"), 200, new Matricula("add", 8465), 33);
            //Buses.modificar(bus2);
           // Buses.borrarPorId("1234");
           
           Conductor cond = new Conductor("15dd", "mod", 1230);
           Chofers.modificar(cond);
            System.out.println("ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionPersonal ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
