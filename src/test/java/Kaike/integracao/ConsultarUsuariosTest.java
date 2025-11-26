package Kaike.integracao;

import daos.ClienteDao;
import entity.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ConsultarUsuariosTest {
    @Test
    public void consultarListaUsuariosTest(){
        //Arrange
        ClienteDao dao = new ClienteDao();
        //Act
        List<Cliente> clientes = dao.consultar();
        //Assert
        Assertions.assertNotNull(clientes);
    }
    @Test
    public void consultarUsuarioUnicoTest(){
        //Arrange
        ClienteDao dao = new ClienteDao();
        //Act
        Cliente cliente = dao.consultarPeloCpf("11122233344");
        //Assert
        Assertions.assertNotNull(cliente.getCpf());
        System.out.println(cliente.toString());
    }
    @Test
    public void consultarUsuarioUnicoComCpfInvalidoTest(){
        //Arrange
        ClienteDao dao = new ClienteDao();
        //Act
        Cliente cliente = dao.consultarPeloCpf("1112233344");
        //Assert
        Assertions.assertNull(cliente.getCpf());
        System.out.println(cliente.toString());
    }
}
