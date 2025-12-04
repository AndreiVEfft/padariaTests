package Andrei.integracao;

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
        dao.deleteAll();
        Cliente cliente01 = Cliente.createUser("Mateus", "11122233344", "54999999999", 10);
        Cliente cliente02 = Cliente.createUser("Andrei", "44433322211", "47999999999", 10);
        Cliente cliente03 = Cliente.createUser("Arthur", "12312312312", "47999999999", 10);
        Cliente cliente04 = Cliente.createUser("Kaike", "32132132132", "47999999999", 10);

        dao.salvar(cliente01);
        dao.salvar(cliente02);
        dao.salvar(cliente03);
        dao.salvar(cliente04);

        //Act
        List<Cliente> clientes = dao.consultar();
        //Assert
        Assertions.assertNotNull(clientes);
    }
    @Test
    public void consultarUsuarioUnicoTest(){
        //Arrange
        ClienteDao dao = new ClienteDao();
        dao.deleteAll();

        Cliente cliente01 = Cliente.createUser("Mateus", "11122233344", "54999999999", 10);
        Cliente cliente02 = Cliente.createUser("Andrei", "44433322211", "47999999999", 10);
        Cliente cliente03 = Cliente.createUser("Arthur", "12312312312", "47999999999", 10);
        Cliente cliente04 = Cliente.createUser("Kaike", "32132132132", "47999999999", 10);

        dao.salvar(cliente01);
        dao.salvar(cliente02);
        dao.salvar(cliente03);
        dao.salvar(cliente04);
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
        dao.deleteAll();

        Cliente cliente02 = Cliente.createUser("Andrei", "44433322211", "47999999999", 10);
        Cliente cliente03 = Cliente.createUser("Arthur", "12312312312", "47999999999", 10);
        Cliente cliente04 = Cliente.createUser("Kaike", "32132132132", "47999999999", 10);

        dao.salvar(cliente02);
        dao.salvar(cliente03);
        dao.salvar(cliente04);
        //Act
        Cliente cliente = dao.consultarPeloCpf("1112233344");
        //Assert
        Assertions.assertNull(cliente);
    }
}
