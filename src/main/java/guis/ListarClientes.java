package guis;

import connection.Conexao;
import entity.Cliente;
import daos.ClienteDao;
import daos.ProdutoDao;
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
 * @author andre
 */
public class ListarClientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ListarClientes.class.getName());

    /**
     * Creates new form ListarClientes
     */
    public ListarClientes() {
        initComponents();
        this.setLocationRelativeTo(null); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btDelete1 = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(161, 126, 83));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(161, 126, 83));

        jTable1.setBackground(new java.awt.Color(203, 199, 180));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "Pontos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(153, 102, 0));
        jButton1.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 0));
        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btDelete1.setBackground(new java.awt.Color(153, 51, 0));
        btDelete1.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        btDelete1.setForeground(new java.awt.Color(102, 0, 0));
        btDelete1.setText("Deletar");
        btDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelete1ActionPerformed(evt);
            }
        });

        btEditar.setBackground(new java.awt.Color(51, 102, 0));
        btEditar.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        btEditar.setForeground(new java.awt.Color(0, 51, 0));
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btDelete1)
                        .addGap(45, 45, 45)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btEditar)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDelete1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar))
                .addGap(158, 158, 158))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn = null;
        
        try{
          conn = Conexao.getConnection();
        
          ClienteDao dao = new ClienteDao();
          List<Cliente> clientes = new ArrayList<>();
          DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
          
          String sql = "SELECT * FROM clientes";
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          
          df.setRowCount(0);
          
          while (rs.next()) {
                Object[] row = {rs.getInt("id_cliente"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"),rs.getDouble("pontos")};
                
                df.addRow(row);  
              }
          
            }
        catch(SQLException e ){
            throw new RuntimeException(e.getMessage());
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        
        MenuPrincipalFuncionario menuFuncionario = new MenuPrincipalFuncionario();
        menuFuncionario.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDelete1ActionPerformed
       DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
       ClienteDao dao = new ClienteDao();   
       
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
    }//GEN-LAST:event_btDelete1ActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
       DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
     
       
       int row = jTable1.getSelectedRow();
       int column = 0;
       
       
       Integer obj = (Integer) df.getValueAt(row, column); 
        
        EditarCliente editar = new EditarCliente(obj);
        editar.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_btEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete1;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
