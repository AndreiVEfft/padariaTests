package Mateus.Integração;

import daos.VendaDao;
import entity.Cliente;
import entity.Produto;
import entity.Venda;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RF07 {
    //RT01
    @Test
    public void deveAdicionarPontosVendaCT01(){
        //Arrange
        Cliente cliente01;
        Produto produto01;
        Venda venda01;
        ArrayList<Produto> produtos = new ArrayList<>();
        VendaDao venDao = new VendaDao();

        //Act
        cliente01 = Cliente.createUser("Andrei", "56756756756", "47999999999", 0);
        produto01 = Produto.createProduto(1, "Pão de Queijo", 10, 20, "Salgado");
        produtos.add(produto01);
        venda01 = Venda.createVenda(cliente01.getCpf(), "Pix", 10, produtos);
        venDao.salvar(venda01);

        //Assert
        Assert.assertTrue(cliente01.getPontos()>0);
    }

    @Test
    public void deveRemoverPontosVendaCT02(){
        //Arrange
        Cliente cliente01;
        Produto produto01;
        Venda venda01;
        ArrayList<Produto> produtos = new ArrayList<>();
        VendaDao venDao = new VendaDao();

        //Act
        cliente01 = Cliente.createUser("Andrei", "56756756756", "47999999999", 10);
        produto01 = Produto.createProduto(1, "Pão de Queijo", 10, 20, "Salgado");
        produtos.add(produto01);
        venda01 = Venda.createVendaResgatada(cliente01 ,cliente01.getCpf(), 10, produtos);
        venDao.salvar(venda01);

        //Assert
        Assert.assertEquals(9, cliente01.getPontos());
    }
}
