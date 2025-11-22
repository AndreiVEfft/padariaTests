package entity;

import exceptions.ProdutoInvalidoException;

public class Produto {

    private String nome;
    private double preco;
    private int quantidade;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    private Produto(String nome, double preco,int quantidade,String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Produto() {}

    public static Produto createProduto(String nome, double preco,int quantidade, String tipo){
        if(nome.isBlank() ){
            throw new ProdutoInvalidoException("Há campos obrigatórios não preenchidos!");
        }
        if(preco <= 0){
            throw new ProdutoInvalidoException("Valor digitado é inválido, favor validar!");
        }
        Produto produto = new Produto(nome,preco,quantidade,tipo);

        return produto;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", tipo:" + tipo +
                '}';
    }
}
