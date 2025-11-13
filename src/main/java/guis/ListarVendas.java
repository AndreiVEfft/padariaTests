package guis;

import connection.Conexao;
import daos.VendaDao;
import entity.Venda;
import java.sql.Connection;
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
public class ListarVendas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ListarVendas.class.getName());


    public ListarVendas() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(161, 126, 83));
        jPanel1.setLayout(null);

        jTable1.setBackground(new java.awt.Color(203, 199, 180));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF_Cliente", "Valor", "Forma_Pag", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 460, 350);

        jButton1.setBackground(new java.awt.Color(94, 68, 15));
        jButton1.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(200, 410, 136, 40);

        btVoltar.setBackground(new java.awt.Color(153, 0, 0));
        btVoltar.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        btVoltar.setForeground(new java.awt.Color(51, 0, 0));
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btVoltar);
        btVoltar.setBounds(10, 10, 72, 22);

        btDelete.setBackground(new java.awt.Color(153, 0, 0));
        btDelete.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        btDelete.setForeground(new java.awt.Color(51, 0, 0));
        btDelete.setText("Deletar");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btDelete);
        btDelete.setBounds(60, 420, 72, 22);

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
        jPanel1.add(btEditar);
        btEditar.setBounds(400, 420, 72, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn = null;
        
        try{
          conn = Conexao.getConnection();
        
          VendaDao dao = new VendaDao();
          List<Venda> vendas = new ArrayList<>();
          DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
          
          String sql = "SELECT * FROM vendas";
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          
          df.setRowCount(0);
          
          while (rs.next()) {
                Object[] row = {rs.getInt("id_venda"), rs.getString("cpf_cliente"), rs.getDouble("valor_venda"), rs.getString("form_pag"),rs.getTimestamp("data_venda")};
                
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
        VendaDao dao = new VendaDao();

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

        EditarVenda editar = new EditarVenda(obj);
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
