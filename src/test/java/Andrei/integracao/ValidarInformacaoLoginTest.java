package integracao;

import daos.ClienteDAO;
import entity.Cliente;
import entity.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidarInformacaoLoginTest {
    @Test
    public void logarUsuarioValidoNoSistema(){

        //Arrange
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.consultarPeloCpf("11122233344");
        Login login = new Login(cliente);
        login.createSenha();

        //Act
        login.validarLogin();

        //Assert
        Assertions.assertTrue(login.validarLogin());
    }
    @Test
    public void logarUsuarioComInformacoesInvalidasNoSistema(){

        //Arrange
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.consultarPeloCpf("11122233344");
        Login login = new Login(cliente);
        login.createSenha();

        //Act
        login.validarLogin();

        //Assert
        Assertions.assertNotEquals(login.getSenha(), "MAT141");
    }
}
