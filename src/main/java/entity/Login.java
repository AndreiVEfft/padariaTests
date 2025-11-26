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

    public boolean validarLogin(String cpf,String senha) {
        if(!cliente.getCpf().isEmpty() && cpf.equalsIgnoreCase(cliente.getCpf())){
            if(senha.equalsIgnoreCase(this.senha)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public String getCpf() {
        return cpf;
    }

}
