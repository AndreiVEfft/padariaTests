/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kaike.Sistema;

import daos.ClienteDao;
import daos.ProdutoDAO;
import daos.VendaDao;
import entity.Cliente;
import entity.Produto;
import entity.Venda;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author user
 */
public class RF07Test {
    
    @Test
    public void deveValidarQuantidadeDePontosCliente(){
        
        //arrange
        Cliente cliente = Cliente.createUser("Kaike", "11831869918", "47992042889", 10);
        Produto produto = Produto.createProduto("Pão francês", 4.99, 10, "Salgado");
    
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto);
        
        ClienteDao cliDAO = new ClienteDao();
        ProdutoDAO prodDAO = new ProdutoDAO();
        VendaDao venDAO = new VendaDao();
        
        cliDAO.salvar(cliente);
        prodDAO.salvar(produto);
        
        //act e assert
        Assert.assertEquals(10, cliDAO.consultarPeloCpf(cliente.getCpf()).getPontos());
    }
    
    @Test
    public void deveValidarQuantidadePontosAposVenda(){
        
        //arrange
        Cliente cliente2 = Cliente.createUser("João", "11831869917", "47992042889", 1);
        Produto produto = Produto.createProduto("Pão francês", 6.00, 10, "Salgado");
    
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto);
        
        ClienteDao cliDAO = new ClienteDao();
        ProdutoDAO prodDAO = new ProdutoDAO();
        VendaDao venDAO = new VendaDao();
        
        cliDAO.salvar(cliente2);
        prodDAO.salvar(produto);
        
        //act
        Venda venda = Venda.createVenda(cliente2.getCpf(), "Pix", 12.00, produtos);
        venDAO.salvar(venda);
        
        //assert
        Assert.assertEquals(2, cliDAO.consultarPeloCpf(cliente2.getCpf()).getPontos());
    }
    
    @Test
    public void deveValidarQuantidadePontosNovoCliente() {
        
        //arrange
        Cliente cliente3 = Cliente.createUser("Caio", "11831869919", "47992042889", 0);
        ClienteDao cliDAO = new ClienteDao();
        
        cliDAO.salvar(cliente3);
        
        //assert
        Assert.assertEquals(0, cliDAO.consultarPeloCpf(cliente3.getCpf()).getPontos());
    }
    
    
}
