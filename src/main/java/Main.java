import daos.ClienteDao;
import daos.ProdutoDAO;
import daos.VendaDao;
import entity.Cliente;
import entity.Produto;
import entity.Venda;

import java.util.ArrayList;
import java.util.Scanner;

import static entity.Cliente.createUser;
import static entity.Produto.createProduto;
import static entity.Venda.createVenda;
import static entity.Venda.createVendaGenerica;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ClienteDao clienteDao = new ClienteDao();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        VendaDao vendaDao = new VendaDao();

        System.out.println("************************\n Sistema Login\n Digite seu cpf:");
        String cpf = scan.nextLine();

        while (true) {

            if (cpf.equalsIgnoreCase("admin")) {
                System.out.println("Bem-vindo admin:\n 1 - Cliente \n 2 - Produto \n 3 - Venda \n 4 - Sair");
                int escolha = scan.nextInt();
                switch (escolha) {

                    case 1:
                        System.out.println("\n 1 - Consultar clientes \n 2 - Consultar pelo Cpf \n 3 - Cadastrar cliente \n 4 - Editar cliente \n 5 - Deletar cliente \n 6 - Sair");

                        int cliEs = scan.nextInt();

                        if (cliEs == 1) {
                            clienteDao.consultar();
                        }
                        if (cliEs == 2) {
                            System.out.println("Digite o Cpf:");
                            scan.nextLine();
                            String cpfCliente = scan.nextLine();

                            if (cpfCliente.isEmpty() || cpfCliente.isBlank() || cpfCliente.length() != 11) {
                                System.out.println("Cpf inválido!");
                            } else {
                                System.out.println("\n" + clienteDao.consultarPeloCpf(cpfCliente) + "\n");
                            }

                        }

                        if (cliEs == 3) {
                            System.out.println("Digite o nome:");
                            scan.nextLine();
                            String nome = scan.nextLine();

                            System.out.println("Digite o Cpf:");
                            String cpfCliente = scan.nextLine();

                            System.out.println("Digite o telefone:");
                            String telefone = scan.nextLine();

                            Cliente cliente = createUser(nome, cpfCliente, telefone, 0);
                            clienteDao.salvar(cliente);
                        }
                        if (cliEs == 4) {
                            System.out.println("Digite o cpf do cliente para edição: ");
                            scan.nextLine();

                            Cliente cliente = clienteDao.consultarPeloCpf(scan.nextLine());

                            System.out.println("Editar " + cliente.getNome() + "? S/n");
                            scan.nextLine();
                            if (scan.nextLine().equalsIgnoreCase("s")) {
                                System.out.println("Nome: " + cliente.getNome());
                                scan.nextLine();
                                String nome = scan.nextLine();
                                cliente.setNome(nome);
                                System.out.println("Cpf: " + cliente.getCpf());
                                scan.nextLine();
                                cliente.setCpf(scan.nextLine());
                                System.out.println("Telefone: " + cliente.getTelefone());
                                scan.nextLine();
                                cliente.setTelefone(scan.nextLine());
                            }
                        }
                        if (cliEs == 5) {
                            System.out.println("Digite o cpf do cliente para excluir: ");
                            scan.nextLine();

                            Cliente cliente = clienteDao.consultarPeloCpf(scan.nextLine());
                            System.out.println("Deseja excluir " + cliente.getNome() + "? S/n");
                            scan.nextLine();
                            String cpfCliente = scan.nextLine();
                            ;

                            if (scan.nextLine().equalsIgnoreCase("s")) {
                                clienteDao.delete(cpfCliente);
                            }
                        }
                    case 2:
                        System.out.println("\n 1 - Consultar produtos \n 2 - Consultar pelo Id \n 3 - Cadastrar produto \n 4 - Editar produto \n 5 - Deletar produto \n 6 - Sair");

                        int prodEs = scan.nextInt();

                        if (prodEs == 1) {
                            produtoDAO.consultar();
                        }
                        if (prodEs == 2) {
                            System.out.println("Digite o id:");
                            scan.nextLine();
                            int idProduto = scan.nextInt();

                            System.out.println("\n" + produtoDAO.consultarPeloId(idProduto) + "\n");
                        }

                        if (prodEs == 3) {
                            System.out.println("Digite o Id:");
                            scan.nextLine();
                            int id = scan.nextInt();

                            System.out.println("Digite o Nome:");
                            String nome = scan.nextLine();

                            System.out.println("Digite o Preço:");
                            double preco = scan.nextDouble();

                            System.out.println("Digite a Quantidade:");
                            int quantidade = scan.nextInt();

                            System.out.println("Digite o Tipo (Doce,Salgado,Bebida,Pão):");
                            String tipo = scan.nextLine();

                            Produto produto = createProduto(id,nome,preco,quantidade, tipo);
                            produtoDAO.salvar(produto);
                        }
                        if (prodEs == 4) {
                            System.out.println("Digite o id do cliente para edição: ");
                            scan.nextLine();

                            Produto produto = produtoDAO.consultarPeloId(scan.nextInt());

                            System.out.println("Editar " + produto.getNome() + "? S/n");
                            scan.nextLine();
                            if (scan.nextLine().equalsIgnoreCase("s")) {

                                System.out.println("Nome: " + produto.getNome());
                                scan.nextLine();
                                String nome = scan.nextLine();
                                produto.setNome(nome);

                                System.out.println("Preco: " + produto.getPreco());
                                scan.nextLine();
                                produto.setPreco(scan.nextDouble());

                                System.out.println("Quantidade: " + produto.getQuantidade());
                                scan.nextLine();
                                produto.setQuantidade(scan.nextInt());

                                System.out.println("Tipo (Doce,Salgado,Bebida,Pão): " + produto.getTipo());
                                scan.nextLine();
                                produto.setTipo(scan.nextLine());
                            }
                        }
                        if (prodEs == 5) {
                            System.out.println("Digite o id do produto para edição: ");
                            scan.nextLine();

                            Produto produto = produtoDAO.consultarPeloId(scan.nextInt());
                            System.out.println("Deseja excluir " + produto.getNome() + "? S/n");
                            scan.nextLine();
                            String cpfCliente = scan.nextLine();

                            if (scan.nextLine().equalsIgnoreCase("s")) {
                                produtoDAO.delete(cpfCliente);
                            }
                        }
                    case 3 :

                        System.out.println("\n 1 - Consultar vendas \n 2 - Consultar pelo Id \n 3 - Cadastrar venda \n 4 - Deletar venda \n 5 - Sair");

                        int vendEs = scan.nextInt();

                        if (vendEs == 1) {
                            vendaDao.consultar();
                        }
                        if (vendEs == 2) {
                            System.out.println("Digite o id:");
                            scan.nextLine();
                            int idVenda = scan.nextInt();

                            System.out.println("\n" + vendaDao.consultarPeloId(idVenda) + "\n");
                        }

                        if (vendEs == 3) {
                            System.out.println("Venda genérica? S/n");
                            scan.nextLine();

                            if(scan.nextLine().equalsIgnoreCase("s")){
                                System.out.println("Digite o método de pagamento (Pix, Dinheiro, Débito, Crédito)");
                                scan.nextLine();
                                String mtdPagamento = scan.nextLine();

                                System.out.println("Digite o valor da venda");
                                scan.nextLine();
                                double valor = scan.nextDouble();

                                ArrayList<Produto> produtos = new ArrayList<>();
                                System.out.println("Selecione os produtos: ");
                                produtoDAO.consultar();
                                scan.nextInt();
                                int id = scan.nextInt();
                                produtos.add(produtoDAO.consultarPeloId(id));

                                Venda venda = createVendaGenerica(mtdPagamento,valor,produtos);
                                vendaDao.salvar(venda);
                            }
                            else{
                                System.out.println("Digite o cpf do cliente:");
                                clienteDao.consultar();
                                scan.nextLine();
                                String cpfCliente = scan.nextLine();

                                System.out.println("Digite o método de pagamento (Pix, Dinheiro, Débito, Crédito)");
                                scan.nextLine();
                                String mtdPagamento = scan.nextLine();

                                System.out.println("Digite o valor da venda");
                                scan.nextLine();
                                double valor = scan.nextDouble();

                                ArrayList<Produto> produtos = new ArrayList<>();
                                System.out.println("Selecione os produtos: ");
                                produtoDAO.consultar();
                                scan.nextInt();
                                int id = scan.nextInt();
                                produtos.add(produtoDAO.consultarPeloId(id));
                                Venda venda = createVenda(cpfCliente,mtdPagamento,valor,produtos);

                                vendaDao.salvar(venda);
                            }
                        }
                        if (vendEs == 4) {
                            vendaDao.consultar();
                            System.out.println("Digite o id da venda para excluir: ");
                            scan.nextInt();
                            int idVenda = scan.nextInt();
                            System.out.println("Deseja excluir venda do id " + idVenda + "? S/n");

                            if (scan.nextLine().equalsIgnoreCase("s")) {
                                vendaDao.delete(idVenda);
                            }
                        }
                }
            }
        }
    }
}

