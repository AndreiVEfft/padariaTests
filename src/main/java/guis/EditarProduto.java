package guis;

import daos.ProdutoDao;
import entity.Produto;

/**
 *
 * @author andre
 */
public class EditarProduto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditarProduto.class.getName());

  
    public EditarProduto(int id) {
        
        ProdutoDao dao = new ProdutoDao();
        
        Produto produto = new Produto();
        produto = dao.consultarPeloId(id);
        
        String idProd = String.valueOf(produto.getId());
        String nome = produto.getNome();
        String preco = String.valueOf(produto.getPreco());
        String quantidade = String.valueOf(produto.getQuantidadeEstoque());
        
        produto.toString();
                
        initComponents();
        
        lbId.setText(idProd);
        tfNome.setText(nome);
        tfPreco.setText(preco);
        tfQtd.setText(quantidade);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfQtd = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        cbTipoProduto = new javax.swing.JComboBox<>();
        lbResultado = new javax.swing.JLabel();
        btEditarProd = new javax.swing.JButton();
        lbId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(161, 126, 83));

        jLabel4.setFont(new java.awt.Font("Caviar Dreams", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 0));
        jLabel4.setText("Alteração de Produto");

        tfQtd.setBackground(new java.awt.Color(204, 204, 204));
        tfQtd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfPreco.setBackground(new java.awt.Color(204, 204, 204));
        tfPreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfNome.setBackground(new java.awt.Color(204, 204, 204));
        tfNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 51, 0));
        jLabel3.setText("Nome:");

        btCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btCancelar.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(102, 0, 0));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        cbTipoProduto.setBackground(new java.awt.Color(204, 204, 204));
        cbTipoProduto.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        cbTipoProduto.setForeground(new java.awt.Color(102, 51, 0));
        cbTipoProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pão", "Doce", "Bebida", "Doce", "Salgado", "Outro" }));
        cbTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoProdutoActionPerformed(evt);
            }
        });

        btEditarProd.setBackground(new java.awt.Color(0, 153, 0));
        btEditarProd.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        btEditarProd.setForeground(new java.awt.Color(0, 51, 0));
        btEditarProd.setText("Editar");
        btEditarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarProdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 0));
        jLabel6.setText("Preço:");

        jLabel7.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 51, 0));
        jLabel7.setText("Qtd. Estoque:");

        jLabel8.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 51, 0));
        jLabel8.setText("Tipo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbId)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(61, 61, 61))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(lbResultado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btEditarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btCancelar))
                                .addComponent(tfNome)
                                .addComponent(tfPreco)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfQtd)
                                        .addComponent(jLabel7))
                                    .addGap(31, 31, 31)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbTipoProduto, 0, 103, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbId)
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbTipoProduto)
                        .addGap(1, 1, 1)))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelar)
                    .addComponent(btEditarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbResultado)
                .addGap(26, 26, 26))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setVisible(false);

        MenuPrincipalFuncionario menu = new MenuPrincipalFuncionario();
        menu.setVisible(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void cbTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoProdutoActionPerformed
        String tipoSelecionado = (String) cbTipoProduto.getSelectedItem();
    }//GEN-LAST:event_cbTipoProdutoActionPerformed

    private void btEditarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarProdActionPerformed
        ProdutoDao dao = new ProdutoDao();
        
        Produto produto = new Produto();
        int id = Integer.parseInt(lbId.getText());
        
        produto = dao.consultarPeloId(id);
        
        
        Double preco = Double.parseDouble(tfPreco.getText());
        int quantidade = Integer.parseInt(tfQtd.getText());
        String tipo = (String) cbTipoProduto.getSelectedItem();
        
        produto.setNome(tfNome.getText());
        produto.setPreco(preco);
        produto.setQuantidadeEstoque(quantidade);
        produto.setTipo(tipo);
        
        dao.update(produto);
    }//GEN-LAST:event_btEditarProdActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditarProd;
    private javax.swing.JComboBox<String> cbTipoProduto;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbResultado;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfQtd;
    // End of variables declaration//GEN-END:variables
}
