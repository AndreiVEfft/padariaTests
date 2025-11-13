package guis;

import daos.ClienteDao;
import daos.ProdutoDao;
import daos.VendaDao;
import entity.Cliente;
import entity.Produto;
import entity.Venda;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arthu
 */
public class RegistrarVendas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegistrarVendas.class.getName());

    public RegistrarVendas() {
        
        initComponents();
        tfQtd.setText("0");
        carregarProdutos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btCad = new javax.swing.JButton();
        tfCPF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        lbResult = new javax.swing.JLabel();
        cbFormaPag = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        tfValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfQtd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        tfCPF.setBackground(new java.awt.Color(204, 204, 204));
        tfCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCPF.setForeground(new java.awt.Color(102, 51, 0));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 0));
        jLabel1.setText("Produto:");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setText("Forma de Pagamento: ");

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

        lbResult.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbResult.setRequestFocusEnabled(false);
        lbResult.setVerifyInputWhenFocusTarget(false);

        cbFormaPag.setBackground(new java.awt.Color(204, 204, 204));
        cbFormaPag.setForeground(new java.awt.Color(102, 51, 0));
        cbFormaPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Cartão de Crédito", "Dinheiro", "Cartão de Débito" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teste" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        tfValor.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 0));
        jLabel5.setText("Valor:");

        jLabel6.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 0));
        jLabel6.setText("Qtd:");

        jButton1.setText("Calcular ");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(90, 90, 90))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCPF)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btCad)
                                        .addGap(44, 44, 44)
                                        .addComponent(btCancelar))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(cbFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(lbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCad)
                    .addComponent(btCancelar))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        Cliente cliente = clDao.consultarPeloCpf(cpf);
        if(cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "CPF com maior de 11 Caracteres!");
        }
        if(!cpf.isEmpty() && !valor.isEmpty() && !formPag.isBlank() ){
            
            double valorD = Double.parseDouble(valor);
            
            Venda venda = new Venda(cpf,valorD,formPag);
            
            dao.salvar(venda);
            
            int pontos = cliente.getTotPontosAcumulados();
            
            int div = ((int)valorD/10 )+ (pontos);
            
            cliente.setTotPontosAcumulados(div);
            clDao.update(cliente);
            
            lbResult.setText("Venda Registrada!");
        }   
        else{
            lbResult.setText("Dados incorretos");
        }
    }//GEN-LAST:event_btCadActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setVisible(false);

        MenuPrincipalFuncionario menu = new MenuPrincipalFuncionario();
        menu.setVisible(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ProdutoDao dao = new ProdutoDao();
        String nome = (String) jComboBox1.getSelectedItem();
        
        
        int quantidade = Integer.parseInt(tfQtd.getText());
        
        if(quantidade > 0 && !tfQtd.getText().isEmpty() && !tfQtd.getText().isBlank()){
            double preco = dao.consultarPeloNome(nome).getPreco() * quantidade ;
        
            tfValor.setText("R$" + preco);
        }
        else{
            lbResult.setText("Quantidade deve ser maior que zero!");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
   private void carregarProdutos() {
        ProdutoDao dao = new ProdutoDao();
        List<Produto> produtos = dao.consultar();
        for (Produto produto : produtos) {
            jComboBox1.addItem(produto.getNome());
        }
    }
    
    public static void main(String[] args) {
        RegistrarVendas vendas = new RegistrarVendas();
        vendas.setVisible(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCad;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox<String> cbFormaPag;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbResult;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfQtd;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
