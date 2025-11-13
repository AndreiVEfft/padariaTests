package guis;

/**
 *
 * @author arthu
 */
public class TelaInicialGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaInicialGUI.class.getName());
   
   
    public TelaInicialGUI() {
    initComponents();
    this.setLocationRelativeTo(null); 
}
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btEntrarCliente = new javax.swing.JButton();
        btEntrarFuncionario = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btEntrarCliente1 = new javax.swing.JButton();
        btEntrarFuncionario1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("Entrar como:");

        btEntrarCliente.setText("Cliente");

        btEntrarFuncionario.setText("Funcionário");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Padaria");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(161, 126, 83));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 350));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Caviar Dreams", 1, 18)); // NOI18N
        jLabel2.setText("Entrar como:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 30, 119, 30);

        btEntrarCliente1.setBackground(new java.awt.Color(234, 201, 144));
        btEntrarCliente1.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        btEntrarCliente1.setText("Cliente");
        btEntrarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarCliente1ActionPerformed(evt);
            }
        });
        jPanel1.add(btEntrarCliente1);
        btEntrarCliente1.setBounds(210, 200, 108, 22);

        btEntrarFuncionario1.setBackground(new java.awt.Color(234, 201, 144));
        btEntrarFuncionario1.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        btEntrarFuncionario1.setText("Funcionário");
        btEntrarFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarFuncionario1ActionPerformed(evt);
            }
        });
        jPanel1.add(btEntrarFuncionario1);
        btEntrarFuncionario1.setBounds(40, 200, 104, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensSistema/chefe-de-cozinha (1).png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 80, 120, 120);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensSistema/cliente (1).png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 80, 120, 120);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEntrarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarCliente1ActionPerformed
        this.setVisible(false);
        LoginCliente loginCliente = new LoginCliente();
        loginCliente.setVisible(true);
    }//GEN-LAST:event_btEntrarCliente1ActionPerformed

    private void btEntrarFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarFuncionario1ActionPerformed
         this.setVisible(false);
        LoginFuncionario loginFuncionario = new LoginFuncionario();
        loginFuncionario.setVisible(true);
    }//GEN-LAST:event_btEntrarFuncionario1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
        @Override
        public void run(){
            new TelaInicialGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrarCliente;
    private javax.swing.JButton btEntrarCliente1;
    private javax.swing.JButton btEntrarFuncionario;
    private javax.swing.JButton btEntrarFuncionario1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
