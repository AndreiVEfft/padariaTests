package Mateus.Integração;

import daos.VendaDao;
import entity.Produto;
import entity.Venda;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RF04 {
    //RT01

    @Test
    public void criarVendaValida(){
        //Arrange
        Produto produto01;
        ArrayList<Produto> produtos = new ArrayList<>();
        Venda venda01;
        VendaDao venDao = new VendaDao();
        String cpfCliente = "11122233344";

        //Act
        produto01 = Produto.createProduto(1,"Pão de Queijo", 10,20,"Salgado");
        produtos.add(produto01);
        venda01 = Venda.createVenda(cpfCliente,"Dinheiro", 10, produtos);
        venDao.salvar(venda01);

        //Assert
        Assert.assertEquals(venda01.toString(), venDao.consultarPeloId(10).toString());
    }

    @Test
    public void validarVendaInvalida(){
        //Arrange
        Produto produto01;
        ArrayList<Produto> produtos = new ArrayList<>();
        Venda venda01;
        VendaDao venDao = new VendaDao();
        String cpfCliente = "32112345689";

        //Act
        produto01 = Produto.createProduto(1,"Pão de Queijo", 10,20,"Salgado");
        produtos.add(produto01);
        venda01 = Venda.createVenda(cpfCliente,"", -10, produtos);

        //Assert
        Assert.assertThrows(RuntimeException.class, () -> venDao.salvar(venda01));
    }
}
