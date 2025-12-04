package Mateus.Unitario;

import entity.Produto;
import entity.Venda;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RF09 {
    //RT01
    @Test
    public void deveRealizarVendaGenerica(){
        //Esse teste tem como objetivo validar
        //a criação de uma venda por meio de um
        //cliente genérico, caso o teste tenha sucesso
        //ele deve criar uma nova venda a qual vai
        //armazenar como cpf do cliente o valor "genérico"

        // Arrange
        ArrayList<Produto> produtos = new ArrayList<>();
        Produto prod01 = Produto.createProduto(0,"Pão de queijo", 5, 20, "Salgado");
        Venda vendaGenerica;
        produtos.add(prod01);
        // Act
        vendaGenerica = Venda.createVendaGenerica("Dinheiro", 10, produtos);
        // Assert
        Assert.assertNotNull(vendaGenerica);
        Assert.assertEquals("Genérico", vendaGenerica.getCpfCliente());
    }

    @Test
    public void validarVendaGenericaAcimaQuantidade(){
        //Esse teste tem como objetivo validar
        //a criação de uma venda por meio de um
        //cliente genérico, nele é realizado a
        //tentativa de adicionar produtos que
        //excedam a sua capacidade máxima de venda,
        //caso o teste tenha sucesso
        //ele deve falhar ao criar uma nova venda a qual vai
        //retornar um erro de quantidade de estoque em falta

        // Arrange
        ArrayList<Produto> produtos = new ArrayList<>();
        Produto prod01 = Produto.createProduto(0,"Pão de queijo", 5, 1, "Salgado");
        Venda vendaGenerica;
        produtos.add(prod01);
        produtos.add(prod01);
        // Act
        vendaGenerica = Venda.createVendaGenerica("Dinheiro", 10, produtos);
        // Assert
        Assert.assertNull(vendaGenerica);
    }
}
