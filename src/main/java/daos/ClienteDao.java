package daos;

import entity.Cliente;
import connection.Conexao;
import interfaces.ICrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class ClienteDao implements ICrud<Cliente> {

    @Override
    public Cliente salvar(Cliente cliente) {
        Connection con = null;
        
        try{
             con = Conexao.getConnection();
              
             String sql = "insert into clientes(nome,cpf,telefone,pontos)values(?,?,?,?)";
             
             PreparedStatement smt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ResultSet rs = smt.getGeneratedKeys();    
             
             smt.setString(1,cliente.getNome());
             smt.setString(2,cliente.getCpf());
             smt.setString(3,cliente.getTelefone());
             smt.setInt(4,cliente.getTotPontosAcumulados());
             
             smt.execute();
        
             rs.next();
            }
              catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
        Conexao.fecharConexao();
    }
        return cliente;
        }
    @Override
    public Cliente update(Cliente cliente) {
       Connection con = null;
       PreparedStatement smt = null;
       
       String sql = "UPDATE clientes SET nome = ?, cpf = ?, telefone = ?, pontos =  ? WHERE id_cliente = " + cliente.getId();

    try {
        con = Conexao.getConnection();
        smt = con.prepareStatement(sql);

        smt.setString(1, cliente.getNome());
        smt.setString(2, cliente.getCpf());
        smt.setString(3, cliente.getTelefone());
        smt.setInt(4, cliente.getTotPontosAcumulados());
        
        smt.executeUpdate();
        
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao tentar atualizar o cliente: " + ex.getMessage());
    } 
    finally {
       Conexao.fecharConexao();
        }
        return cliente;
   } 

    @Override
    public List<Cliente> consultar() {
        List<Cliente> clientes = new ArrayList<>();
       Connection con = null;
      
       try{
        con = Conexao.getConnection();
        PreparedStatement smt = con.prepareStatement("SELECT * FROM clientes");
        
        ResultSet rs = smt.executeQuery();
        
        
        while(rs.next()){
            Cliente prod = new Cliente(rs.getInt("id_cliente"),rs.getString("nome"),rs.getString("cpf"),rs.getString("telefone"),rs.getInt("pontos"));
            clientes.add(prod);
        }
       }catch(SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
       finally{
           Conexao.fecharConexao();
       }
       return clientes;
    }

      
    @Override
    public void delete(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public boolean delete(int id) {
       
       Connection con = null;
       PreparedStatement smt = null;
 
       String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        
       try{
        con = Conexao.getConnection();

        smt = con.prepareStatement(sql);
        smt.setInt(1, id); 

        int linhasAfetadas = smt.executeUpdate(); 
        
        return linhasAfetadas > 0;
        
       }catch(SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
       finally{
           Conexao.fecharConexao();
       }
    } 
    
    public Cliente consultarPeloCpf(String cpf){ 
        Cliente cliente = new Cliente();
        String sql = "SELECT id_cliente, nome, cpf, telefone, pontos FROM clientes WHERE cpf = ?";
    
    try{
        Connection con = Conexao.getConnection();
        
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setString(1,cpf);
        ResultSet rs = smt.executeQuery();
       
        if (rs.next()) { 
            Cliente cli = new Cliente(
                rs.getInt("id_cliente"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("telefone"),
                rs.getInt("pontos")
            );
            cliente = cli; 
       
        }
       }catch(SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
       finally{
           Conexao.fecharConexao();
       }
       return cliente;
    }
    
    @Override
    public Cliente consultarPeloId(int id) {
       Cliente cliente = null;
       try{
        Connection con = Conexao.getConnection();
        PreparedStatement smt = con.prepareStatement("select * from clientes where id_cliente = " + id);
        
        ResultSet rs = smt.executeQuery();
        
        rs.next();
        
        Cliente prod = new Cliente(rs.getInt("id_cliente"),rs.getString("nome"),rs.getString("cpf"),rs.getString("telefone"),rs.getInt("pontos"));
          
        cliente = prod;
       }catch(SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
       finally{
           Conexao.fecharConexao();
       }
       return cliente;
    }
}
