package Mateus.Unitario;

import entity.Cliente;
import entity.Produto;
import entity.Venda;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RF06 {
    //RT02
    @Test
    public void realizarVendaPontosCT01(){
        //Arrange
        Cliente cliente01;
        Produto produto01;
        ArrayList<Produto> produtos = new ArrayList<>();
        Venda venda01;

        //Act
        cliente01 = Cliente.createUser("Mateus Rissardi", "11122233345","54999999999", 100);
        produto01 = Produto.createProduto(1,"Pão de queijo", 10, 5,"Salgado");
        produtos.add(produto01);
        venda01 = Venda.createVendaResgatada(cliente01, cliente01.getCpf(),10, produtos);

        //Assert
        Assert.assertNotNull(venda01);
    }

    @Test
    public void validarSaldoInsuficienteCT02(){
        //Arrange
        Cliente cliente01;
        Produto produto01;
        ArrayList<Produto> produtos = new ArrayList<>();
        Venda venda01;

        //Act
        cliente01 = Cliente.createUser("Mateus Rissardi", "11122233345","54999999999", 0);
        produto01 = Produto.createProduto(1,"Pão de queijo", 10, 5,"Salgado");
        produtos.add(produto01);
        venda01 = Venda.createVendaResgatada(cliente01, cliente01.getCpf(),10, produtos);

        //Assert
        Assert.assertNull(venda01);
    }

    @Test
    public void validarVendaSemProdutosCT03(){
        //Arrange
        Cliente cliente01;
        Produto produto01;
        ArrayList<Produto> produtos = new ArrayList<>();
        Venda venda01;

        //Act
        cliente01 = Cliente.createUser("Mateus Rissardi", "11122233345","54999999999", 100);
        produto01 = Produto.createProduto(1,"Pão de queijo", 10, 5,"Salgado");
        venda01 = Venda.createVendaResgatada(cliente01, cliente01.getCpf(),10, produtos);

        //Assert
        Assert.assertNull(venda01);
    }
}
