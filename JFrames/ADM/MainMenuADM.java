package JFrames.ADM;

import Clases.ThreadClass;
import JFrames.ADM.Admin.*;
import JFrames.ADM.Place.*;
import JFrames.ADM.Race.*;
import JFrames.ADM.Track.*;
import JFrames.ADM.User.*;

import JFrames.MainMenu;

import java.util.List;
import javax.swing.SwingUtilities;

import javax.swing.table.DefaultTableModel;

import maguna.dominguez.tpi.sistema.de.carreras.ConnectionDB;

public class MainMenuADM extends javax.swing.JFrame {

    public MainMenuADM() {
        initComponents();
        
        ThreadClass.fillRaceTable(raceTable);
        ThreadClass.fillUsersTable(userTable);
        ThreadClass.fillAdminTable(adminTable);
        ThreadClass.fillTrackTable(trackTable);
        ThreadClass.fillPlaceTable(placeTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addRaceB = new javax.swing.JButton();
        modifyRaceB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        raceTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addUserB = new javax.swing.JButton();
        modifyUserB = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        addAdminB = new javax.swing.JButton();
        modifyAdminB = new javax.swing.JButton();
        deleteAdminB = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        addTrackB = new javax.swing.JButton();
        ModifyTrackB = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        trackTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        placeTable = new javax.swing.JTable();
        addPlaceB = new javax.swing.JButton();
        modifyPlaceB = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(28, 33, 53));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu Principal de Administrador");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Carreras");

