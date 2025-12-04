package Andrei.unitarios;

import daos.ProdutoDAO;
import daos.VendaDao;
import entity.Produto;
import entity.Venda;
import exceptions.VendaInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static entity.Produto.createProduto;
import static entity.Venda.createVenda;

public class CadastrarVendasTest {

    @Test
    public void deveCadastrarVendaCorreta(){
        //Arrange
        VendaDao dao = new VendaDao();
        dao.deleteAll();
        String cpfCliente = "18945667781";
        String mtdPagamento ="Dinheiro";
        double valor = 50;

        Produto produto1 =createProduto(5,"Café 200mg",11.99,14, "Bebida");
        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(produto1);

        Venda venda = createVenda(cpfCliente,mtdPagamento,valor,produtos);

        //Act
        dao.salvar(venda);

        //Assert
        Assertions.assertNotNull(venda);
        System.out.println("Venda realizada com sucesso");
    }
    @Test
    public void naoDeveCadastrarVendaComCpfInexistente() throws VendaInvalidaException {
        // Arrange
        VendaDao dao = new VendaDao();
        dao.deleteAll();
        Produto produto1 =createProduto(5,"Café 200mg",11.99,14, "Bebida");
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);

        Venda venda = createVenda("0000000000", "Pix", 50,produtos);

        // Act e Assert
        RuntimeException excecao = Assertions.assertThrows(RuntimeException.class, () -> {
            dao.salvar(venda);
        });
        System.out.println(excecao.getMessage());
    }
    @Test
    public void naoDeveCadastrarVendaComTipoDePagamentoInexistente() throws VendaInvalidaException {
        // Arrange
        VendaDao dao = new VendaDao();
        dao.deleteAll();
        Produto produto1 =createProduto(5,"Café 200mg",11.99,14, "Bebida");
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);

        Venda venda = createVenda("00000000000", "", 50,produtos);

        // Act e Assert
        RuntimeException excecao = Assertions.assertThrows(RuntimeException.class, () -> {
            dao.salvar(venda);
        });
        System.out.println(excecao.getMessage());
    }
    @Test
    public void naoDeveCadastrarVendaComValorInvalido() throws VendaInvalidaException {
        // Arrange
        VendaDao dao = new VendaDao();
        dao.deleteAll();
        Produto produto1 =createProduto(5,"Café 200mg",11.99,14, "Bebida");
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);

        Venda venda = createVenda("00000000000", "Pix", 0,produtos);

        // Act e Assert
        RuntimeException excecao = Assertions.assertThrows(RuntimeException.class, () -> {
            dao.salvar(venda);
        });
        System.out.println(excecao.getMessage());
    }

}


