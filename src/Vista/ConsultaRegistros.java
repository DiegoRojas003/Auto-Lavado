
package Vista;


public class ConsultaRegistros extends javax.swing.JPanel {

 
    public ConsultaRegistros() {
        initComponents();
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableResultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jcomboBusqueda = new javax.swing.JComboBox<>();
        jtextBusqueda1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtextBusqueda2 = new javax.swing.JTextField();
        jbuttonBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 26, 56));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Funcionario", "Tipo de Servicio", "Tipo de Vehiculo", "Valor"
            }
        ));
        jScrollPane1.setViewportView(jtableResultados);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 762, 140));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Buscar Por: ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 19, -1, -1));

        jcomboBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Servicio", "Funcionario", "Fecha" }));
        add(jcomboBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 16, 136, -1));
        add(jtextBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 57, 175, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Diguite su Busqueda:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 60, -1, -1));

        jtextBusqueda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextBusqueda2ActionPerformed(evt);
            }
        });
        add(jtextBusqueda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 57, 186, -1));

        jbuttonBuscar.setText("Buscar");
        add(jbuttonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 56, 95, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lavado-a-presion (1).jpg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void jtextBusqueda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextBusqueda2ActionPerformed
        
    }//GEN-LAST:event_jtextBusqueda2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbuttonBuscar;
    public javax.swing.JComboBox<String> jcomboBusqueda;
    public javax.swing.JTable jtableResultados;
    public javax.swing.JTextField jtextBusqueda1;
    public javax.swing.JTextField jtextBusqueda2;
    // End of variables declaration//GEN-END:variables
}
