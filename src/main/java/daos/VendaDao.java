package daos;

import connection.Conexao;
import entity.Produto;
import entity.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class VendaDao {
  
    public Venda salvar(Venda venda) {
        
        try{
            Timestamp dataHoraAtual = new Timestamp(System.currentTimeMillis());
            Connection conexao = Conexao.getConnection();
            String sql = "insert into vendas (cpf_cliente,valor_venda,form_pag,data_venda) values(?,?,?,?)";
            
             PreparedStatement smt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
             smt.setString(1,venda.getCpf());
             smt.setDouble(2,venda.getValor());
             smt.setString(3, venda.getFormaPag());
             smt.setTimestamp(4, dataHoraAtual);
             
             smt.execute();     
        } 
        catch (SQLException ex) {
            System.getLogger(ProdutoDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return venda;
    }
    public Venda update(Venda venda){
         Connection con = null;
       PreparedStatement smt = null;
       
       String sql = "UPDATE vendas SET cpf_cliente = ?, valor_venda = ?, form_pag = ? WHERE id_venda = " + venda.getId();

    try {
        con = Conexao.getConnection();
        smt = con.prepareStatement(sql);
        
        smt.setString(1, venda.getCpf());
        smt.setDouble(2,venda.getValor());
        smt.setString(3,venda.getFormaPag());
        
        smt.executeUpdate();
        }
    catch (SQLException ex) {
        throw new RuntimeException("Erro ao tentar atualizar o cliente: " + ex.getMessage());
    } 
        finally {
        Conexao.fecharConexao();
        }
        return null;
    }

    public List<Venda> consultar() {
        List<Venda> vendas = new ArrayList<>();
       Connection con = null;
      
       try{
        con = Conexao.getConnection();
        PreparedStatement smt = con.prepareStatement("select * from vendas");
        
        ResultSet rs = smt.executeQuery();
        
        
       }catch(SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
       finally{
           Conexao.fecharConexao();
       }
       return vendas;
    }

    public boolean delete(int id) {
       Connection con = null;
       PreparedStatement smt = null;

       String sql = "DELETE FROM vendas WHERE id_venda = ?";
        
       try{
        con = Conexao.getConnection();
        
        smt = con.prepareStatement(sql);
        smt.setInt(1, id); 
        
        int linhasAfetadas = smt.executeUpdate(); 
        
        return linhasAfetadas > 0;

       }catch(SQLException ex){
           throw new RuntimeException();
       }
       finally{
           Conexao.fecharConexao();
       }
    }

    public Venda consultarPeloId(int id) {
       Venda venda  = null;
       try{
        Connection con = Conexao.getConnection();
        PreparedStatement smt = con.prepareStatement("select * from vendas where id_venda = " + id);
        
        ResultSet rs = smt.executeQuery();
        rs.next();
   
        Venda ven = new Venda(rs.getString("cpf_cliente"),rs.getDouble("valor_venda"),rs.getString("form_pag"));
          
        venda = ven;

       }catch(SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
       finally{
           Conexao.fecharConexao();
       }
       return venda;
    }
}
