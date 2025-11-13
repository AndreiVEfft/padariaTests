package entity;

import java.time.LocalDate;

public class Venda {
    
    private int id;
    private String cpf;
    private String formaPag;
    private double valor;

    public Venda(int id, String cpf, String formaPag, LocalDate data) {
        this.id = id;
        this.cpf = cpf;
        this.formaPag = formaPag;
    }
    
    public Venda( LocalDate data){
        this.id = id;
    }

    public Venda(String cpf, double valor, String formaPag) {
        this.cpf = cpf;
        this.valor = valor;
        this.formaPag = formaPag;
      
    }

    public boolean validarNome(String nome) {
        return nome.matches("[a-zA-ZÀ-ÿ\\s]{6,}");
    }
 

    public void atualizarEstoque(int qtd){
        
    }
    
    public void acumulaPontos(Cliente cliente, int pontos){
        cliente.setTotPontosAcumulados(pontos);
    }

     public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getFormaPag() {
        return formaPag;
    }

    public double getValor() {
        return valor;
    }

    public void registrarVenda(LocalDate horarioResgate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
