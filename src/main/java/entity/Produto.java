package entity;

import exceptions.ProdutoInvalidoException;

import java.util.ArrayList;

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
        Produto produto = null;
        ArrayList<String> carac= new ArrayList<>();
        carac.add("!");
        carac.add("?");

        try {
            if(nome.isBlank() ){
                throw new ProdutoInvalidoException("Há campos obrigatórios não preenchidos!");
            }
            if(preco <= 0){
                throw new ProdutoInvalidoException("Valor digitado é inválido, favor validar!");
            }
            if(quantidade < 0){
                throw new ProdutoInvalidoException("Quantidade digitada é inválida, favor validar!");
            }
            if( !tipo.equalsIgnoreCase("Pão") && !tipo.equalsIgnoreCase("Bolo") && !tipo.equalsIgnoreCase("Bebida")){
                throw new ProdutoInvalidoException("Tipo digitado é inválido, favor validar!");
            }
            produto = new Produto(nome,preco,quantidade,tipo);
        } catch (ProdutoInvalidoException e) {
            System.out.printf("Erro: " + e.getMessage());
        }

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
