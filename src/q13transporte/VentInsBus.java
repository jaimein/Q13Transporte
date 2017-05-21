/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jaime
 */
public class VentInsBus extends javax.swing.JFrame {

    private String Accion;
    private ListaAutobus Buses;
    private ListaConductores Chofers;
    private Autobus autobus;

    /**
     * Creates new form VentInsBus
     *
     * @param bus
     * @param conduc
     * @param Accion
     * @throws q13transporte.ExcepcionPersonal
     */
    public VentInsBus(ListaAutobus bus, ListaConductores conduc, String Accion) throws ExcepcionPersonal {
        try {
            this.Chofers = new ListaConductores();
            this.Buses = new ListaAutobus();
            initComponents();
            this.Buses = bus;
            this.Chofers = conduc;
            this.Accion = Accion;
            if (Accion.equalsIgnoreCase("Insertar")) {
                
                jClistaConductores.addItem(conduc.primer().getNombre());
                if (!conduc.isUltimo()) {
                    do {
                        jClistaConductores.addItem(conduc.siguiente().getNombre());
                    } while (!(Chofers.isUltimo()));
                }
                jTkm.setEnabled(false);
                jLkm.setEnabled(false);
                jPbotonesNav.setVisible(false);
            }
            if (Accion.equalsIgnoreCase("Listar")) {
                jPguardar.setVisible(false);
                jPbotonesNav.setVisible(true);
                autobus = Buses.primer();
                jTId.setText(String.valueOf(autobus.getId()));
                jClistaConductores.addItem(autobus.getConductor().getNombre());
                jClistaConductores.setSelectedIndex(1);
                jTprecioViaje.setText(String.valueOf(autobus.getPrecioBaseViaje()));
                if (autobus instanceof AutobusInterurbano) {
                    jRurbano.setEnabled(false);
                    jCruta.setEnabled(false);
                    jRinterurbano.setSelected(true);
                    jTkm.setText(String.valueOf(((AutobusInterurbano) autobus).getKm()));
                }
                if (autobus instanceof AutobusUrbano) {
                    jRinterurbano.setEnabled(false);
                    jTkm.setEnabled(false);
                    jRurbano.setSelected(true);
                    if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("A")) {
                        jCruta.setSelectedIndex(0);
                    }
                    if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("B")) {
                        jCruta.setSelectedIndex(1);
                    }
                    if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("C")) {
                        jCruta.setSelectedIndex(2);
                    }
                    jCruta.setEditable(false);
                }
                jTmatLetras.setText(autobus.getMatricula().getLetras());
                jTmatNum.setText(String.valueOf(autobus.getMatricula().getNumero()));
                jTId.setEditable(false);
                jClistaConductores.setEditable(false);
                jTprecioViaje.setEditable(false);
                jTmatLetras.setEditable(false);
                jTmatNum.setEditable(false);
                
            }
        } catch (SQLException | ExcepcionPersonal ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error generico", "Error", JOptionPane.ERROR_MESSAGE);
            
        }

    }

    VentInsBus(ListaAutobus Buses, ListaConductores Chofers, String Accion, int id) throws ExcepcionPersonal {
        try {
            this.Chofers = new ListaConductores();
            this.Buses = new ListaAutobus();
            initComponents();
            setLocationRelativeTo(null);
            this.Buses = Buses;
            this.Chofers = Chofers;
            this.Accion = Accion;
            Autobus bus;
            bus = Buses.devAutobus(String.valueOf(id));
            jPbotonesNav.setVisible(false);
            jTId.setText(String.valueOf(bus.getId()));
            jClistaConductores.addItem(bus.getConductor().getNombre());
            jClistaConductores.setSelectedIndex(1);
            jClistaConductores.setEditable(false);
            jTprecioViaje.setText(String.valueOf(bus.getPrecioBaseViaje()));
            if (bus instanceof AutobusInterurbano) {
                jRurbano.setEnabled(false);
                jCruta.setEnabled(false);
                jRinterurbano.setSelected(true);
                jTkm.setText(String.valueOf(((AutobusInterurbano) bus).getKm()));
            }
            if (bus instanceof AutobusUrbano) {
                jRinterurbano.setEnabled(false);
                jTkm.setEnabled(false);
                jRurbano.setSelected(true);
                if (((AutobusUrbano) bus).getRuta().equalsIgnoreCase("A")) {
                    jCruta.setSelectedIndex(0);
                }
                if (((AutobusUrbano) bus).getRuta().equalsIgnoreCase("B")) {
                    jCruta.setSelectedIndex(1);
                }
                if (((AutobusUrbano) bus).getRuta().equalsIgnoreCase("C")) {
                    jCruta.setSelectedIndex(2);
                }
                jCruta.setEditable(false);
            }
            jTmatLetras.setText(bus.getMatricula().getLetras());
            jTmatNum.setText(String.valueOf(bus.getMatricula().getNumero()));
            jTId.setEditable(false);
            jClistaConductores.setEditable(false);
            jTprecioViaje.setEditable(false);
            jTmatLetras.setEditable(false);
            jTmatNum.setEditable(false);
            jBguardar.setText("Atras");
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

        bGtipoBus = new javax.swing.ButtonGroup();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTId = new javax.swing.JTextField();
        jClistaConductores = new javax.swing.JComboBox<>();
        jTprecioViaje = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTmatLetras = new javax.swing.JTextField();
        jTmatNum = new javax.swing.JTextField();
        jRurbano = new javax.swing.JRadioButton();
        jRinterurbano = new javax.swing.JRadioButton();
        jCruta = new javax.swing.JComboBox<>();
        jTkm = new javax.swing.JTextField();
        jLruta = new javax.swing.JLabel();
        jLkm = new javax.swing.JLabel();
        jPbotonesNav = new javax.swing.JPanel();
        jBult = new javax.swing.JButton();
        jBsiguiente = new javax.swing.JButton();
        jBprimero = new javax.swing.JButton();
        jBant = new javax.swing.JButton();
        jTpos = new javax.swing.JTextField();
        jBatras = new javax.swing.JButton();
        jPguardar = new javax.swing.JPanel();
        jBguardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Introduzca los datos del autobus");

        jLabel2.setText("ID");

        jLabel3.setText("Conductor");

        jLabel4.setText("Precio Viaje");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jClistaConductores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTId)
                        .addComponent(jClistaConductores, 0, 92, Short.MAX_VALUE))
                    .addComponent(jTprecioViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jClistaConductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTprecioViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Matricula"));

        jLabel5.setText("Letras");

        jLabel6.setText("Numeros");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(67, 67, 67)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTmatLetras, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jTmatNum))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTmatLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTmatNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bGtipoBus.add(jRurbano);
        jRurbano.setSelected(true);
        jRurbano.setText("Urbano");

        bGtipoBus.add(jRinterurbano);
        jRinterurbano.setText("Interurbano");
        jRinterurbano.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRinterurbanoStateChanged(evt);
            }
        });

        jCruta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        jTkm.setEditable(false);

        jLruta.setText("Ruta");

        jLkm.setText("km");

        jBult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/q13transporte/img/ult.png"))); // NOI18N
        jBult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBultActionPerformed(evt);
            }
        });

        jBsiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/q13transporte/img/sig.png"))); // NOI18N
        jBsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsiguienteActionPerformed(evt);
            }
        });

        jBprimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/q13transporte/img/pri.png"))); // NOI18N
        jBprimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBprimeroActionPerformed(evt);
            }
        });

        jBant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/q13transporte/img/ant.png"))); // NOI18N
        jBant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBantActionPerformed(evt);
            }
        });

        jBatras.setText("Atras");
        jBatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBatrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPbotonesNavLayout = new javax.swing.GroupLayout(jPbotonesNav);
        jPbotonesNav.setLayout(jPbotonesNavLayout);
        jPbotonesNavLayout.setHorizontalGroup(
            jPbotonesNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPbotonesNavLayout.createSequentialGroup()
                .addGroup(jPbotonesNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPbotonesNavLayout.createSequentialGroup()
                        .addComponent(jBprimero)
                        .addGap(18, 18, 18)
                        .addComponent(jBant)
                        .addGap(18, 18, 18)
                        .addComponent(jTpos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBsiguiente)
                        .addGap(18, 18, 18)
                        .addComponent(jBult, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPbotonesNavLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jBatras)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPbotonesNavLayout.setVerticalGroup(
            jPbotonesNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPbotonesNavLayout.createSequentialGroup()
                .addGroup(jPbotonesNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPbotonesNavLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPbotonesNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBult, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBsiguiente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBant)
                            .addComponent(jBprimero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPbotonesNavLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTpos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jBatras)
                .addContainerGap())
        );

        jBguardar.setText("Guardar");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPguardarLayout = new javax.swing.GroupLayout(jPguardar);
        jPguardar.setLayout(jPguardarLayout);
        jPguardarLayout.setHorizontalGroup(
            jPguardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPguardarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBguardar)
                .addGap(23, 23, 23))
        );
        jPguardarLayout.setVerticalGroup(
            jPguardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPguardarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jBguardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(105, 105, 105))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLruta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRurbano))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jTkm, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLkm))
                            .addComponent(jRinterurbano)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPbotonesNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRurbano)
                    .addComponent(jRinterurbano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLruta)
                        .addComponent(jCruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLkm)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPguardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPbotonesNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        // TODO add your handling code here:

        if (Accion.equalsIgnoreCase("BuscaMuestra")) {
            this.dispose();
        } else {
            int id;
            Conductor cond;
            float precio;
            Matricula matri;
            long numMa;
            String letMa;
            try {
                id = Integer.parseInt(jTId.getText());
                cond = Chofers.devConductorId(String.valueOf(jClistaConductores.getSelectedIndex() - 1));
                precio = Float.parseFloat(jTprecioViaje.getText());
                letMa = jTmatLetras.getText();
                numMa = Long.parseLong(jTmatNum.getText());
                matri = new Matricula(letMa, numMa);

                if (jRurbano.isSelected()) {
                    // System.out.println(jCruta.geti);
                    // String ruta = jCruta.getItemAt(jCruta.getItemCount());
                    AutobusUrbano bus = new AutobusUrbano(String.valueOf(id), cond, precio, matri, jCruta.getItemAt(jCruta.getSelectedIndex()));
                    Buses.insertar(bus);
                    JOptionPane.showMessageDialog(null, "Autobus introducido", "Valido", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    AutobusInterurbano bus = new AutobusInterurbano(String.valueOf(id), cond, precio, matri, Integer.parseInt(jTkm.getText()));
                    Buses.insertar(bus);
                    JOptionPane.showMessageDialog(null, "Autobus introducido", "Valido", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }

            } catch (ExcepcionPersonal e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Tiene que ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBguardarActionPerformed

    private void jRinterurbanoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRinterurbanoStateChanged
        // TODO add your handling code here:
        if (jRinterurbano.isSelected()) {
            jCruta.setEnabled(false);
            jLruta.setEnabled(false);
            jTkm.setEnabled(true);
            jLkm.setEnabled(true);
        } else {
            jCruta.setEnabled(true);
            jLruta.setEnabled(true);
            jTkm.setEnabled(false);
            jLkm.setEnabled(false);
        }
    }//GEN-LAST:event_jRinterurbanoStateChanged

    private void jBultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBultActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            autobus = Buses.ultimo();
            jTId.setText(String.valueOf(autobus.getId()));
            jClistaConductores.addItem(autobus.getConductor().getNombre());
            jClistaConductores.setSelectedIndex(1);
            jTprecioViaje.setText(String.valueOf(autobus.getPrecioBaseViaje()));
            if (autobus instanceof AutobusInterurbano) {
                jRurbano.setEnabled(false);
                jCruta.setEnabled(false);
                jRinterurbano.setSelected(true);
                jTkm.setText(String.valueOf(((AutobusInterurbano) autobus).getKm()));
            }
            if (autobus instanceof AutobusUrbano) {
                jRinterurbano.setEnabled(false);
                jTkm.setEnabled(false);
                jRurbano.setSelected(true);
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("A")) {
                    jCruta.setSelectedIndex(0);
                }
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("B")) {
                    jCruta.setSelectedIndex(1);
                }
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("C")) {
                    jCruta.setSelectedIndex(2);
                }
                jCruta.setEditable(false);
            }
            jTmatLetras.setText(autobus.getMatricula().getLetras());
            jTmatNum.setText(String.valueOf(autobus.getMatricula().getNumero()));
            jTId.setEditable(false);
            jClistaConductores.setEditable(false);
            jTprecioViaje.setEditable(false);
            jTmatLetras.setEditable(false);
            jTmatNum.setEditable(false);

            jTpos.setText(String.valueOf(Buses.pos() + 1));
            if (Buses.isPrimer()) {
                jBant.setEnabled(false);
                jBprimero.setEnabled(false);
            } else {
                jBant.setEnabled(true);
                jBprimero.setEnabled(true);
            }
            if (Buses.isUltimo()) {
                jBsiguiente.setEnabled(false);
                jBult.setEnabled(false);
            } else {
                jBsiguiente.setEnabled(true);
                jBult.setEnabled(true);
            }
        } catch (ExcepcionPersonal ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBultActionPerformed

    private void jBsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsiguienteActionPerformed
        try {
            // TODO add your handling code here:
            autobus = Buses.siguiente();
            jTId.setText(String.valueOf(autobus.getId()));
            jClistaConductores.addItem(autobus.getConductor().getNombre());
            jClistaConductores.setSelectedIndex(1);
            jTprecioViaje.setText(String.valueOf(autobus.getPrecioBaseViaje()));
            if (autobus instanceof AutobusInterurbano) {
                jRurbano.setEnabled(false);
                jCruta.setEnabled(false);
                jRinterurbano.setSelected(true);
                jTkm.setText(String.valueOf(((AutobusInterurbano) autobus).getKm()));
            }
            if (autobus instanceof AutobusUrbano) {
                jRinterurbano.setEnabled(false);
                jTkm.setEnabled(false);
                jRurbano.setSelected(true);
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("A")) {
                    jCruta.setSelectedIndex(0);
                }
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("B")) {
                    jCruta.setSelectedIndex(1);
                }
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("C")) {
                    jCruta.setSelectedIndex(2);
                }
                jCruta.setEditable(false);
            }
            jTmatLetras.setText(autobus.getMatricula().getLetras());
            jTmatNum.setText(String.valueOf(autobus.getMatricula().getNumero()));
            jTId.setEditable(false);
            jClistaConductores.setEditable(false);
            jTprecioViaje.setEditable(false);
            jTmatLetras.setEditable(false);
            jTmatNum.setEditable(false);

            jTpos.setText(String.valueOf(Buses.pos() + 1));
            if (Buses.isPrimer()) {
                jBant.setEnabled(false);
                jBprimero.setEnabled(false);
            } else {
                jBant.setEnabled(true);
                jBprimero.setEnabled(true);
            }
            if (Buses.isUltimo()) {
                jBsiguiente.setEnabled(false);
                jBult.setEnabled(false);
            } else {
                jBsiguiente.setEnabled(true);
                jBult.setEnabled(true);
            }

        } catch (ExcepcionPersonal ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBsiguienteActionPerformed

    private void jBprimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprimeroActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            autobus = Buses.primer();
            jTId.setText(String.valueOf(autobus.getId()));
            jClistaConductores.addItem(autobus.getConductor().getNombre());
            jClistaConductores.setSelectedIndex(1);
            jTprecioViaje.setText(String.valueOf(autobus.getPrecioBaseViaje()));
            if (autobus instanceof AutobusInterurbano) {
                jRurbano.setEnabled(false);
                jCruta.setEnabled(false);
                jRinterurbano.setSelected(true);
                jTkm.setText(String.valueOf(((AutobusInterurbano) autobus).getKm()));
            }
            if (autobus instanceof AutobusUrbano) {
                jRinterurbano.setEnabled(false);
                jTkm.setEnabled(false);
                jRurbano.setSelected(true);
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("A")) {
                    jCruta.setSelectedIndex(0);
                }
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("B")) {
                    jCruta.setSelectedIndex(1);
                }
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("C")) {
                    jCruta.setSelectedIndex(2);
                }
                jCruta.setEditable(false);
            }
            jTmatLetras.setText(autobus.getMatricula().getLetras());
            jTmatNum.setText(String.valueOf(autobus.getMatricula().getNumero()));
            jTId.setEditable(false);
            jClistaConductores.setEditable(false);
            jTprecioViaje.setEditable(false);
            jTmatLetras.setEditable(false);
            jTmatNum.setEditable(false);

            jTpos.setText(String.valueOf(Buses.pos() + 1));
            if (Buses.isPrimer()) {
                jBant.setEnabled(false);
                jBprimero.setEnabled(false);
            } else {
                jBant.setEnabled(true);
                jBprimero.setEnabled(true);
            }
            if (Buses.isUltimo()) {
                jBsiguiente.setEnabled(false);
                jBult.setEnabled(false);
            } else {
                jBsiguiente.setEnabled(true);
                jBult.setEnabled(true);
            }
        } catch (ExcepcionPersonal ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBprimeroActionPerformed

    private void jBantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBantActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            autobus = Buses.anterior();
            jTId.setText(String.valueOf(autobus.getId()));
            jClistaConductores.addItem(autobus.getConductor().getNombre());
            jClistaConductores.setSelectedIndex(1);
            jTprecioViaje.setText(String.valueOf(autobus.getPrecioBaseViaje()));
            if (autobus instanceof AutobusInterurbano) {
                jRurbano.setEnabled(false);
                jCruta.setEnabled(false);
                jRinterurbano.setSelected(true);
                jTkm.setText(String.valueOf(((AutobusInterurbano) autobus).getKm()));
            }
            if (autobus instanceof AutobusUrbano) {
                jRinterurbano.setEnabled(false);
                jTkm.setEnabled(false);
                jRurbano.setSelected(true);
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("A")) {
                    jCruta.setSelectedIndex(0);
                }
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("B")) {
                    jCruta.setSelectedIndex(1);
                }
                if (((AutobusUrbano) autobus).getRuta().equalsIgnoreCase("C")) {
                    jCruta.setSelectedIndex(2);
                }
                jCruta.setEditable(false);
            }
            jTmatLetras.setText(autobus.getMatricula().getLetras());
            jTmatNum.setText(String.valueOf(autobus.getMatricula().getNumero()));
            jTId.setEditable(false);
            jClistaConductores.setEditable(false);
            jTprecioViaje.setEditable(false);
            jTmatLetras.setEditable(false);
            jTmatNum.setEditable(false);

            jTpos.setText(String.valueOf(Buses.pos() + 1));
            if (Buses.isPrimer()) {
                jBant.setEnabled(false);
                jBprimero.setEnabled(false);
            } else {
                jBant.setEnabled(true);
                jBprimero.setEnabled(true);
            }
            if (Buses.isUltimo()) {
                jBsiguiente.setEnabled(false);
                jBult.setEnabled(false);
            } else {
                jBsiguiente.setEnabled(true);
                jBult.setEnabled(true);
            }
        } catch (ExcepcionPersonal ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBantActionPerformed

    private void jBatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBatrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBatrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGtipoBus;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jBant;
    private javax.swing.JButton jBatras;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBprimero;
    private javax.swing.JButton jBsiguiente;
    private javax.swing.JButton jBult;
    private javax.swing.JComboBox<String> jClistaConductores;
    private javax.swing.JComboBox<String> jCruta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLkm;
    private javax.swing.JLabel jLruta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPbotonesNav;
    private javax.swing.JPanel jPguardar;
    private javax.swing.JRadioButton jRinterurbano;
    private javax.swing.JRadioButton jRurbano;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTkm;
    private javax.swing.JTextField jTmatLetras;
    private javax.swing.JTextField jTmatNum;
    private javax.swing.JTextField jTpos;
    private javax.swing.JTextField jTprecioViaje;
    // End of variables declaration//GEN-END:variables
}
