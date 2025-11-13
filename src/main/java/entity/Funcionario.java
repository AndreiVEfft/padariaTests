package entity;

/**
 *
 * @author arthu
 */
public class Funcionario extends Pessoa {
    
    private String codLogin;
    private String funcao;

    public Funcionario(int id , String nome,String codLogin, String funcao) {
        super(id,nome);
        this.codLogin = codLogin;
        this.funcao = funcao;
    }
    
    public Funcionario(){
        
    }
    
     @Override
    public Pessoa edit(int id) {
        Pessoa funcionario = new Funcionario();
        return funcionario;
    }
    
    public String getCodLogin() {
        return codLogin;
    }

    public String getFuncao() {
        return funcao;
    }   
}
