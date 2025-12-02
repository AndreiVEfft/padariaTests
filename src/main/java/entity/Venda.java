package entity;

import daos.ClienteDao;
import exceptions.VendaInvalidaException;

import java.util.ArrayList;


public class Venda {

    private String cpfCliente;
    private String mtdPag;
    private double valorVenda;


    private ArrayList<Produto> produtos = new ArrayList<>();

    public Venda() {}

    private Venda(String cpfCliente, String mtdPag, double valorVenda,  ArrayList<Produto>produtos) {
        this.cpfCliente = cpfCliente;
        this.mtdPag = mtdPag;
        this.valorVenda = valorVenda;
        this.produtos = produtos;
    }

    private Venda(String mtdPag, double valorVenda,  ArrayList<Produto>produtos) {
        this.cpfCliente = "Genérico";
        this.mtdPag = mtdPag;
        this.valorVenda = valorVenda;
        this.produtos = produtos;
    }

    public static Venda createVenda(String cpfCliente, String mtdPag, double valorVenda, ArrayList<Produto>produtos){
        Venda venda = null;
        try {
            if(cpfCliente.length() != 11){
                throw new VendaInvalidaException("CPF do Cliente não foi encontrado, favor verificar o campo CPF!");
            }
            if(mtdPag.isBlank() || mtdPag.isEmpty() || mtdPag.length() <3){
                throw new VendaInvalidaException("Método de pagamento inválido, verificar!");
            }
            if(valorVenda <= 0){
                throw new VendaInvalidaException("Valor de venda inválido, verificar!");
            }
            if(produtos.isEmpty()){
                throw new VendaInvalidaException("Não há produtos dentro do carrinho!");
            }

            for (Produto prod : produtos){
                prod.setQuantidade(prod.getQuantidade()-1);
            }

            venda = new Venda(cpfCliente, mtdPag, valorVenda,produtos);
        } catch (VendaInvalidaException e) {
            System.out.printf("Erro: " + e.getMessage());
        }
        return venda;
    }

    public static Venda createVendaGenerica(String mtdPag, double valorVenda, ArrayList<Produto>produtos){
        Venda venda = null;
        try {
            if(mtdPag.isBlank() || mtdPag.isEmpty() || mtdPag.length() <3){
                throw new VendaInvalidaException("Método de pagamento inválido, verificar!");
            }
            if(valorVenda <= 0){
                throw new VendaInvalidaException("Valor de venda inválido, verificar!");
            }
            if(produtos.isEmpty()){
                throw new VendaInvalidaException("Não há produtos dentro do carrinho!");
            }

            for (Produto prod : produtos){
                prod.setQuantidade(prod.getQuantidade()-1);
            }

            venda = new Venda(mtdPag, valorVenda,produtos);
        } catch (VendaInvalidaException e) {
            System.out.printf("Erro: " + e.getMessage());
        }
        return venda;
    }

    public void addProduto(Produto produto){
        if(this.produtos == null){
            this.produtos = new ArrayList<>();
        }
        this.produtos.add(produto);
    }

    public static Venda createVendaResgatada (Cliente cliente, String cpfCliente, double valorVenda, ArrayList<Produto> produtos){
        Venda venda = null;
        int quantidadeTotalPontos = 0;
        try {
            if(cpfCliente.length() != 11){
                throw new VendaInvalidaException("CPF do Cliente não foi encontrado, favor verificar o campo CPF!");
            }
            if(valorVenda <= 0){
                throw new VendaInvalidaException("Valor de venda inválido, verificar!");
            }
            if(cliente == null){
                throw new VendaInvalidaException("Cliente não encontrado, verifique e tente novamenet!");
            }
            if(produtos.isEmpty()){
                throw new VendaInvalidaException("Não há produtos dentro do carrinho!");
            }

            for (Produto prod : produtos){
                if (prod.getPreco() < 10.0){
                    quantidadeTotalPontos++;
                } else{
                    quantidadeTotalPontos += prod.getPrecoPontos();
                }
            }
            for (Produto prod : produtos){
                prod.setQuantidade(prod.getQuantidade()-1);
            }

            if (cliente.getPontos() < quantidadeTotalPontos){
                throw new VendaInvalidaException("Cliente sem saldo de pontos suficiente!");
            }

            venda = new Venda(cpfCliente, "Pontos", quantidadeTotalPontos, produtos);
            cliente.setPontos(cliente.getPontos() - quantidadeTotalPontos);
        } catch (VendaInvalidaException e) {
            System.out.printf("Erro: " + e.getMessage());
        }
        return venda;
    }


    public double getValorVenda() {
        return valorVenda;
    }

    public String getMtdPag() {
        return mtdPag;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }



    public int calculaPontos(double valorCompra){
        int pontos = (int)valorCompra/10;

        return pontos;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    public String toString() {
        return "Venda{" +
                "cpfCliente='" + cpfCliente + '\'' +
                ", mtdPag='" + mtdPag + '\'' +
                ", valorVenda=" + valorVenda +
                ", produtos=" + produtos +
                '}';
    }

}
