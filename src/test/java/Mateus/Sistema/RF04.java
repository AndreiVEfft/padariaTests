package Mateus.Sistema;

import daos.ClienteDao;
import daos.VendaDao;
import entity.Cliente;
import entity.Produto;
import entity.Venda;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RF04 {
    //RT01

    @Test
    public void deveCriarVenda(){
        //Arrange
        Cliente clienteLogado;
        ClienteDao cliDao = new ClienteDao();
        Produto produto01;
        Produto produto02;
        ArrayList<Produto> produtos = new ArrayList<>();
        Venda venda01;
        VendaDao venDao = new VendaDao();

        //Act
        produto01 = Produto.createProduto(1,"Pão de Queijo", 10, 10,"Salgado");
        produto02 = Produto.createProduto(1,"Bolo de Cenoura", 10.5, 20,"Doce");

        produtos.add(produto01);
        produtos.add(produto02);
        venda01 = Venda.createVenda(cliDao.consultarPeloCpf("11122233344").getCpf(),"Débito", 20.5, produtos);
        venDao.salvar(venda01);

        //Assert
        Assert.assertNotNull(venda01);
        Assert.assertEquals(venDao.consultarPeloId(24).toString(), venda01.toString());
    }
}
