package Arthur.Unitario.Sistema;

import static org.junit.jupiter.api.Assertions.*;

import daos.ProdutoDAO;
import daos.VendaDao;
import entity.Cliente;
import entity.Produto;
import entity.Venda;
import org.junit.Assert;
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
        Produto produto = Produto.createProduto(1, nomeProdutoTeste, 6.50, 20, "Salgado");
        ProdutoDAO dao = new ProdutoDAO();

        dao.delete(nomeProdutoTeste);

        dao.salvar(produto);

        Produto produtoSalvo = dao.consultarPeloNome(nomeProdutoTeste);

        assertNotNull(produtoSalvo);
        assertEquals(nomeProdutoTeste.toUpperCase(), produtoSalvo.getNome());
        assertEquals(6.50, produtoSalvo.getPreco());
        assertEquals("Salgado", produtoSalvo.getTipo());
        assertEquals(20, produtoSalvo.getQuantidade());
    }

    @Test

    //REF01-RT01-CS02 - Produto já cadastrado

    public void ref01CS02() {
        ProdutoDAO dao = new ProdutoDAO();

        dao.delete(nomeProdutoTeste);

        Produto produtoCriado = Produto.createProduto(1,nomeProdutoTeste, 6.50, 20, "Salgado");

        dao.salvar(produtoCriado);

        Produto produtoDuplicado = produtoCriado;

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

        Produto produtoDelete = Produto.createProduto(1,nomeProdutoTeste, 6.50, 20, "Salgado");

        dao.salvar(produtoDelete);

        assertNotNull(dao.consultarPeloNome(nomeProdutoTeste).getNome());

        boolean resultado = dao.delete(produtoDelete.getNome());

        assertTrue(resultado);

        Produto produtoDeletado = dao.consultarPeloNome(nomeProdutoTeste);

        assertNull(produtoDeletado);
    }

    @Test

    //REF05-RT02-CS01 - Alterar método de pagamento
    //Provavelmente teste vai dar errado
    public void ref05RT01CS01() {
        String formaPagamentoNova = "Cartão de crédito";
        ArrayList<Produto> produtos = new ArrayList<>();


        Venda vendaSemId = Venda.createVenda("11122233344", "Pix", 10.50, produtos);
        dao.salvar(vendaSemId);

        //int idAposSalvar = vendaSemId.getId();

        assertNull(vendaSemId, "O ID DEVE ser 0/null, provando que o DAO.salvar() não está retornando o ID.");
    }

    @Test

    //REF08-RT01-CS01 - Validar novo estoque após venda

    public void ref08RT01CS01() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        VendaDao vendaDao = new VendaDao();
        int estoqueInicial = 10;
        int vendidos = 6;

        produtoDAO.delete(nomeProdutoTeste);
        vendaDao.delete(13);
        Produto produtoEstoque = Produto.createProduto(1,nomeProdutoTeste, 10.0, estoqueInicial, "Salgado");
        produtoDAO.salvar(produtoEstoque);

        ArrayList<Produto> produtosVendidos = new ArrayList<>();
        produtosVendidos.add(produtoEstoque);
        produtosVendidos.add(produtoEstoque);
        produtosVendidos.add(produtoEstoque);
        produtosVendidos.add(produtoEstoque);

        Venda venda = Venda.createVenda("11122233344", "Pix",40,produtosVendidos);

        vendaDao.salvar(venda);

        Produto produtoAtualizado = produtoDAO.update(produtoEstoque.getNome(), produtoEstoque);

        assertNotNull(produtoAtualizado, "Produto não foi encontrado no BD após a venda.");

        assertEquals(vendidos, produtoAtualizado.getQuantidade(),
                "Estoque incorreto! Esperado: " + vendidos + ", Atual: " + produtoAtualizado.getQuantidade());
    }
}

