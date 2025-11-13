package entity;

import jakarta.persistence.*;
import java.util.ArrayList;

/**
 *
 * @author arthu
 */
@Entity
public abstract class  Pessoa {
    
    private int id;
    
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
     }
     public Pessoa() {
       
    }
    public abstract Pessoa edit(int id);
    
    public  void remove(int id){
        
    }
    
   
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  
}
