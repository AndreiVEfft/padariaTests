package Kaike.unitarios;

import entity.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static entity.Cliente.createUser;

public class ConsultarPontosTest {

    @Test
    public void deveMostrarQuantidadeDePontosClienteComPontos(){
        //Arrange
        Cliente cliente = createUser("Andrei Effting","14899966687","48996557788",10);

        //Act
        int pontos = cliente.getPontos();

        //Assert
        Assertions.assertEquals(10, pontos);

    }
    @Test
    public void deveRetornarQuantidadeDePontosClienteSemPontos(){
        //Arrange
        Cliente cliente = createUser("Andrei Effting","14899966687","48996557788",0);

        //Act
        int pontos = cliente.getPontos();

        //Assert
        Assertions.assertEquals(0, pontos);
    }
}
