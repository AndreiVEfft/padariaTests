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

public class RF04_RT01 {
    //RT01
    @Test
    public void criarVendaValidaCT01(){
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

        //Assert
        Assert.assertNotNull(venda01);
        Assert.assertEquals(venDao.consultarPeloId(0).toString(), venda01.toString());
    }

    @Test
    public void validarVendaCPFInvalidoCT02(){
        //Arrange
        Cliente clienteLogado;
        ClienteMock cliDao = new ClienteMock();
        Produto produto01;
        Produto produto02;
        ArrayList<Produto> produtos = new ArrayList<>();
        ProdutoMock proDao = new ProdutoMock();

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

        //Assert da criação da venda
        Assert.assertThrows(NullPointerException.class, () -> Venda.createVenda(cliDao.consultarPeloCpf("11122244455").getCpf(),"Débito", 20.5, produtos));
    }
}
