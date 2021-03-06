/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jaime
 */
public class VentEleccion extends javax.swing.JFrame {

    private ListaAutobus Buses;
    private ListaConductores Chofers;
    private String Accion;

    /**
     * Creates new form VentEleccion
     *
     * @param bus
     * @param conduc
     * @param Accion
     */
    public VentEleccion(ListaAutobus bus, ListaConductores conduc, String Accion) {
        try {
            this.Chofers = new ListaConductores();
            this.Buses = new ListaAutobus();
            initComponents();
            setLocationRelativeTo(null);
            this.Buses = bus;
            this.Chofers = conduc;
            this.Accion = Accion;
            /*if (Accion.equalsIgnoreCase("BuscaMuestra")) {
            JTextField jTbusca = new javax.swing.JTextField("  ", 20);
            add(jTbusca);
            jTbusca.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
            jTbusca.setVisible(true);
            }*/
        } catch (SQLException | ExcepcionPersonal ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error generico", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBautobus = new javax.swing.JButton();
        jBconductor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLAccion = new javax.swing.JLabel();
        jBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBautobus.setText("Autobus");
        jBautobus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBautobusActionPerformed(evt);
            }
        });

        jBconductor.setText("Conductor");
        jBconductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBconductorActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione para realizar la accion");

        jBCancelar.setText("Volver");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBconductor)
                    .addComponent(jLAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBautobus)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jBCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBautobus)
                .addGap(29, 29, 29)
                .addComponent(jBconductor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jBCancelar)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBautobusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBautobusActionPerformed
        // TODO add your handling code here:
        if (Accion.equalsIgnoreCase("Limpiar lista")) {
            try {
                Buses.limpiar();
                JOptionPane.showMessageDialog(null, "Eliminados registros", "Limpiar", JOptionPane.INFORMATION_MESSAGE);
            } catch (ExcepcionPersonal ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error generico", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        }
        if (Accion.equalsIgnoreCase("Insertar")) {
            try {
                //JOptionPane.showMessageDialog(null, "pppppppp", "Error", JOptionPane.ERROR_MESSAGE);
                VentInsBus vent = new VentInsBus(Buses, Chofers, Accion);
                vent.setVisible(true);
            } catch (ExcepcionPersonal ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error generico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (Accion.equalsIgnoreCase("Borrar")) {
            VentBusIdMOD vent = new VentBusIdMOD(Buses, Chofers, Accion);
            vent.setVisible(true);
        }
        if (Accion.equalsIgnoreCase("BuscaMuestra")) {
            BuscaMuestra vent = new BuscaMuestra(Buses, Chofers, Accion);
            vent.setVisible(true);
        }
        if (Accion.equalsIgnoreCase("Listar")) {
            try {
                VentInsBus vent = new VentInsBus(Buses, Chofers, Accion);
                vent.setVisible(true);
            } catch (ExcepcionPersonal ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error generico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.dispose();
    }//GEN-LAST:event_jBautobusActionPerformed

    private void jBconductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBconductorActionPerformed
        // TODO add your handling code here:
        if (Accion.equalsIgnoreCase("Limpiar lista")) {
            try {
                Chofers.limpiar();
                JOptionPane.showMessageDialog(null, "Eliminados registros", "Limpiar", JOptionPane.INFORMATION_MESSAGE);
            } catch (ExcepcionPersonal ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error generico", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        }
        if (Accion.equalsIgnoreCase("Insertar")) {
            //JOptionPane.showMessageDialog(null, "pppppppp", "Error", JOptionPane.ERROR_MESSAGE);
            VentInsCond vent;
            try {
                vent = new VentInsCond(Chofers, Accion);
                vent.setVisible(true);
            } catch (ExcepcionPersonal ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error generico", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (Accion.equalsIgnoreCase("Borrar")) {
            VentCondNombre vent = new VentCondNombre(Buses, Chofers, Accion);
            vent.setVisible(true);
        }
        if (Accion.equalsIgnoreCase("BuscaMuestra")) {
            BuscaMuestra vent = new BuscaMuestra(Chofers, Accion);
            vent.setVisible(true);
        }
        if (Accion.equalsIgnoreCase("Listar")) {
            try {
                VentInsCond vent = new VentInsCond(Chofers, Accion);
                vent.setVisible(true);
            } catch (ExcepcionPersonal ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error generico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.dispose();
    }//GEN-LAST:event_jBconductorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBautobus;
    private javax.swing.JButton jBconductor;
    private javax.swing.JLabel jLAccion;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
