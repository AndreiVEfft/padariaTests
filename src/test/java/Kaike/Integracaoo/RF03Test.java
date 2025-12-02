/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kaike.Integracaoo;

import daos.ProdutoDAO;
import org.junit.jupiter.api.Test;
import entity.Produto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author user
 */
public class  RF03Test{
   
    @Test
    public void deveListarProdutosCadastrados(){
        
        //arrange
        String nome = "PÃO FRANCÊS";
        double preco = 4.99;
        int quantidade = 10;
        String tipo = "Salgado";
        int id = 2;
        
        ProdutoDAO prodDAO = new ProdutoDAO();
        prodDAO.delete(nome);
        Produto produto = Produto.createProduto(id,nome, preco, quantidade, tipo);
        
        
        //act
        prodDAO.salvar(produto);
        //assert
        Assertions.assertEquals(nome, prodDAO.consultarPeloNome(nome).getNome());
    }
    
    @Test
    public void deveDeletarProduto(){
        
        //arrange
        String nome = "PÃO DE FORMA";
        double preco = 14.99;
        int quantidade = 5;
        String tipo = "Salgado";
        int id = 3; 
        ProdutoDAO prodDAO = new ProdutoDAO();
        prodDAO.delete(nome);
        Produto produto = Produto.createProduto(id, nome, preco, quantidade, tipo);
        
        
        //act
        prodDAO.salvar(produto);
        prodDAO.delete(nome);
        
        //assert
        Assertions.assertEquals(0, prodDAO.consultar().size());
    }

}

