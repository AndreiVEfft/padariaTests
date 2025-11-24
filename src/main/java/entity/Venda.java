package entity;

import exceptions.VendaInvalidaException;

import java.util.ArrayList;


public class Venda {

    private String cpfCliente;
    private String mtdPag;
    private double valorVenda;


    private ArrayList<Produto> produtos;

    public Venda() {}

    private Venda(String cpfCliente, String mtdPag, double valorVenda,  ArrayList<Produto>produtos) {
        this.cpfCliente = cpfCliente;
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

            venda = new Venda(cpfCliente, mtdPag, valorVenda,produtos);
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


    public double getValorVenda() {
        return valorVenda;
    }

    public String getMtdPag() {
        return mtdPag;
    }

    public String getCpfCliente() {
        return cpfCliente;
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
