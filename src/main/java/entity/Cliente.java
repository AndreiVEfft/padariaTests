package entity;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
    private String cpf;
    private String telefone;
    private int totPontosAcumulados;

 
    public Cliente(int id, String nome, String cpf, String telefone, int totPontosAcumulados ) {
        super(id, nome);
        this.cpf = cpf;
        this.telefone = telefone;
        this.totPontosAcumulados = totPontosAcumulados;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", telefone=" + telefone + ", totPontosAcumulados=" + totPontosAcumulados + '}';
    }

    public Cliente() {
        
    }
    
    public boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
}
    public boolean validarNome(String nome) {
    return nome.matches("[a-zA-ZÀ-ÿ\\s]{6,}");
}
    public boolean validarTelefone(String telefone) {
    return telefone.matches("\\d{11}");
}

     @Override
    public Pessoa edit(int id) {
       Pessoa pessoa = new Cliente();
       return pessoa;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTotPontosAcumulados(int totPontosAcumulados) {
        this.totPontosAcumulados = totPontosAcumulados;
    }
    
    
    public String getTelefone() {
        return telefone;
    }

    public int getTotPontosAcumulados() {
        return totPontosAcumulados;
    }
}
