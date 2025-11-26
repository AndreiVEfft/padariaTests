package entity;

import exceptions.ProdutoInvalidoException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto {

    private int id;
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

    private Produto(int id, String nome, double preco,int quantidade,String tipo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Produto() {}

    public static Produto createProduto(int id, String nome, double preco,int quantidade, String tipo){
        Produto produto = null;
        ArrayList<String> carac= new ArrayList<>();
        carac.add("Salgado");
        carac.add("Doce");
        carac.add("Bebida");
        int cont = 0;

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
            for(String prodTipo : carac){
                if(!tipo.equals(prodTipo)){
                    cont++;
                }
            }
            if(cont == carac.size()){
                throw new ProdutoInvalidoException("Tipo digitado é inválido, favor validar!");
            }
            produto = new Produto(id,nome,preco,quantidade,tipo);
        } catch (ProdutoInvalidoException e) {
            System.out.printf("Erro: " + e.getMessage());
        }

        return produto;
    }

    public int getId() {
        return id;
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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecoPontos() {
        return (int) (this.getPreco() / 10.0);
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
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
