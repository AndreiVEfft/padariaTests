package Kaike.integracao;

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
        Cliente cliente = clienteDAO.consultarPeloCpf("11122233344");
        Login login = new Login(cliente);

        //Act
        login.validarLogin("11122233344","MAT111");

        //Assert
        Assertions.assertTrue(login.validarLogin("11122233344","MAT111"));
    }
    @Test
    public void logarUsuarioComInformacoesInvalidasNoSistema(){

        //Arrange
        ClienteDao clienteDAO = new ClienteDao();
        Cliente cliente = clienteDAO.consultarPeloCpf("11122233344");
        Login login = new Login(cliente);

        //Act
        login.validarLogin("11122233344","MAT141");

        //Assert
        Assertions.assertFalse(login.validarLogin("11122233344","MAT141"));
    }
}
