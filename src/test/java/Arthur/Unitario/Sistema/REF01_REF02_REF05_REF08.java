package Arthur.Unitario.Sistema;

import static org.junit.jupiter.api.Assertions.*;

import daos.ProdutoDAO;
import daos.VendaDao;
import entity.Cliente;
import entity.Produto;
import entity.Venda;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class REF01_REF02_REF05_REF08 {

    //TESTES DE SISTEMA - ARTHUR
    private static final String nomeProdutoTeste = "Pão de forma";
    private static VendaDao dao = new VendaDao();

    @Test
    //REF01-RT01 CS01 - Produto cadastrado
    public void ref01CS01() {
        Produto produto = Produto.createProduto(nomeProdutoTeste, 6.50, 20, "Pão");
        ProdutoDAO dao = new ProdutoDAO();

        dao.delete(nomeProdutoTeste);

        dao.salvar(produto);

        Produto produtoSalvo = dao.consultarPeloNome(nomeProdutoTeste);

        assertNotNull(produtoSalvo);
        assertEquals(nomeProdutoTeste, produtoSalvo.getNome(), "Nome não compativel");
        assertEquals(6.50, produtoSalvo.getPreco(), "Preço não compativel");
        assertEquals("Pão", produtoSalvo.getTipo(), "Tipo não compativel");
        assertEquals(20, produtoSalvo.getQuantidade(), "Quantidade de estoque não compativel");
    }

    @Test

    //REF01-RT01-CS02 - Produto já cadastrado

    public void ref01CS02() {
        ProdutoDAO dao = new ProdutoDAO();

        dao.delete(nomeProdutoTeste);

        Produto produtoCriado = Produto.createProduto(nomeProdutoTeste, 6.50, 20, "Pão");

        dao.salvar(produtoCriado);

        Produto produtoDuplicado = Produto.createProduto(
                produtoCriado.getNome(),
                6.50,
                20,
                "Pão"
        );

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            dao.salvar(produtoDuplicado);
        });

        assertTrue(exception.getMessage().contains("Produto já cadastrado!"),
                "A mensagem de exceção deveria ser 'Produto já cadastrado!'.");
    }

    @Test

    //REF02-RT02-CS01 - Exclusão de produto

    public void ref02CS01() {
        ProdutoDAO dao = new ProdutoDAO();

        dao.delete(nomeProdutoTeste);

        Produto produtoDelete = Produto.createProduto(nomeProdutoTeste, 6.50, 20, "Pão");

        Produto produtoconsulta = dao.consultarPeloNome(nomeProdutoTeste);

        assertNotNull(produtoDelete.getNome());

        boolean resultado = dao.delete(nomeProdutoTeste);

        assertTrue(resultado);

        Produto produtoDeletado = dao.consultarPeloNome(nomeProdutoTeste);

        assertTrue(produtoDeletado.getNome() == null, "Produto não foi excluido");
    }

    @Test

    //REF05-RT02-CS01 - Alterar método de pagamento
    //Provavelmente teste vai dar errado
    public void ref05RT01CS01() {
        String formaPagamentoNova = "Cartão de crédito";
        ArrayList<Produto> produtos = new ArrayList<>();


        Venda vendaSemId = Venda.createVenda("11122233344", "Pix", 10.50, produtos);
        dao.salvar(vendaSemId);

        int idAposSalvar = vendaSemId.getId();

        assertEquals(0, idAposSalvar, "O ID DEVE ser 0/null, provando que o DAO.salvar() não está retornando o ID.");
    }

    @Test

    //REF08-RT01-CS01 - Validar novo estoque após venda

    public void ref08RT01CS01() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        VendaDao vendaDao = new VendaDao();
        String formaPagamentoNova = "Cartão de crédito";
        int estoqueInicial = 10;
        int vendidos = 6;

        produtoDAO.delete(nomeProdutoTeste);
        Produto produtoEstoque = Produto.createProduto(nomeProdutoTeste, 10.0, estoqueInicial, "INTEGRACAO");
        produtoDAO.salvar(produtoEstoque);

        Produto itemVendido = Produto.createProduto(nomeProdutoTeste, 10.0, vendidos, "INTEGRACAO");
        ArrayList<Produto> produtosVendidos = new ArrayList<>();
        produtosVendidos.add(itemVendido);



        Venda venda = Venda.createVenda("11122233344", "Pix",50.0,produtosVendidos);

        vendaDao.salvar(venda);

        int estoqueEsperado = estoqueInicial - vendidos;


        Produto produtoAtualizado = produtoDAO.consultarPeloNome(nomeProdutoTeste);

        assertNotNull(produtoAtualizado, "Produto não foi encontrado no BD após a venda.");


        assertEquals(estoqueEsperado, produtoAtualizado.getQuantidade(),
                "Estoque incorreto! Esperado: " + estoqueEsperado + ", Atual: " + produtoAtualizado.getQuantidade());
        produtoDAO.delete(nomeProdutoTeste);
    }
}

