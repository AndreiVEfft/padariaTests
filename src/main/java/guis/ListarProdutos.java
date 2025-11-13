package guis;

import connection.Conexao;
import daos.ProdutoDao;
import entity.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arthu
 */
public class ListarProdutos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ListarProdutos.class.getName());

    public ListarProdutos() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(161, 126, 83));

        jTable1.setBackground(new java.awt.Color(203, 199, 180));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Tipo", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(94, 68, 15));
        jButton1.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btVoltar.setBackground(new java.awt.Color(153, 51, 0));
        btVoltar.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        btVoltar.setForeground(new java.awt.Color(51, 0, 0));
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btDelete.setBackground(new java.awt.Color(153, 0, 0));
        btDelete.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        btDelete.setForeground(new java.awt.Color(51, 0, 0));
        btDelete.setText("Deletar");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btEditar.setBackground(new java.awt.Color(51, 102, 0));
        btEditar.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        btEditar.setForeground(new java.awt.Color(51, 51, 0));
        btEditar.setText("Editar");
        btEditar.setActionCommand("");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btVoltar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btDelete)
                                .addGap(29, 29, 29)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btEditar)))
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete)
                    .addComponent(btEditar))
                .addGap(18, 18, 18))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn = null;

        try{
            conn = Conexao.getConnection();

            ProdutoDao dao = new ProdutoDao();
            List<Produto> produtos = new ArrayList<>();
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();

            String sql = "SELECT * FROM produtos";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            df.setRowCount(0);

            while (rs.next()) {
                Object[] row = {rs.getInt("id_produto"), rs.getString("nome"), rs.getDouble("preco"), rs.getString("tipo"),rs.getInt("quantidade")};

                df.addRow(row);

            }
        }
        catch(SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
        
        MenuPrincipalFuncionario menuFuncionario = new MenuPrincipalFuncionario();
        menuFuncionario.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
       DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
       ProdutoDao dao = new ProdutoDao();   
       
       int row = jTable1.getSelectedRow();
       int column = 0;
       
       
       Integer obj = (Integer) df.getValueAt(row, column); 
       
        System.out.println(obj);
     
       if(jTable1.getSelectedRowCount()==1){
           df.removeRow(jTable1.getSelectedRow());
           dao.delete(obj);
       }
       else{
           if(jTable1.getRowCount()== 0){
               JOptionPane.showMessageDialog(this, "Tabela está vazia!");
           }
           else{
               JOptionPane.showMessageDialog(this, "Selecione um item para deletar");
           }
       }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
       DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
     
       int row = jTable1.getSelectedRow();
       int column = 0;
       
       
       Integer obj = (Integer) df.getValueAt(row, column); 
        
        EditarProduto editar = new EditarProduto(obj);
        editar.setVisible(true);
        
        this.setVisible(false);
        
    }//GEN-LAST:event_btEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
