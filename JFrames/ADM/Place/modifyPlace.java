package JFrames.ADM.Place;

import Clases.Place;
import Clases.ThreadClass;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import maguna.dominguez.tpi.sistema.de.carreras.ConnectionDB;

public class modifyPlace extends javax.swing.JFrame {
    private Place place;
    
    public modifyPlace() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        codeField2 = new javax.swing.JTextField();
        cityField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        stateField2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        countryField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        modifyB = new javax.swing.JButton();
        cancelB = new javax.swing.JButton();
        searchB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(28, 33, 53));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Modificar una Ubicacion");

        jLabel12.setText("Codigo Postal");

        codeField2.setBackground(new java.awt.Color(255, 255, 255));
        codeField2.setForeground(new java.awt.Color(0, 0, 0));

        cityField2.setBackground(new java.awt.Color(255, 255, 255));
        cityField2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setText("Ciudad");

        stateField2.setBackground(new java.awt.Color(255, 255, 255));
        stateField2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel14.setText("Estado / Provincia");

        countryField2.setBackground(new java.awt.Color(255, 255, 255));
        countryField2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel15.setText("País");

        modifyB.setBackground(new java.awt.Color(28, 33, 53));
        modifyB.setForeground(new java.awt.Color(255, 255, 255));
        modifyB.setText("Modificar");
        modifyB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBActionPerformed(evt);
            }
        });

        cancelB.setBackground(new java.awt.Color(28, 33, 53));
        cancelB.setForeground(new java.awt.Color(255, 255, 255));
        cancelB.setText("Cancelar");
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBActionPerformed(evt);
            }
        });

        searchB.setBackground(new java.awt.Color(28, 33, 53));
        searchB.setForeground(new java.awt.Color(255, 255, 255));
        searchB.setText("Buscar");
        searchB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codeField2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cityField2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(countryField2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stateField2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchB, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelB)
                .addGap(18, 18, 18)
                .addComponent(modifyB)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(codeField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchB))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cityField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(stateField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(countryField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyB)
                    .addComponent(cancelB))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBActionPerformed
        ThreadClass.updatePlace(
            this.place,
            cityField.getText(),
            stateField.getText(),
            countryField.getText(),
            () -> JOptionPane.showMessageDialog(null, "Lugar actualizado correctamente."),
            () -> JOptionPane.showMessageDialog(null, "Error al actualizar el lugar.", "Error", JOptionPane.ERROR_MESSAGE),
            () -> this.setVisible(false)
        );
    }//GEN-LAST:event_modifyBActionPerformed

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelBActionPerformed

    private void searchBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBActionPerformed
        String postalCode = codeField.getText().trim();

        ThreadClass.selectPlace(
            postalCode,
            place -> {
                cityField.setText(place.getCity());
                stateField.setText(place.getStateProvince());
                countryField.setText(place.getCountry());
                this.place = place;
            },
            () -> JOptionPane.showMessageDialog(null, "No se encontró un lugar con ese código postal.")
        );

    }//GEN-LAST:event_searchBActionPerformed

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
            java.util.logging.Logger.getLogger(modifyPlace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifyPlace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifyPlace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifyPlace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modifyPlace().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addB;
    private javax.swing.JButton addB1;
    private javax.swing.JButton cancelB;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField cityField1;
    private javax.swing.JTextField cityField2;
    private javax.swing.JTextField codeField;
    private javax.swing.JTextField codeField1;
    private javax.swing.JTextField codeField2;
    private javax.swing.JTextField countryField;
    private javax.swing.JTextField countryField1;
    private javax.swing.JTextField countryField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton modifyB;
    private javax.swing.JButton searchB;
    private javax.swing.JTextField stateField;
    private javax.swing.JTextField stateField1;
    private javax.swing.JTextField stateField2;
    // End of variables declaration//GEN-END:variables
}
