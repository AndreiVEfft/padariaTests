/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kaike.unitarios;

import entity.Produto;
import entity.Venda;
import exceptions.VendaInvalidaException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author user
 */
public class RF08Test {
    
    
    @Test
    public void deveValidarQuantidadeEmEstoqueAposVenda(){
        
        //arrange
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = Produto.createProduto(1, "Bolo", 10.0, 15, "Doce");
        
        produtos.add(produto);
        //act
        Venda venda = Venda.createVenda("11831869918", "Pix", 20.50, produtos);
        
        //assert
        Assert.assertEquals(14, produto.getQuantidade());
    }
    
    @Test
    public void deveValidarQuantidadeInsuficiente(){
        
        //arrange
        ArrayList<Produto> produtos = new ArrayList<>();
        Produto produto = Produto.createProduto(1, "Bolo", 10.0, 1, "Doce");
        
        produtos.add(produto);
        produtos.add(produto);
        produtos.add(produto);
        produtos.add(produto);
        produtos.add(produto);
        
        System.out.println(produto.getQuantidade());
        
        //asert e act
        Assert.assertNull(Venda.createVenda("11831869918", "Pix", 20.50, produtos));
       
    }
}
