package daos;

import connection.Conexao;
import entity.Produto;
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
 * @author Professor
 */
public class ProdutoDao implements ICrud<Produto> {

    @Override
    public Produto salvar(Produto obj) {
        Connection conexao = null;
        try{
            conexao = Conexao.getConnection();
            String sql = "insert into produtos (nome,preco,tipo,quantidade) values(?,?,?,?)";
            
             PreparedStatement smt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
             smt.setString(1,obj.getNome());
             smt.setDouble(2,obj.getPreco());
             smt.setString(3,obj.getTipo());
             smt.setInt(4,obj.getQuantidadeEstoque());
             
             smt.execute();
             
             try(ResultSet rs = smt.getGeneratedKeys()){
                 if(rs.next()){
                     int idGerado = rs.getInt(1);
                     obj.setId(idGerado);
                 }
             }
            
            
        } catch (SQLException ex) {
            System.getLogger(ProdutoDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return obj;
    }

    @Override
    public Produto update(Produto produto) {
       Connection con = null;
       PreparedStatement smt = null;
       
       String sql = "UPDATE produtos SET nome = ?, preco = ?, tipo = ?, quantidade = ? WHERE id_produto = " + produto.getId();

    try {
        con = Conexao.getConnection();
        smt = con.prepareStatement(sql);
        
        smt.setString(1, produto.getNome());
        smt.setDouble(2,produto.getPreco());
        smt.setString(3,produto.getTipo());
        smt.setInt(4, produto.getQuantidadeEstoque());
        
        smt.executeUpdate();
        }
        
        catch (SQLException ex) {
        throw new RuntimeException("Erro ao tentar atualizar o cliente: " + ex.getMessage());
    } 
        finally {
        Conexao.fecharConexao();
        }
        return produto;
    }

    @Override
    public List<Produto> consultar() {
        List<Produto> produtos = new ArrayList<>();
       Connection con = null;
      
       try{
        con = Conexao.getConnection();
        PreparedStatement smt = con.prepareStatement("select * from produtos");
        
        ResultSet rs = smt.executeQuery();
        
        
        while(rs.next()){
            Produto prod = new Produto(rs.getInt("id_produto"),rs.getString("nome"),rs.getDouble("preco"),rs.getString("tipo"),rs.getInt("quantidade"));
            produtos.add(prod);
        }
       }catch(SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
       finally{
           Conexao.fecharConexao();
       }
       return produtos;
    }

    @Override
    public void delete(Produto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
         Connection con = null;
         PreparedStatement smt = null;
         
         String sql = "DELETE FROM produtos WHERE id_produto = ? ";
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

    @Override
    public Produto consultarPeloId(int id) {
        Produto produto = null;
       try{
        Connection con = Conexao.getConnection();
        PreparedStatement smt = con.prepareStatement("select * from produtos where id_produto = " + id);
        
        ResultSet rs = smt.executeQuery();
        
        rs.next();
        
        Produto prod = new Produto(rs.getInt("id_produto"),rs.getString("nome"),rs.getDouble("preco"),rs.getString("tipo"),rs.getInt("quantidade"));
          
        produto = prod;
        
       }catch(SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
       finally{
           Conexao.fecharConexao();
       }
       return produto;

    }
    
    public Produto consultarPeloNome(String nome) {
        String sql = "SELECT * FROM produtos WHERE nome = ?";
        Produto prod = new Produto();
        try{
           
        Connection con = Conexao.getConnection();
        PreparedStatement smt = con.prepareStatement(sql);
      
        smt.setString(1,nome);
        ResultSet rs = smt.executeQuery();
        
        
        
        if (rs.next()) { 
            Produto produto = new Produto(
                rs.getInt("id_produto"),
                rs.getString("nome"),
                rs.getDouble("preco"),
                rs.getString("tipo"),
                rs.getInt("quantidade")
                
            );
            prod = produto;
        }
        
        
        
       }catch(SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
       finally{
           Conexao.fecharConexao();
       }
       return prod;

    }
    }

