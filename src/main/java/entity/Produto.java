package entity;

import java.util.*;

public class Produto {
    
    private int id;
    private String nome;
    private double preco;
    private String tipo;
    private int valorPontoCat;
    private int quantidadeEstoque;
    private int qtdListadoProdutos;
    
    public Produto(int id, String nome, double preco, String tipo, int quantidadeEstoque){
        this.id = id; this.nome = nome; this.preco = preco; this.tipo = tipo; this.quantidadeEstoque = quantidadeEstoque;        
    }
    
    public Produto(String nome, int qtdListado, int valorPonto){
        this.nome = nome;
        this.qtdListadoProdutos = qtdListado;
        this.valorPontoCat = valorPonto;
    }
    public boolean validarNome(String nome) {
        return nome.matches("[a-zA-ZÀ-ÿ\\s]{6,}");
    }
    
     public Produto(){
        
    }
    
    public Produto editPrdouto(int id){
        Produto produto = new Produto();
        return produto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    public int getValorPonto(){
        return this.valorPontoCat;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    
    public int getQuantidadeProdutosCatalogo() {
        return this.qtdListadoProdutos;
    }
    
    public void adicionaCarrinho(){
        this.qtdListadoProdutos ++;
        
    }
    
      public String toString() {
        return " - " + this.nome;
    }
}
