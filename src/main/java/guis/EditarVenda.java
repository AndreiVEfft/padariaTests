package guis;

import daos.ClienteDao;
import daos.VendaDao;
import entity.Venda;

/**
 *
 * @author andre
 */
public class EditarVenda extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditarVenda.class.getName());

   
    public EditarVenda(int id) {
        VendaDao dao = new VendaDao();
        
        Venda venda = dao.consultarPeloId(id);
        
        String valor = String.valueOf(venda.getValor());
        
        initComponents();
        
        tfCPF.setText(venda.getCpf());
        tfValor.setText(valor);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btCad = new javax.swing.JButton();
        tfValor = new javax.swing.JTextField();
        tfCPF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        lbResult = new javax.swing.JLabel();
        cbFormaPag = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(161, 126, 83));

        jLabel4.setFont(new java.awt.Font("Caviar Dreams", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 0));
        jLabel4.setText("Registrar Vendas");

        btCad.setBackground(new java.awt.Color(70, 107, 70));
        btCad.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        btCad.setForeground(new java.awt.Color(0, 51, 0));
        btCad.setText("Cadastrar");
        btCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadActionPerformed(evt);
            }
        });

        tfValor.setBackground(new java.awt.Color(204, 204, 204));
        tfValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfCPF.setBackground(new java.awt.Color(204, 204, 204));
        tfCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCPFActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 51, 0));
        jLabel3.setText("CPF do Cliente:");

        btCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btCancelar.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(102, 0, 0));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        lbResult.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbResult.setRequestFocusEnabled(false);
        lbResult.setVerifyInputWhenFocusTarget(false);

        cbFormaPag.setBackground(new java.awt.Color(204, 204, 204));
        cbFormaPag.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        cbFormaPag.setForeground(new java.awt.Color(102, 51, 0));
        cbFormaPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Cartão de Crédito", "Dinheiro", "Cartão de Débito" }));

        jLabel5.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 0));
        jLabel5.setText("Valor:");

        jLabel6.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 0));
        jLabel6.setText("Forma de Pagamento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btCad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btCancelar))
                                .addComponent(tfCPF)
                                .addComponent(tfValor)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(75, 75, 75))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCad)
                    .addComponent(btCancelar))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadActionPerformed
        
       
        VendaDao dao = new VendaDao();
        ClienteDao clDao = new ClienteDao();
        
        String cpf = tfCPF.getText();
        String valor = tfValor.getText();
        String formPag = (String) cbFormaPag.getSelectedItem();

        if(!cpf.isEmpty() && !valor.isEmpty() && !formPag.isBlank() ){
            
            double valorD = Double.parseDouble(valor);
            Venda venda = new Venda(cpf,valorD,formPag);
            
            dao.salvar(venda);
            
            int div = ((int)valorD/10 )+ (clDao.consultarPeloCpf(cpf).getTotPontosAcumulados());
            
            clDao.consultarPeloCpf(cpf).setTotPontosAcumulados(div);
            
            lbResult.setText("Venda Registrada!");
        }
        else{
            lbResult.setText("Dados incorretos");
        }

    }//GEN-LAST:event_btCadActionPerformed

    private void tfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCPFActionPerformed

    }//GEN-LAST:event_tfCPFActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setVisible(false);

        MenuPrincipalFuncionario menu = new MenuPrincipalFuncionario();
        menu.setVisible(true);
    }//GEN-LAST:event_btCancelarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCad;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox<String> cbFormaPag;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbResult;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
