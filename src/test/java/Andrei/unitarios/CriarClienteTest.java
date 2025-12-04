package Andrei.unitarios;

import entity.Cliente;
import entity.Login;
import exceptions.ClienteInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static entity.Cliente.createUser;


public class CriarClienteTest {

    @Test
    public void deveCriarUsuarioValido(){
        //Arrange
        String nome = "Andrei";
        String cpf = "14899912345";
        String telefone = "47999999999";
        int pontos = 0;

        //Act
        Cliente cliente = createUser(nome,cpf,telefone,pontos);

        //Assert
        Assertions.assertNotNull(cliente);
    }
    @Test
    public void deveFalharCriarUsuarioComNomeInvalido() throws ClienteInvalidoException {
        //Arrange
        String nome = "";
        String cpf = "14899912345";
        String telefone = "47999999999";
        int pontos = 0;

        // Act e Assert
        Assertions.assertNull(
            createUser(nome, cpf, telefone, pontos));
    }

    @Test
    public void deveFalharCriarUsuarioComCpfInvalido() throws ClienteInvalidoException {
        //Arrange
        int id = 1;
        String nome = "Andrei";
        String cpf = "14899912";
        String telefone = "47999999999";
        int pontos = 0;

        // Act e Assert
        Assertions.assertNull(
                createUser(nome, cpf, telefone, pontos));
    }

    @Test
    public void deveFalharCriarUsuarioComTelefoneInvalido() throws ClienteInvalidoException {
        //Arrange
        int id = 1;
        String nome = "Andrei";
        String cpf = "14899912345";
        String telefone = "47999";
        int pontos = 0;

        // Act e Assert
        Assertions.assertNull(
                createUser(nome, cpf, telefone, pontos));
    }

    @Test
    public void deveGerarSenhaCorreta() {
        //Arrange
        String nome = "Andrei";
        String cpf = "14875912345";
        String telefone = "47999999999";
        int pontos = 0;
        String senhaCorreta = "And148";

        Cliente cliente = createUser(nome,cpf,telefone,pontos);

        Login login = new Login(cliente);
        //Act
        login.createSenha();


        Assertions.assertEquals(login.getSenha(),senhaCorreta.toUpperCase());

    }

    @Test
    public void deveCriarUsuarioComZeroPontos() {
        //Arrange
        String nome = "Andrei";
        String cpf = "14875912345";
        String telefone = "47999999999";
        int pontos = 0;

        String senhaCorreta = "And148";

        //Act
        Cliente cliente = createUser(nome,cpf,telefone,pontos);

        //Assert
        Assertions.assertEquals(cliente.getPontos(), pontos, "O usuário foi criado com 0 pontos");

    }

}
