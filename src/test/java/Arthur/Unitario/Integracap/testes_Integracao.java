package Arthur.Unitario.Integracap;

import daos.ClienteDao;
import daos.ProdutoDAO;
import daos.VendaDao;
import entity.Cliente;
import entity.Produto;
import entity.Venda;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//TESTES DE INTEGRAÇÃO

public class testes_Integracao {
    private ClienteDao clienteDao;
    private Cliente cliente01;
    private static final String nomeTeste = "Andrei";
    private static final String cpfTeste = "11122233344";
    private static final int pontoTeste = 10;
    private static final String telefoneTeste = "48999999999";


    @BeforeEach
    void setUp() {

        clienteDao = new ClienteDao();
        cliente01 = Cliente.createUser(nomeTeste, cpfTeste, telefoneTeste, pontoTeste);

        clienteDao.delete(cpfTeste);

        clienteDao.salvar(cliente01);

    }

    @Test

    //REF01-RT03-CS01 - Consulta das informações enviadas ao banco

    public void testeRT03CS01() {

        List<Cliente> clientes = clienteDao.consultar();

        Cliente clienteEncontrado1 = clienteDao.consultarPeloCpf(cliente01.getCpf());

        assertNotNull(String.valueOf(clienteEncontrado1), "O Cliente 1 (Andrei) está na lista.");
        assertEquals(cliente01.getNome(), clienteEncontrado1.getNome());
        assertEquals(cliente01.getCpf(), clienteEncontrado1.getCpf());
        assertEquals(cliente01.getPontos(), clienteEncontrado1.getPontos());

        clienteDao.delete(cpfTeste);
    }


    @Test

    //REF01-RT04-CS01 - Validar a exclusão completa de um usuário nos registros do banco de dados

    public void testeRT04CS01() {
        String cpfDelete = "00000000000";
        String nomeDelete = "Deletavel";
        Cliente clienteTesteDelete = Cliente.createUser( nomeDelete, cpfDelete, "00000000000", 0);

        clienteDao.salvar(clienteTesteDelete);

        clienteDao.delete(cpfDelete);

        Cliente clienteDeletado = clienteDao.consultarPeloCpf(cpfDelete);

        Assert.assertNull(clienteDeletado);

    }

    @Test

    //REF02-RT01-CS01 - Consultar usuário único

    public void testeRT02CS01(){
        String cpfConsulta = cpfTeste;

        Cliente clienteConsultado = clienteDao.consultarPeloCpf(cpfConsulta);

        assertEquals(cpfConsulta, clienteConsultado.getCpf());
        assertEquals(nomeTeste.toUpperCase(), clienteConsultado.getNome());

        assertNotNull("Cliente encontrado no banco", clienteConsultado);
        assertEquals(cpfTeste, clienteConsultado.getCpf());
        assertEquals(nomeTeste.toUpperCase(), clienteConsultado.getNome());
        assertEquals(pontoTeste, clienteConsultado.getPontos());
    }


    @Test

    //REF08-RT01-CS01 - Realizando venda e quantidade alterada

    public void testeREF08RT01CS01(){
        ProdutoDAO produtoDao = new ProdutoDAO();
        VendaDao vendaDao = new VendaDao();
        produtoDao.delete("Pão");
        int estoqueInicial = 24;
        int qtdVendida = 6;
        Produto produto = Produto.createProduto(1,"Pão", 10, estoqueInicial, "Salgado");

        produtoDao.salvar(produto);

        ArrayList<Produto> produtosVendidos = new ArrayList<>();
        produtosVendidos.add(produto);
        produtosVendidos.add(produto);
        produtosVendidos.add(produto);


        Venda venda = Venda.createVenda(cliente01.getCpf(), "Dinheiro", produto.getPreco() * 3, produtosVendidos);
        vendaDao.salvar(venda);

        Produto produtoAtualizado =  produtoDao.update("Pão", produto);

        assertNotNull("Produto não foi encontrado no BD após a venda.",produtoAtualizado);
        assertEquals("Falha na integração: Estoque no BD não foi decrementado corretamente.",21, produtoAtualizado.getQuantidade());

        produtoDao.delete("Pão");
    }
}
