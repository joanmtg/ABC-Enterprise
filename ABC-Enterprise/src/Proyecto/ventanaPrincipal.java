package Proyecto;

import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabio Andres
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    ManejadoraBD baseDatos = new ManejadoraBD();

    public ventanaPrincipal() {
        super("Welcome to ABC Enterprises");

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImagenVentanaP = new javax.swing.JPanel();
        labelImagenVentanaP = new javax.swing.JLabel();
        panelInfoVentanaP = new javax.swing.JPanel();
        labelUsernameUsuarioVentanaP = new javax.swing.JLabel();
        labelInfoUsuarioVentanaP = new javax.swing.JLabel();
        tfUsuarioVentanaP = new javax.swing.JTextField();
        labelPasswordVentanaP = new javax.swing.JLabel();
        labelInfoContraseñaVentanaP = new javax.swing.JLabel();
        botonIngresarVentanaP = new javax.swing.JButton();
        separatorVentanaP = new javax.swing.JSeparator();
        labelIncorrectoVentanaP = new javax.swing.JLabel();
        tfContraseñaVentanaP = new javax.swing.JPasswordField();
        botonOlvidarContra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout panelImagenVentanaPLayout = new javax.swing.GroupLayout(panelImagenVentanaP);
        panelImagenVentanaP.setLayout(panelImagenVentanaPLayout);
        panelImagenVentanaPLayout.setHorizontalGroup(
            panelImagenVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelImagenVentanaPLayout.setVerticalGroup(
            panelImagenVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        labelImagenVentanaP.setBackground(new java.awt.Color(204, 204, 204));
        labelImagenVentanaP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoEmpresa.png"))); // NOI18N
        labelImagenVentanaP.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelInfoVentanaP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Acceso al sistema", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 12))); // NOI18N
        panelInfoVentanaP.setToolTipText("");
        panelInfoVentanaP.setName(""); // NOI18N

        labelUsernameUsuarioVentanaP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N

        labelInfoUsuarioVentanaP.setText("USUARIO");

        tfUsuarioVentanaP.setToolTipText("");
        tfUsuarioVentanaP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfUsuarioVentanaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfUsuarioVentanaPKeyTyped(evt);
            }
        });

        labelPasswordVentanaP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pass.png"))); // NOI18N

        labelInfoContraseñaVentanaP.setText("CONTRASEÑA");

        botonIngresarVentanaP.setText("Ingresar");
        botonIngresarVentanaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarVentanaPActionPerformed(evt);
            }
        });

        labelIncorrectoVentanaP.setBackground(new java.awt.Color(255, 153, 153));
        labelIncorrectoVentanaP.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        labelIncorrectoVentanaP.setForeground(new java.awt.Color(255, 51, 51));
        labelIncorrectoVentanaP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIncorrectoVentanaP.setText("Usuario o contraseña incorrecta");

        tfContraseñaVentanaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfContraseñaVentanaPKeyTyped(evt);
            }
        });

        botonOlvidarContra.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        botonOlvidarContra.setText("¿Olvidaste tu contraseña?");
        botonOlvidarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOlvidarContraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoVentanaPLayout = new javax.swing.GroupLayout(panelInfoVentanaP);
        panelInfoVentanaP.setLayout(panelInfoVentanaPLayout);
        panelInfoVentanaPLayout.setHorizontalGroup(
            panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoVentanaPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelIncorrectoVentanaP, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPasswordVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelUsernameUsuarioVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfContraseñaVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(tfUsuarioVentanaP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                        .addGap(0, 186, Short.MAX_VALUE)
                        .addGroup(panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoVentanaPLayout.createSequentialGroup()
                                .addComponent(labelInfoContraseñaVentanaP)
                                .addGap(179, 179, 179))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoVentanaPLayout.createSequentialGroup()
                                .addComponent(labelInfoUsuarioVentanaP)
                                .addGap(191, 191, 191))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoVentanaPLayout.createSequentialGroup()
                                .addComponent(botonIngresarVentanaP)
                                .addGap(182, 182, 182))))
                    .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                        .addComponent(separatorVentanaP)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoVentanaPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonOlvidarContra)
                .addGap(140, 140, 140))
        );
        panelInfoVentanaPLayout.setVerticalGroup(
            panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelInfoUsuarioVentanaP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelUsernameUsuarioVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUsuarioVentanaP))
                .addGap(19, 19, 19)
                .addComponent(labelInfoContraseñaVentanaP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPasswordVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfContraseñaVentanaP))
                .addGap(18, 18, 18)
                .addComponent(botonIngresarVentanaP)
                .addGap(28, 28, 28)
                .addComponent(separatorVentanaP, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(botonOlvidarContra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelIncorrectoVentanaP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelImagenVentanaP, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelImagenVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInfoVentanaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelImagenVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelImagenVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelInfoVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarVentanaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarVentanaPActionPerformed
        // TODO add your handling code here:
        String usernameProg = "", passProg = "";
        int existeUsuario; //Aquí se almacenará la cantidad de usuarios con un codigo dado (Max 1)
        //Se obtiene lo que el usuario digitó
        usernameProg = tfUsuarioVentanaP.getText();
        passProg = tfContraseñaVentanaP.getText();

        //Primero se verifica que no haya un campo vacío para no tener que hacer la comparación con todos los elementos en la base de datos (Se ahorra tiempo de ejecución)
        if (tfUsuarioVentanaP.getText().equals("") || tfContraseñaVentanaP.getText().equals("")) {
            labelIncorrectoVentanaP.setText("Ingrese un usuario y contraseña.");
            labelIncorrectoVentanaP.setVisible(true);
            separatorVentanaP.setVisible(true);
        } //De lo contrario, se llama al método 'login' de la clase ManejadoraBD
        else {
            existeUsuario = baseDatos.buscarLogin(usernameProg);
            if (existeUsuario != 0) {
                ArrayList<String> informacion = new ArrayList<>();
                informacion = baseDatos.obtenerInfoDelLogin(usernameProg);
                String passUsuario = informacion.get(3);

                if(passProg.equals(passUsuario))
                {
                    ventanaGerente objGerente = new ventanaGerente();
                    objGerente.setVisible(true);

                    objGerente.labelNombreGerente.setText("Nombre:  " + informacion.get(1));
                    objGerente.labelIdGerente.setText("Identifiación:   " + informacion.get(0));
                    objGerente.labelCargoGerente.setText("Cargo:    " + informacion.get(2));

                    this.setVisible(false);
                }
                else
                {
                    labelIncorrectoVentanaP.setText("Contraseña incorrecta.");
                    labelIncorrectoVentanaP.setVisible(true);
                    separatorVentanaP.setVisible(true);
                }
            } //Si se devuelve 0 es porque no hay match entre la información dada y lo que está en la BD
            else {
                labelIncorrectoVentanaP.setText("El usuario ingresado no está registrado.");
                labelIncorrectoVentanaP.setVisible(true);
                separatorVentanaP.setVisible(true);
            }
        }

    }//GEN-LAST:event_botonIngresarVentanaPActionPerformed

    private void botonOlvidarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOlvidarContraActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Para ingresar al sistema debe ingresar la siguiente información: \n"
                + "Usuario: Numero de identificación (Ej: 1144092748)\n"
                + "Contraseña: Numero de identificación-Edad (Ej: 1144092748-20)\n\n"
                + "Si ya ha realizado el cambio de contraseña, solicite a un gerente la actualización de la misma.");
    }//GEN-LAST:event_botonOlvidarContraActionPerformed

    private void tfUsuarioVentanaPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUsuarioVentanaPKeyTyped
        // Para que capture el ENTER
        char cTeclaPresionada = evt.getKeyChar();
        
        if(cTeclaPresionada == KeyEvent.VK_ENTER){
            botonIngresarVentanaP.doClick();
        }
        
    }//GEN-LAST:event_tfUsuarioVentanaPKeyTyped

    private void tfContraseñaVentanaPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfContraseñaVentanaPKeyTyped
        // Para que capture el ENTER
        char cTeclaPresionada = evt.getKeyChar();
        
        if(cTeclaPresionada == KeyEvent.VK_ENTER){
            botonIngresarVentanaP.doClick();
        }
    }//GEN-LAST:event_tfContraseñaVentanaPKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                /*if ("Nimbus".equals(info.getName())) {
                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
                 break;
                 }*/
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventanaPrincipal objVentanaPrincipal = new ventanaPrincipal();
                objVentanaPrincipal.setVisible(true);
                objVentanaPrincipal.labelIncorrectoVentanaP.setVisible(false);
                objVentanaPrincipal.separatorVentanaP.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresarVentanaP;
    private javax.swing.JButton botonOlvidarContra;
    private javax.swing.JLabel labelImagenVentanaP;
    public javax.swing.JLabel labelIncorrectoVentanaP;
    private javax.swing.JLabel labelInfoContraseñaVentanaP;
    private javax.swing.JLabel labelInfoUsuarioVentanaP;
    private javax.swing.JLabel labelPasswordVentanaP;
    private javax.swing.JLabel labelUsernameUsuarioVentanaP;
    private javax.swing.JPanel panelImagenVentanaP;
    private javax.swing.JPanel panelInfoVentanaP;
    public javax.swing.JSeparator separatorVentanaP;
    private javax.swing.JPasswordField tfContraseñaVentanaP;
    private javax.swing.JTextField tfUsuarioVentanaP;
    // End of variables declaration//GEN-END:variables
}
