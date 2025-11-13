package guis;

import daos.ClienteDao;
import entity.Cliente;
import entity.Pessoa;
import entity.Produto;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

/**
 *
 * @author arthu
 */
public class CatalogoCliente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CatalogoCliente.class.getName());
    private String[] produtosCatalogo = {" 01. Pão Francês" , " 02. Pão de Queijo" , " 03. Pão Doce (Com farofa) " , "04. Pão Doce (Liso)" , " 05. Café Expresso ", " 06. Rosca Tradicional " , " 07. Bolo de Cenoura "};
    private ArrayList<Produto> produtosCarrinho;
    private int contPaoFrances = 0; private int contPaoQueijo = 0;private int contPaoDoce = 0;private int contPaoLiso = 0;private int contCafeExpresso = 0;private int contRoscaTradicional = 0;private int contBoloCenoura = 0;
    private double totPagamento = 0;
    private LoginCliente loginCliente;
    
    
    public CatalogoCliente() {
        this.produtosCarrinho =  new ArrayList<Produto>();
        
        initComponents();
        
        lblTotalPedido.setText(calculaTotalPagamento() + " pts.");
        carregarDadosCliente();
    }

    
    public String[] getCtalogoList(){
	return this.produtosCatalogo;
    }

    public void addCarrinho(Produto produto){
	this.produtosCarrinho.add(produto);
    }
    
    private void atualizarPainelPedidos() {
    painelPedidos.removeAll();

    painelPedidos.setLayout(new BoxLayout(painelPedidos, BoxLayout.Y_AXIS));
    java.awt.Dimension tamanhoFixo = new java.awt.Dimension(245, 150);

    
    painelPedidos.setMinimumSize(tamanhoFixo);
    painelPedidos.setPreferredSize(tamanhoFixo);
    painelPedidos.setMaximumSize(tamanhoFixo);

    for (Produto p : this.produtosCarrinho) {
        JLabel lbl = new JLabel(p.getQuantidadeProdutosCatalogo() + "x " + p.toString());
        lbl.setFont(new Font("Caviar Dreams", Font.BOLD, 14));
        painelPedidos.add(lbl);
    }

    painelPedidos.revalidate();
    painelPedidos.repaint();
    
    }
    
    public double calculaTotalPagamento(){
        int qtdProdutos = 0; int ptProdutos= 0; double totalAcumulado = 0;
        
        for (Produto p : this.produtosCarrinho) {
                     
            totalAcumulado += (p.getQuantidadeProdutosCatalogo() * p.getValorPonto());
        }
       
       return totalAcumulado;
       
    }
    
    private javax.swing.JLabel labelNomeCliente; 
    private javax.swing.JLabel labelSaldoPontos; 

