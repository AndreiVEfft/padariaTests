package entity;

public class Login {

    private String cpf;
    private String senha;
    private Cliente cliente;

    public Login(Cliente cliente){
        this.cliente= cliente;
        this.senha = createSenha();
    }

    public String createSenha(){
        String senhaFinal = cliente.getNome().substring(0,3) + cliente.getCpf().substring(0,3);
        return senhaFinal;
    }
    public String getSenha() {
        return senha;
    }

    public boolean validarLogin(String senha) {
        if(!cliente.getCpf().isEmpty() && senha.equalsIgnoreCase(this.senha)){
            return true;
        }
        else{
            return false;
        }
    }

    public String getCpf() {
        return cpf;
    }

}
