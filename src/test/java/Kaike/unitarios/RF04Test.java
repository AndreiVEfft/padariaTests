/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kaike.unitarios;

import entity.Produto;
import entity.Venda;
import java.util.ArrayList;

import mock.VendaMock;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author user
 */
public class RF04Test {
    
    
    @Test
    public void deveEditarVenda(){
        
        //arrange
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = Produto.createProduto(1, "Bolo", 10.0, 15, "Doce");
        VendaMock venDao = new VendaMock();
        produtos.add(produto);
        Venda venda = Venda.createVenda("11831869918", "Pix", 20.50, produtos);
        Venda vendaUpd = Venda.createVenda("12345678910", "Dinheiro", 25.9, produtos);
        venDao.salvar(venda);

        //act
        venda = venDao.update(vendaUpd,0);
        
        //assert
        Assert.assertEquals(25.9, venda.getValorVenda(), 0.0001);
        Assert.assertEquals("12345678910", venda.getCpfCliente());
        Assert.assertEquals("Dinheiro", venda.getMtdPag());
    }
    
    @Test
    public void deveValidarEdicaoDeClienteVenda(){
        //arrange
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = Produto.createProduto(1, "Bolo", 10.0, 15, "Doce");
        VendaMock venDao = new VendaMock();
        produtos.add(produto);
        Venda venda = Venda.createVenda("11831869918", "Pix", 20.50, produtos);
        Venda vendaUpd = Venda.createVenda("12345678910", "Dinheiro", 25.9, produtos);
        venDao.salvar(venda);

        //act
        venda = venDao.update(vendaUpd, 0);

        //assert
        Assert.assertEquals("12345678910", venda.getCpfCliente());
    }
    
    @Test
    public void deveValidarEditarMetdPagamentoVenda(){
        //arrange
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = Produto.createProduto(1, "Bolo", 10.0, 15, "Doce");
        VendaMock venDao = new VendaMock();
        produtos.add(produto);
        Venda venda = Venda.createVenda("11831869918", "Pix", 20.50, produtos);
        Venda vendaUpd = Venda.createVenda("12345678910", "Dinheiro", 25.9, produtos);
        venDao.salvar(venda);

        //act
        venda = venDao.update(vendaUpd, 0);

        //assert
        Assert.assertEquals("Dinheiro", venda.getMtdPag());
    }
    
    @Test
    public void deveValidarEditarValorVenda(){
        //arrange
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = Produto.createProduto(1, "Bolo", 10.0, 15, "Doce");
        VendaMock venDao = new VendaMock();
        produtos.add(produto);
        Venda venda = Venda.createVenda("11831869918", "Pix", 20.50, produtos);
        Venda vendaUpd = Venda.createVenda("12345678910", "Dinheiro", 25.9, produtos);
        venDao.salvar(venda);

        //act
        venda = venDao.update(vendaUpd,0);
        
        //assert
        Assert.assertEquals(25.9, venda.getValorVenda(), 0.0001);
    }
    
    @Test
    public void deveValidarEdicaoIncorretaVenda(){
        
        //conte casos 5 a 7
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = Produto.createProduto(1, "Bolo", 10.0, 15, "Doce");
        VendaMock venDao = new VendaMock();
        produtos.add(produto);
        Venda venda = Venda.createVenda("11831869918", "Pix", 20.50, produtos);
        Venda vendaUpd = Venda.createVenda("", "", 0, produtos);
        venDao.salvar(venda);

        //act
        venDao.update(vendaUpd, 0);
        
        //assert
        Assert.assertEquals(20.50, venDao.consultarPeloId(0).getValorVenda(), 0.0001);
        Assert.assertEquals("11831869918", venDao.consultarPeloId(0).getCpfCliente());
        Assert.assertEquals("Pix", venDao.consultarPeloId(0).getMtdPag());
    }
    
}
