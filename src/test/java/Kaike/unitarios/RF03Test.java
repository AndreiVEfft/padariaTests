/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kaike.unitarios;

import entity.Produto;
import mock.ProdutoMock;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author user
 */
public class RF03Test {
    
    @Test
    public void deveDeletarProduto(){
        
        //arrange
        Produto produto = Produto.createProduto(1, "Bolo", 10.0, 15, "Doce");
        ProdutoMock dao = new ProdutoMock();
        dao.salvar(produto);
        
        //act
        dao.delete("Bolo");
        
        //assert
        Assert.assertNull(dao.consultarPeloNome("Bolo"));
    }
    
    @Test
    public void deveValidarDeletarProdutoInvalido(){
        
        //arrange
        Produto produto = Produto.createProduto(1, "Bolo", 10.0, 15, "Doce");
        ProdutoMock dao = new ProdutoMock();
        dao.salvar(produto);
        
        //assert e act
        Assert.assertFalse(dao.delete("Pão"));
    }
}
