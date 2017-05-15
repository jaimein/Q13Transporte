/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jaime
 */
public class VentBusId extends javax.swing.JFrame {

    private final String Accion;
    private ListaAutobus Buses = new ListaAutobus();
    private ListaConductores Chofers = new ListaConductores();
    /**
     * Creates new form VentBusId
     * @param bus
     * @param conduc
     * @param Accion
     */
    public VentBusId(ListaAutobus bus, ListaConductores conduc, String Accion) {
        initComponents();
        this.Buses = bus;
        this.Chofers = conduc;
        this.Accion = Accion;
        jLaccion.setText(Accion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLaccion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jBsiguiente = new javax.swing.JButton();
        jBatras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar por id para");

        jLabel2.setText("id");

        jTid.setToolTipText("");

        jBsiguiente.setText("Siguiente");
        jBsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsiguienteActionPerformed(evt);
            }
        });

        jBatras.setText("Atras");
        jBatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBatrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel2)))
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jBatras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBsiguiente)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBsiguiente)
                    .addComponent(jBatras))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsiguienteActionPerformed
        // TODO add your handling code here:
        if (Accion.equalsIgnoreCase("Borrar")) {
            try {
                Buses.borrarPorId(Integer.parseInt(jTid.getText()));
                JOptionPane.showMessageDialog(null, "Autobus borrado", "Valido", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            } catch (ExcepcionPersonal e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Tiene que ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBsiguienteActionPerformed

    private void jBatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBatrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBatrasActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBatras;
    private javax.swing.JButton jBsiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLaccion;
    private javax.swing.JTextField jTid;
    // End of variables declaration//GEN-END:variables
}