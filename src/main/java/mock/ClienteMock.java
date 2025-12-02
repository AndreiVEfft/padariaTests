package mock;

import entity.Cliente;
import interfaces.ClienteDaoInterface;

import java.util.ArrayList;
import java.util.List;

public class ClienteMock implements ClienteDaoInterface {
    private List<Cliente> clientes;
    public ClienteMock(){
        this.clientes = new ArrayList<>();
    }

    @Override
    public void salvar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public List<Cliente> consultar() {
        return clientes;
    }

    @Override
    public boolean delete(String cpf) {
        for(Cliente umCli : clientes){
            if (umCli.getCpf().equals(cpf)){
                clientes.remove(umCli);
                return true;
            }
        }
        return false;
    }

    @Override
    public Cliente update(Cliente cli, String cpf) {
        Cliente cliente = null;
        if(cli == null){
            return cliente;
        }
        for(Cliente umCli : clientes){
            if (umCli.getCpf().equals(cpf)){
                clientes.remove(umCli);
                salvar(cli);
                cliente = cli;
                return cliente;
            }
        }
        return cliente;
    }

    @Override
    public Cliente consultarPeloCpf(String cpf) {
        for(Cliente umCli : clientes){
            if (umCli.getCpf().equals(cpf)){
                return umCli;
            }
        }
        return null;
    }
}