private void carregarDadosCliente() {
    LoginCliente loginCliente = new LoginCliente();
    
    String cpf = loginCliente.getCampoCpf();
    
    ClienteDao clienteDao = new ClienteDao();
    Cliente cliente = clienteDao.consultarPeloCpf(cpf);
   
        
    lblNomeCliente.setText(cliente.getNome()); 
    lblSaldo.setText("Saldo: " + (int)cliente.getTotPontosAcumulados());    
}


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btPaoFrances = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btPaoQueijo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btPaoDoce = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btPaoDoceLiso = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btCafeExpresso = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btRosca = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btBoloCenoura = new javax.swing.JButton();
        painelPedidos = new javax.swing.JPanel();
        btConfirma = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblTotalPedido = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblNomeCliente = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel12.setFont(new java.awt.Font("Stylus BT", 3, 14)); // NOI18N
        jLabel12.setText("01. Pão Francês ..........................");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jPanel2.setBackground(new java.awt.Color(255, 204, 168));
        jPanel2.setForeground(new java.awt.Color(255, 204, 168));

        jLabel2.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setText("01. Pão Francês .........................................");

        jLabel3.setFont(new java.awt.Font("Caviar Dreams", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 102, 0));
        jLabel3.setText("Produtos resgatáveis");

        jLabel4.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 0));
        jLabel4.setText("02 pt.");

        btPaoFrances.setBackground(new java.awt.Color(0, 102, 0));
        btPaoFrances.setText("+");
        btPaoFrances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaoFrancesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 0));
        jLabel5.setText("02. Pão de Queijo ...................................");

        jLabel6.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 0));
        jLabel6.setText("05 pt.");

        btPaoQueijo.setBackground(new java.awt.Color(0, 102, 0));
        btPaoQueijo.setText("+");
        btPaoQueijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaoQueijoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 51, 0));
        jLabel7.setText("04 pt.");

        btPaoDoce.setBackground(new java.awt.Color(0, 102, 0));
        btPaoDoce.setText("+");
        btPaoDoce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaoDoceActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Stylus BT", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 51, 0));
        jLabel8.setText("02. Pão de Queijo ..........................");

        jLabel9.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 51, 0));
        jLabel9.setText("05 pt.");

        btPaoDoceLiso.setBackground(new java.awt.Color(0, 102, 0));
        btPaoDoceLiso.setText("+");
        btPaoDoceLiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaoDoceLisoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Stylus BT", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 51, 0));
        jLabel10.setText("01. Pão Francês ..........................");

        jLabel13.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 51, 0));
        jLabel13.setText("03. Pão Doce (Com farofa) ..............");

        jLabel18.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 51, 0));
        jLabel18.setText("06. Rosca Tradicional .........................");

        jLabel19.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 51, 0));
        jLabel19.setText("04. Pão Doce (Liso) ...............................");

        jLabel20.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 51, 0));
        jLabel20.setText("04 pt.");

        btCafeExpresso.setBackground(new java.awt.Color(0, 102, 0));
        btCafeExpresso.setText("+");
        btCafeExpresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCafeExpressoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 51, 0));
        jLabel21.setText("05. Café Expresso ..................................");

        jLabel22.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 51, 0));
        jLabel22.setText("10 pt.");

        btRosca.setBackground(new java.awt.Color(0, 102, 0));
        btRosca.setText("+");
        btRosca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRoscaActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 51, 0));
        jLabel23.setText("07. Bolo de Cenoura ............................");

        jLabel24.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 51, 0));
        jLabel24.setText("20 pt.");

        btBoloCenoura.setBackground(new java.awt.Color(0, 102, 0));
        btBoloCenoura.setText("+");
        btBoloCenoura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBoloCenouraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(13, 13, 13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPaoFrances))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPaoQueijo))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btPaoDoce))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btPaoDoceLiso))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btCafeExpresso)))))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRosca)
                            .addComponent(btBoloCenoura))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btPaoFrances))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btPaoQueijo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btPaoDoce)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btPaoDoceLiso)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(btCafeExpresso)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(btRosca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(btBoloCenoura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelPedidos.setBackground(new java.awt.Color(255, 204, 168));
        painelPedidos.setForeground(new java.awt.Color(255, 204, 168));

        javax.swing.GroupLayout painelPedidosLayout = new javax.swing.GroupLayout(painelPedidos);
        painelPedidos.setLayout(painelPedidosLayout);
        painelPedidosLayout.setHorizontalGroup(
            painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        painelPedidosLayout.setVerticalGroup(
            painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        btConfirma.setBackground(new java.awt.Color(102, 153, 0));
        btConfirma.setForeground(new java.awt.Color(0, 51, 0));
        btConfirma.setText("Confirmar Resgate");
        btConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 204, 168));
        jPanel3.setForeground(new java.awt.Color(255, 204, 168));

        jLabel17.setFont(new java.awt.Font("Caviar Dreams", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 102, 0));
        jLabel17.setText("Pedidos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 168));
        jPanel4.setForeground(new java.awt.Color(255, 204, 168));

        jLabel25.setFont(new java.awt.Font("Caviar Dreams", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 102, 0));
        jLabel25.setText("Total:");

        lblTotalPedido.setBackground(new java.awt.Color(204, 153, 0));
        lblTotalPedido.setText( calculaTotalPagamento() + " pts ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(lblTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btCancelar.setForeground(new java.awt.Color(51, 0, 0));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSair.setBackground(new java.awt.Color(255, 102, 102));
        btSair.setForeground(new java.awt.Color(51, 0, 0));
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 204, 168));
        jPanel5.setForeground(new java.awt.Color(255, 204, 168));

        lblNomeCliente.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        lblNomeCliente.setForeground(new java.awt.Color(102, 51, 0));
        lblNomeCliente.setText("(NomeCliente)");

        lblSaldo.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(102, 51, 0));
        lblSaldo.setText("Saldo:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblNomeCliente))
                    .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensSistema/Catalogo.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(painelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(btConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(painelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(553, 553, 553))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmaActionPerformed
        this.setVisible(false);
        LoginCliente loginCliente = new LoginCliente();
    
        String cpf = loginCliente.getCampoCpf();
    
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.consultarPeloCpf(cpf);

        
        MsgConfirmarResgate msgConfirma = new MsgConfirmarResgate(cpf);
        msgConfirma.setVisible(true);
    }//GEN-LAST:event_btConfirmaActionPerformed

    private void btPaoFrancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaoFrancesActionPerformed
    Produto paoFrances = new Produto("Pão Francês", 1, 2);
    boolean produtoJaExiste = false;

    for (Produto p : this.produtosCarrinho) {
        if (p.getNome().equals(paoFrances.getNome())) {
            p.adicionaCarrinho(); 
            produtoJaExiste = true;
            break; 
        }
    }
    if (!produtoJaExiste) {
        addCarrinho(paoFrances);
    }

    atualizarPainelPedidos();
    lblTotalPedido.setText("R$ " + calculaTotalPagamento());
    }//GEN-LAST:event_btPaoFrancesActionPerformed

    private void btPaoQueijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaoQueijoActionPerformed
    Produto paoQueijo = new Produto("Pão de Queijo", 1, 5);
    boolean produtoJaExiste = false;

    for (Produto p : this.produtosCarrinho) {
        if (p.getNome().equals(paoQueijo.getNome())) {
            p.adicionaCarrinho(); 
            produtoJaExiste = true;
            break; 
        }
    }

    if (!produtoJaExiste) {
        addCarrinho(paoQueijo);
    }

    atualizarPainelPedidos();
    lblTotalPedido.setText("R$ " + calculaTotalPagamento());
    }//GEN-LAST:event_btPaoQueijoActionPerformed

    private void btPaoDoceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaoDoceActionPerformed
    Produto paoDoce = new Produto("Pão Doce com Farofa", 1, 4);
    boolean produtoJaExiste = false;

    for (Produto p : this.produtosCarrinho) {
        if (p.getNome().equals(paoDoce.getNome())) {
            p.adicionaCarrinho(); 
            produtoJaExiste = true;
            break; 
        }
    }

    if (!produtoJaExiste) {
        addCarrinho(paoDoce);
    }

    atualizarPainelPedidos();
    lblTotalPedido.setText("R$ " + calculaTotalPagamento());
    }//GEN-LAST:event_btPaoDoceActionPerformed

    private void btPaoDoceLisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaoDoceLisoActionPerformed
    Produto paoDoceLiso = new Produto("Pão Doce Liso", 1, 5);
    boolean produtoJaExiste = false;

    for (Produto p : this.produtosCarrinho) {
        if (p.getNome().equals(paoDoceLiso.getNome())) {
            p.adicionaCarrinho(); 
            produtoJaExiste = true;
            break; 
        }
    }

    if (!produtoJaExiste) {
        addCarrinho(paoDoceLiso);
    }

    atualizarPainelPedidos();
    lblTotalPedido.setText("R$ " + calculaTotalPagamento());
    }//GEN-LAST:event_btPaoDoceLisoActionPerformed

    private void btCafeExpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCafeExpressoActionPerformed
    Produto cafeExpresso = new Produto("Café Expresso", 1, 4);
    boolean produtoJaExiste = false;

    for (Produto p : this.produtosCarrinho) {
        if (p.getNome().equals(cafeExpresso.getNome())) {
            p.adicionaCarrinho(); 
            produtoJaExiste = true;
            break; 
        }
    }

    if (!produtoJaExiste) {
        addCarrinho(cafeExpresso);
    }

    atualizarPainelPedidos();
    lblTotalPedido.setText("R$ " + calculaTotalPagamento());
    }//GEN-LAST:event_btCafeExpressoActionPerformed

    private void btRoscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRoscaActionPerformed
    Produto rosca = new Produto("Rosca Tradicional", 1, 10);
    boolean produtoJaExiste = false;

    for (Produto p : this.produtosCarrinho) {
        if (p.getNome().equals(rosca.getNome())) {
            p.adicionaCarrinho(); 
            produtoJaExiste = true;
            break; 
        }
    }

    if (!produtoJaExiste) {
        addCarrinho(rosca);
    }

    atualizarPainelPedidos();
    lblTotalPedido.setText("R$ " + calculaTotalPagamento());
    }//GEN-LAST:event_btRoscaActionPerformed

    private void btBoloCenouraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBoloCenouraActionPerformed
    Produto boloCenoura = new Produto("Bolo de Cenoura", 1, 20);
    boolean produtoJaExiste = false;

    for (Produto p : this.produtosCarrinho) {
        if (p.getNome().equals(boloCenoura.getNome())) {
            p.adicionaCarrinho(); 
            produtoJaExiste = true;
            break; 
        }
    }

    if (!produtoJaExiste) {
        addCarrinho(boloCenoura);
    }

    atualizarPainelPedidos();
    lblTotalPedido.setText("R$ " + calculaTotalPagamento());
    }//GEN-LAST:event_btBoloCenouraActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setVisible(false);
        this.setVisible(true);
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.hide();
    }//GEN-LAST:event_btSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBoloCenoura;
    private javax.swing.JButton btCafeExpresso;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirma;
    private javax.swing.JButton btPaoDoce;
    private javax.swing.JButton btPaoDoceLiso;
    private javax.swing.JButton btPaoFrances;
    private javax.swing.JButton btPaoQueijo;
    private javax.swing.JButton btRosca;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTotalPedido;
    private javax.swing.JPanel painelPedidos;
    // End of variables declaration//GEN-END:variables

    public void setLoginCliente(LoginCliente loginCliente) {
        this.loginCliente = loginCliente;
        carregarDadosCliente();
    }
}
