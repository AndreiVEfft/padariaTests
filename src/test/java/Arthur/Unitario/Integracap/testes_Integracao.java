package Arthur.Unitario.Integracap;

import daos.ClienteDao;
import daos.ProdutoDAO;
import daos.VendaDao;
import entity.Cliente;
import entity.Produto;
import entity.Venda;
import mock.ClienteMock;
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
        // private Cliente(String nome, String cpf, String telefone, int pontos)
        cliente01 = Cliente.createUser(nomeTeste, cpfTeste, telefoneTeste, pontoTeste);

        clienteDao.delete(cpfTeste);

        clienteDao.salvar(cliente01);

    }

    @Test

    //REF01-RT03-CS01 - Consulta das informações enviadas ao banco

    public void testeRT03CS01() {

        List<Cliente> clientes = clienteDao.consultar();

        Cliente clienteEncontrado1 = clientes.stream()
                .filter(c -> c.getCpf().equals(cliente01.getCpf()))
                .findFirst()
                .orElse(null);

        assertNotNull(String.valueOf(clienteEncontrado1), "O Cliente 1 (Andrei) está na lista.");
        assertEquals(cliente01.getNome(), clienteEncontrado1.getNome(), "nome incorreto.");
        assertEquals(cliente01.getCpf(), clienteEncontrado1.getCpf(), "CPF incorreto.");
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

        Cliente clienteSalvo = clienteDao.consultarPeloCpf(cpfDelete);

        boolean resultado = clienteDao.delete(cpfTeste);

        assertTrue(resultado);

        Cliente clienteDeletado = clienteDao.consultarPeloCpf(cpfDelete);

        if (clienteDeletado != null && clienteDeletado.getNome() != null) {

            assertTrue("cliente encontrado no banco após a exclusão.", clienteDeletado.getNome().isEmpty() || clienteDeletado.getCpf().isEmpty());
        } else {
            assertNull( "Cliente encontrado no banco após a exclusão.", clienteDeletado);
        }
    }

    @Test

    //REF02-RT01-CS01 - Consultar usuário único

    public void testeRT02CS01(){
        String cpfConsulta = this.cliente01.getCpf();
        String nome = nomeTeste;

        clienteDao.salvar(cliente01);
        Cliente clienteConsultado = clienteDao.consultarPeloCpf(cpfConsulta);

        assertEquals(cpfConsulta, clienteConsultado.getCpf(), "CPF incorreto.");
        assertEquals(nomeTeste, clienteConsultado.getNome(), "Nome incorreto.");

        assertNotNull("Cliente encontrado no banco", clienteConsultado);
        assertEquals(cpfTeste, clienteConsultado.getCpf(), "CPF incorreto.");
        assertEquals(nomeTeste, clienteConsultado.getNome(), "Nome incorreto.");
        assertEquals(String.valueOf(pontoTeste), clienteConsultado.getPontos(), "Pontos incorretos.");

        // CLEANUP (Limpeza)
        clienteDao.delete(cpfTeste);
    }


    @Test

    //REF08-RT01-CS01 - Realizando venda e quantidade alterada

    public void testeREF08RT01CS01(){
        ProdutoDAO produtoDao = new ProdutoDAO();
        VendaDao vendaDao = new VendaDao();
        int estoqueInicial = 10;
        int qtdVendida = 6;
        Produto produto = Produto.createProduto("Pão", 10, estoqueInicial, "Pão");

        produtoDao.salvar(produto);

        Produto produtoVendido = Produto.createProduto("Pão", 10, qtdVendida, "Pão");
        ArrayList<Produto> produtosVendidos = new ArrayList<>();
        produtosVendidos.add(produtoVendido);

        Venda venda = new Venda();
        venda.setCpfCliente(cliente01.getCpf());
        venda.setProdutos( produtosVendidos);
        venda.setValorVenda(produto.getPreco() * produtoVendido.getQuantidade());

        vendaDao.salvar(venda);

        int estoqueFinal = estoqueInicial - qtdVendida;

        Produto produtoAtualizado = produtoDao.consultarPeloNome("Pão");

        assertNotNull("Produto não foi encontrado no BD após a venda.",produtoAtualizado);
        assertEquals("Falha na integração: Estoque no BD não foi decrementado corretamente.",estoqueFinal, produtoAtualizado.getQuantidade());

        produtoDao.delete("Pão");
    }
}
