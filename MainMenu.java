package tpi.sistema.de.carreras.TPI_Carreras;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();              
        fillcomboRace();              
        combo_race.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxDate();       
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button_log = new javax.swing.JButton();
        combo_race = new javax.swing.JComboBox<>();
        combo_date = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ImagePodium = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SearchSpecificRace = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(28, 33, 53));

        button_log.setBackground(new java.awt.Color(28, 33, 53));
        button_log.setForeground(new java.awt.Color(255, 255, 255));
        button_log.setText("Iniciar Sesion");
        button_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logActionPerformed(evt);
            }
        });

        combo_race.setBackground(new java.awt.Color(52, 62, 103));
        combo_race.setForeground(new java.awt.Color(255, 255, 255));
        combo_race.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_race.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_raceActionPerformed(evt);
            }
        });

        combo_date.setBackground(new java.awt.Color(52, 62, 103));
        combo_date.setForeground(new java.awt.Color(255, 255, 255));
        combo_date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_dateActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CIrcuito:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Resultado de los Participantes:");

        ImagePodium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tpi/sistema/de/carreras/TPI_Carreras/Podium 150x40.png"))); // NOI18N

        SearchSpecificRace.setBackground(new java.awt.Color(28, 33, 53));
        SearchSpecificRace.setForeground(new java.awt.Color(255, 255, 255));
        SearchSpecificRace.setText("Buscar");
        SearchSpecificRace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchSpecificRaceActionPerformed(evt);
            }
        });

        ResultTable.setBackground(new java.awt.Color(52, 62, 103));
        ResultTable.setForeground(new java.awt.Color(255, 255, 255));
        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Usuario", "Vehiculo", "Posicion"
            }
        ));
        ResultTable.setGridColor(new java.awt.Color(28, 33, 53));
        jScrollPane2.setViewportView(ResultTable);

        ImagePodium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tpi/sistema/de/carreras/TPI_Carreras/Podium 150x40.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 739, Short.MAX_VALUE)
                                .addComponent(button_log))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo_race, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel2)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(combo_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(SearchSpecificRace))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(190, 190, 190)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(ImagePodium, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(9, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ImagePodium, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_race, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchSpecificRace))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(button_log))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_logActionPerformed
        LogIn log = new LogIn();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_button_logActionPerformed

    private void SearchSpecificRaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchSpecificRaceActionPerformed
        String track = (String) combo_race.getSelectedItem();
    String dateTxt = (String) combo_date.getSelectedItem();

    try {
        SimpleDateFormat entrada = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date uDate = entrada.parse(dateTxt);
        java.sql.Date date = new java.sql.Date(uDate.getTime());

        java.util.List<String[]> players = ConexionDB.searchPlayers(track, date);

        DefaultTableModel model = (DefaultTableModel) ResultTable.getModel();
        model.setRowCount(0); // Limpiar tabla

        for (String[] row : players) {
            model.addRow(row); // Cada fila tiene [nick, vehicle, position]
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_SearchSpecificRaceActionPerformed

    private void combo_raceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_raceActionPerformed
        
    }//GEN-LAST:event_combo_raceActionPerformed

    private void combo_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_dateActionPerformed
        
    }//GEN-LAST:event_combo_dateActionPerformed
    private void fillcomboRace() {
        combo_race.removeAllItems();

        for (String nombre : ConexionDB.comboboxRace()) {
            combo_race.addItem(nombre);
        }
    }
    
    private void comboboxDate() {
        String SelectedTrack = (String) combo_race.getSelectedItem();
        if (SelectedTrack == null) return;

        combo_date.removeAllItems();

        for (String date : ConexionDB.comboboxDate(SelectedTrack)) {
            combo_date.addItem(date);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagePodium;
    private javax.swing.JTable ResultTable;
    private javax.swing.JButton SearchSpecificRace;
    private javax.swing.JButton button_log;
    private javax.swing.JComboBox<String> combo_date;
    private javax.swing.JComboBox<String> combo_race;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
   /* class FondoPanel extends MainMenu // No funciona, es para agregar una imagen de fondo
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Imagenes/TrackOriginal.png")).getImage();
            
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            //setOpaque(false);
            
            super.paint(g);
        }
    }*/

}
