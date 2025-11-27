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

public class RF08_RT01 {
    //RT01
    @Test
    public void atualizarProdutosVendaCT01(){
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
        venda01 = Venda.createVenda(cliDao.consultarPeloCpf("11122233344").getCpf(),"Débito", 20.5, produtos);
        venDao.salvar(venda01);

        //Atualização do estoque dos produtos no banco mock
        proDao.update("Pão de Queijo",produto01);
        proDao.update("Bolo de Cenoura",produto02);

        //Assert
        Assert.assertEquals(9, proDao.consultarPeloNome(produto01.getNome()).getQuantidade());
        Assert.assertEquals(19, proDao.consultarPeloNome(produto02.getNome()).getQuantidade());
    }

    @Test
    public void atualizarProdutosVendaResgatadaCT02(){
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
        venda01 = Venda.createVendaResgatada(cliDao.consultarPeloCpf("11122233344"), "11122233344", 20.5, produtos);
        venDao.salvar(venda01);

        //Atualização do estoque dos produtos no banco mock
        proDao.update("Pão de Queijo",produto01);
        proDao.update("Bolo de Cenoura",produto02);

        //Assert
        Assert.assertEquals(9, proDao.consultarPeloNome(produto01.getNome()).getQuantidade());
        Assert.assertEquals(19, proDao.consultarPeloNome(produto02.getNome()).getQuantidade());
    }
}
