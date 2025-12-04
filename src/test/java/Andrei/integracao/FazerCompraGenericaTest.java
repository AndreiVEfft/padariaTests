package Andrei.integracao;

import entity.Produto;
import entity.Venda;
import exceptions.VendaInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static entity.Produto.createProduto;
import static entity.Venda.createVendaGenerica;


public class FazerCompraGenericaTest {
    @Test
    public void criarVendaGenericaValida(){
        //Arrange
        Produto produto1 = createProduto(5,"Café 200mg",11.99,14, "Bebida");
        Produto produto2 = createProduto(7,"Bolacha recheada",3.99,10, "Doce");
        ArrayList<Produto> produtos=  new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        //Act
        Venda venda = createVendaGenerica("Pix",20,produtos);

        //Assert
        Assertions.assertNotNull(venda);
        Assertions.assertEquals("Pix", venda.getMtdPag());
    }
    @Test
    public void criarVendaGenericaInvalida(){
        //Arrange
        Produto produto1 = createProduto(5,"Café 200mg",11.99,14, "Bebida");
        Produto produto2 = createProduto(7,"Bolacha recheada",3.99,10, "Doce");
        ArrayList<Produto> produtos=  new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        //Act e Assert
        Assertions.assertNull(createVendaGenerica("",20,produtos));

    }
}