        addRaceB.setBackground(new java.awt.Color(28, 33, 53));
        addRaceB.setForeground(new java.awt.Color(255, 255, 255));
        addRaceB.setText("Agregar");
        addRaceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRaceBActionPerformed(evt);
            }
        });

        modifyRaceB.setBackground(new java.awt.Color(28, 33, 53));
        modifyRaceB.setForeground(new java.awt.Color(255, 255, 255));
        modifyRaceB.setText("Modificar");
        modifyRaceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyRaceBActionPerformed(evt);
            }
        });

        raceTable.setBackground(new java.awt.Color(52, 62, 103));
        raceTable.setForeground(new java.awt.Color(255, 255, 255));
        raceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Vueltas", "Fecha", "Circuito"
            }
        ));
        jScrollPane1.setViewportView(raceTable);

        jTextArea1.setBackground(new java.awt.Color(52, 62, 103));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("1.0.4: Se agregaron las funcionalidades de Gestion de Carreras, \nUsuarios y Administradores.\n\n1.0.3: Se agregaron las funcionalidades de busqueda de carrera en \nbase a su nombre y fecha, ademas, se agrego la funcionalidad de \nlog in.\n\n1.0.2: Se hizo la conexion local con la Base de Datos.\n\n1.0.1: Se agregaron las IUs Menu Principal, Log In, Menu Principal de \nAdministrador y las IUs de Gestion de Carreras, Usuarios, Administra_\n_dores, Circuitos y Ubicaciones.");
        jScrollPane2.setViewportView(jTextArea1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Actualizaciones");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuarios");

        addUserB.setBackground(new java.awt.Color(28, 33, 53));
        addUserB.setForeground(new java.awt.Color(255, 255, 255));
        addUserB.setText("Agregar");
        addUserB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBActionPerformed(evt);
            }
        });

        modifyUserB.setBackground(new java.awt.Color(28, 33, 53));
        modifyUserB.setForeground(new java.awt.Color(255, 255, 255));
        modifyUserB.setText("Modificar");
        modifyUserB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyUserBActionPerformed(evt);
            }
        });

        userTable.setBackground(new java.awt.Color(52, 62, 103));
        userTable.setForeground(new java.awt.Color(255, 255, 255));
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Vehiculo"
            }
        ));
        jScrollPane3.setViewportView(userTable);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Administradores");

        addAdminB.setBackground(new java.awt.Color(28, 33, 53));
        addAdminB.setForeground(new java.awt.Color(255, 255, 255));
        addAdminB.setText("Agregar");
        addAdminB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminBActionPerformed(evt);
            }
        });

        modifyAdminB.setBackground(new java.awt.Color(28, 33, 53));
        modifyAdminB.setForeground(new java.awt.Color(255, 255, 255));
        modifyAdminB.setText("Modificar");
        modifyAdminB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAdminBActionPerformed(evt);
            }
        });

        deleteAdminB.setBackground(new java.awt.Color(28, 33, 53));
        deleteAdminB.setForeground(new java.awt.Color(255, 255, 255));
        deleteAdminB.setText("Eliminar");
        deleteAdminB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAdminBActionPerformed(evt);
            }
        });

        adminTable.setBackground(new java.awt.Color(52, 62, 103));
        adminTable.setForeground(new java.awt.Color(255, 255, 255));
        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ));
        jScrollPane4.setViewportView(adminTable);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Circuitos");

        addTrackB.setBackground(new java.awt.Color(28, 33, 53));
        addTrackB.setForeground(new java.awt.Color(255, 255, 255));
        addTrackB.setText("Agregar");
        addTrackB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrackBActionPerformed(evt);
            }
        });

        ModifyTrackB.setBackground(new java.awt.Color(28, 33, 53));
        ModifyTrackB.setForeground(new java.awt.Color(255, 255, 255));
        ModifyTrackB.setText("Modificar");
        ModifyTrackB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyTrackBActionPerformed(evt);
            }
        });

        trackTable.setBackground(new java.awt.Color(52, 62, 103));
        trackTable.setForeground(new java.awt.Color(255, 255, 255));
        trackTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", "Codigo Postal"
            }
        ));
        jScrollPane5.setViewportView(trackTable);

        placeTable.setBackground(new java.awt.Color(52, 62, 103));
        placeTable.setForeground(new java.awt.Color(255, 255, 255));
        placeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo Postal", "Ciudad", "Estado/Provincia", "Pais"
            }
        ));
        jScrollPane6.setViewportView(placeTable);

        addPlaceB.setBackground(new java.awt.Color(28, 33, 53));
        addPlaceB.setForeground(new java.awt.Color(255, 255, 255));
        addPlaceB.setText("Agregar");
        addPlaceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlaceBActionPerformed(evt);
            }
        });

        modifyPlaceB.setBackground(new java.awt.Color(28, 33, 53));
        modifyPlaceB.setForeground(new java.awt.Color(255, 255, 255));
        modifyPlaceB.setText("Modificar");
        modifyPlaceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyPlaceBActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ubicaciones");

        jButton1.setBackground(new java.awt.Color(28, 33, 53));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerrar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addUserB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyUserB))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addAdminB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyAdminB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteAdminB))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addRaceB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyRaceB))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(136, 136, 136)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addTrackB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ModifyTrackB))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addPlaceB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyPlaceB))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRaceB)
                    .addComponent(modifyRaceB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addUserB)
                            .addComponent(modifyUserB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addAdminB)
                            .addComponent(modifyAdminB)
                            .addComponent(deleteAdminB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addTrackB)
                            .addComponent(ModifyTrackB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addPlaceB)
                            .addComponent(modifyPlaceB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addRaceBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRaceBActionPerformed
        addRace a = new addRace();
        a.setVisible(true);
    }//GEN-LAST:event_addRaceBActionPerformed

    private void modifyRaceBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRaceBActionPerformed
        modifyRace m = new modifyRace();
        m.setVisible(true);
    }//GEN-LAST:event_modifyRaceBActionPerformed

    private void addUserBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBActionPerformed
        addUser a = new addUser();
        a.setVisible(true);
    }//GEN-LAST:event_addUserBActionPerformed

    private void modifyUserBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyUserBActionPerformed
        modifyUser m = new modifyUser();
        m.setVisible(true);
    }//GEN-LAST:event_modifyUserBActionPerformed

    private void addAdminBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminBActionPerformed
        addAdmin a = new addAdmin();
        a.setVisible(true);
    }//GEN-LAST:event_addAdminBActionPerformed

    private void addTrackBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrackBActionPerformed
        addTrack a = new addTrack();
        a.setVisible(true);
    }//GEN-LAST:event_addTrackBActionPerformed

    private void addPlaceBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlaceBActionPerformed
        addPlace a = new addPlace();
        a.setVisible(true);
    }//GEN-LAST:event_addPlaceBActionPerformed

    private void modifyAdminBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyAdminBActionPerformed
        modifyAdmin m = new modifyAdmin();
        m.setVisible(true);
    }//GEN-LAST:event_modifyAdminBActionPerformed

    private void ModifyTrackBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyTrackBActionPerformed
        modifyTrack m = new modifyTrack();
        m.setVisible(true);
    }//GEN-LAST:event_ModifyTrackBActionPerformed

    private void modifyPlaceBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyPlaceBActionPerformed
        modifyPlace m = new modifyPlace();
        m.setVisible(true);
    }//GEN-LAST:event_modifyPlaceBActionPerformed

    private void deleteAdminBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAdminBActionPerformed
        deleteAdmin d = new deleteAdmin();
        d.setVisible(true);
    }//GEN-LAST:event_deleteAdminBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainMenu m = new MainMenu();
        m.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuADM().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ModifyTrackB;
    private javax.swing.JButton addAdminB;
    private javax.swing.JButton addPlaceB;
    private javax.swing.JButton addRaceB;
    private javax.swing.JButton addTrackB;
    private javax.swing.JButton addUserB;
    private javax.swing.JTable adminTable;
    private javax.swing.JButton deleteAdminB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton modifyAdminB;
    private javax.swing.JButton modifyPlaceB;
    private javax.swing.JButton modifyRaceB;
    private javax.swing.JButton modifyUserB;
    private javax.swing.JTable placeTable;
    private javax.swing.JTable raceTable;
    private javax.swing.JTable trackTable;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
