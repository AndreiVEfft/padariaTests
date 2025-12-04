package Kaike.Integracaoo;

import daos.ProdutoDAO;
import daos.VendaDao;
import entity.Produto;
import entity.Venda;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class RF04Test {
    
    @Test
    public void deveListarVendas(){
        
        //arrange
        String nome = "PÃO FRANCÊS";
        double preco = 4.99;
        int quantidade = 10;
        String tipo = "Salgado";
        int id = 1;
        
        ProdutoDAO prodDAO = new ProdutoDAO();
        prodDAO.delete(nome);
        Produto produto = Produto.createProduto(id,nome, preco, quantidade, tipo);
        prodDAO.salvar(produto);
        
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        
        String cpf = "11122233344";
        String mtPag = "Pix";
        double valorVenda = 10;
        
        VendaDao vendaDao = new VendaDao();
        vendaDao.deleteAll();
        Venda venda = Venda.createVenda(cpf, mtPag, valorVenda, produtos);
        vendaDao.salvar(venda);

        
        //act
        List<Venda> vendas = vendaDao.consultar();
        
        //assert
        Assertions.assertTrue(!vendas.isEmpty());
        Assertions.assertEquals(venda.getCpfCliente(), vendas.get(0).getCpfCliente());
    }
    
    @Test
    public void deveValidarListaDeVendasVazia(){
        
        //arrange
        VendaDao dao = new VendaDao();
        
        //act

        boolean excluiuVendas = dao.deleteAll();
        
        //assert
        Assertions.assertTrue(excluiuVendas);
    }
}
