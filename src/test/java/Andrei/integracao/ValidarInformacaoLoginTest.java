package Andrei.integracao;

import daos.ClienteDao;
import entity.Cliente;
import entity.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidarInformacaoLoginTest {
    @Test
    public void logarUsuarioValidoNoSistema(){

        //Arrange
        ClienteDao clienteDAO = new ClienteDao();
        clienteDAO.deleteAll();

        Cliente cliente = Cliente.createUser("Mateus", "11122233344", "54999999999", 10);
        clienteDAO.salvar(cliente);
        Login login = new Login(cliente);

        //Act
        login.validarLogin(clienteDAO.consultarPeloCpf("11122233344").getCpf(), "MAT111");

        //Assert
        Assertions.assertTrue(login.validarLogin(cliente.getCpf(), "MAT111"));
    }
    @Test
    public void logarUsuarioComInformacoesInvalidasNoSistema(){

        //Arrange
        ClienteDao clienteDAO = new ClienteDao();
        clienteDAO.deleteAll();
        Cliente cliente = Cliente.createUser("Mateus", "11122233344", "54999999999", 10);
        clienteDAO.salvar(cliente);
        Login login = new Login(cliente);

        //Act
        login.validarLogin("14122253344", "MAT141");

        //Assert
        Assertions.assertFalse(login.validarLogin("14122253344", "MAT141"));
    }
}
