package tests.Mateus.Integração;

import daos.VendaDao;
import entity.Produto;
import entity.Venda;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RF04 {
    //RT01
    @Test
    public void deveCriarVenda(){
        Venda venda01;
        VendaDao venDao = new VendaDao();
        ArrayList<Produto> produtos = new ArrayList<>();
        Produto prod01 = Produto.createProduto("Pão de queijo", 5, 20, "Salgado");

        produtos.add(prod01);

        venda01 = Venda.createVenda("12312312312", "Dinheiro", 10, produtos);
        //venDao.salvar(venda01);

        Assert.assertEquals(venda01.toString(), venDao.consultarPeloId(2).toString());
    }
}
