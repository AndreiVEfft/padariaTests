package Mateus.Sistema;

import entity.Cliente;
import entity.Produto;
import entity.Venda;
import mock.ClienteMock;
import mock.ProdutoMock;
import mock.VendaMock;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RF09_RT01 {
    @Test
    public void atualizarProdutosVendaResgatadaCT01(){
        //Arrange
        Cliente clienteLogado;
        ClienteMock cliDao = new ClienteMock();
        Produto produto01;
        Produto produto02;
        ArrayList<Produto> produtos = new ArrayList<>();
        ProdutoMock proDao = new ProdutoMock();
        Venda venda01;
        VendaMock venDao = new VendaMock();

        //Act
        //Criação e armazenamento do usuário no banco mock
        clienteLogado = Cliente.createUser("Usuario Logado", "11122233344", "47999999999", 20);
        cliDao.salvar(clienteLogado);

        //Criação e armazenamento dos produtos no banco mock
        produto01 = Produto.createProduto(1,"Pão de Queijo", 10, 10,"Salgado");
        produto02 = Produto.createProduto(2,"Bolo de Cenoura", 10.5, 20,"Doce");
        proDao.salvar(produto01);
        proDao.salvar(produto02);

        //Criação e armazenamento da venda no banco
        produtos.add(produto01);
        produtos.add(produto02);
        venda01 = Venda.createVendaGenerica("Débito", 20.5, produtos);
        venDao.salvar(venda01);

        //Atualização do estoque dos produtos no banco mock
        proDao.update("Pão de Queijo",produto01);
        proDao.update("Bolo de Cenoura",produto02);

        //Assert
        Assert.assertNotNull(venda01);
        Assert.assertEquals(venDao.consultarPeloId(0).toString(), venda01.toString());
        System.out.printf(venDao.consultarPeloId(0).toString(), venda01.toString());
    }

    @Test
    public void validarVendaGenericaAcimaDaQuantidadeCT02(){
        //Arrange
        Cliente clienteLogado;
        ClienteMock cliDao = new ClienteMock();
        Produto produto01;
        Produto produto02;
        Produto produto03;
        Produto produto04;
        Produto produto05;
        Produto produto06;
        ArrayList<Produto> produtos = new ArrayList<>();
        ProdutoMock proDao = new ProdutoMock();
        Venda venda01;
        VendaMock venDao = new VendaMock();

        //Act
        //Criação e armazenamento do usuário no banco mock
        clienteLogado = Cliente.createUser("Usuario Logado", "11122233344", "47999999999", 20);
        cliDao.salvar(clienteLogado);

        //Criação e armazenamento dos produtos no banco mock
        produto01 = Produto.createProduto(1,"Pão de Queijo", 10, 10,"Salgado");
        produto02 = Produto.createProduto(2,"Bolo de Cenoura", 10.5, 20,"Doce");
        produto03 = Produto.createProduto(3,"Pastel de Carne", 8, 15,"Salgado");
        produto04 = Produto.createProduto(4,"Bolo de Chocolate", 15, 12,"Doce");
        produto05 = Produto.createProduto(5,"Sanduíche Natural de Frango", 12, 5,"Salgado");
        produto06 = Produto.createProduto(4,"Torta Alemã", 20, 10,"Doce");

        proDao.salvar(produto01);
        proDao.salvar(produto02);
        proDao.salvar(produto03);
        proDao.salvar(produto04);
        proDao.salvar(produto05);
        proDao.salvar(produto06);

        //Criação e armazenamento da venda no banco
        produtos.add(produto01);
        produtos.add(produto02);
        produtos.add(produto03);
        produtos.add(produto04);
        produtos.add(produto05);
        produtos.add(produto06);
        venda01 = Venda.createVendaGenerica("Débito", 20.5, produtos);
        venDao.salvar(venda01);

        //Atualização do estoque dos produtos no banco mock
        proDao.update("Pão de Queijo",produto01);
        proDao.update("Bolo de Cenoura",produto02);
        proDao.update("Pastel de Carne",produto03);
        proDao.update("Bolo de Chocolate",produto04);
        proDao.update("Sanduíche Natural de Frango",produto05);
        proDao.update("Torta Alemã",produto06);

        //Assert
        Assert.assertNull(venDao.consultarPeloId(0));
    }
}
