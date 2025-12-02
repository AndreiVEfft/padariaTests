/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kaike.Integracaoo;

import daos.ProdutoDAO;
import daos.VendaDao;
import entity.Produto;
import entity.Venda;
import exceptions.VendaInvalidaException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class RF09Test {
    
    @Test
    public void deveCriarVendaGenerica() {
        //arrange
        String nome = "PÃO FRANCÊS";
        double preco = 4.99;
        int quantidade = 10;
        String tipo = "Salgado";
        int id = 3;
        
        ProdutoDAO prodDAO = new ProdutoDAO();
        prodDAO.delete(nome);
        Produto produto = Produto.createProduto(id, nome, preco, quantidade, tipo);
        prodDAO.salvar(produto);
        
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        
        String mtPag = "Pix";
        double valorVenda = 8.00;
        
        VendaDao dao = new VendaDao();
        Venda venda = Venda.createVendaGenerica(mtPag, valorVenda, produtos);
        dao.salvar(venda);
        
        //act
        List<Venda> vendas = new ArrayList<>();
        vendas.add(dao.consultarPeloId(42));
        
        //assert
        Assertions.assertEquals("Genérico", vendas.getFirst().getCpfCliente());

    }
    
    @Test
    public void deveValidarQuantidadeDeProdutosMuitoAlta(){
        String nome = "BOLO DE BOLACHA";
        double preco = 9.99;
        int quantidade = 15;
        String tipo = "Doce";
        int id = 4;
        
        ProdutoDAO prodDAO = new ProdutoDAO();
        prodDAO.delete(nome);
        Produto produto = Produto.createProduto(id, nome, preco, quantidade, tipo);
        prodDAO.salvar(produto);
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        for (int i = 0; i < 7; i++){
            produtos.add(produto);
        }
        
        String mtPag = "Boleto";
        double valorVenda = 40.00;
        
        //act e assert
        Assertions.assertThrows(VendaInvalidaException.class, () ->
                Venda.createVendaGenerica(mtPag, valorVenda, produtos)
        );
        
    }
}

