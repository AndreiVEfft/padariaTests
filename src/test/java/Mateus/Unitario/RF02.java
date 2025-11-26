package Mateus.Unitario;

import entity.Cliente;
import entity.Login;
import org.junit.Assert;
import org.junit.Test;

public class RF02 {

    @Test
    public void deveLogar(){
        //Arrange
        Cliente cliente01;
        Login loginCliente01;

        //Act
        cliente01 = Cliente.createUser("Mateus Rissardi", "12345678910","54999999999", 0);
        loginCliente01 = new Login(cliente01);

        //Assert
        Assert.assertTrue(loginCliente01.validarLogin("12345678910","MAT123"));
    }

    @Test
    public void validarCPFInvalido(){
        //Arrange
        Cliente cliente01;
        Login loginCliente01;

        //Act
        cliente01 = Cliente.createUser("Mateus Rissardi", "12345678910","54999999999", 0);
        loginCliente01 = new Login(cliente01);

        //Assert
        Assert.assertFalse(loginCliente01.validarLogin("11122233344","MAT123"));
    }

    @Test
    public void validarSenhaInvalida(){
        //Arrange
        Cliente cliente01;
        Login loginCliente01;

        //Act
        cliente01 = Cliente.createUser("Mateus Rissardi", "12345678910","54999999999", 0);
        loginCliente01 = new Login(cliente01);

        //Assert
        Assert.assertFalse(loginCliente01.validarLogin("12345678910","MAT111"));
    }

    @Test
    public void validarCamposInvalidos(){
        //Arrange
        Cliente cliente01;
        Login loginCliente01;

        //Act
        cliente01 = Cliente.createUser("Mateus Rissardi", "12345678910","54999999999", 0);
        loginCliente01 = new Login(cliente01);

        //Assert
        Assert.assertFalse(loginCliente01.validarLogin("",""));
    }
}
