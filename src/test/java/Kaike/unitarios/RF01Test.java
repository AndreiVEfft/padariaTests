/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kaike.unitarios;

import entity.Cliente;
import mock.ClienteMock;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author user
 */
public class RF01Test {
    
    @Test
    public void deveDeletarUsuario(){
        
        //arrange
        Cliente cliente = Cliente.createUser("Kaike", "11831869918", "47992042889", 0);
    
        ClienteMock dao = new ClienteMock();
        dao.salvar(cliente);
        
        //act
        dao.delete("11831869918");
        
        //assert
        Assert.assertNull(dao.consultarPeloCpf("11831869918"));
    }
    
    @Test
    public void deveValidarDeletarUsuarioInvalido(){
        //arrange
        Cliente cliente = Cliente.createUser("Kaike", "11831869918", "47992042889", 0);
    
        ClienteMock dao = new ClienteMock();
        dao.salvar(cliente);
        
        //assert e act
        Assert.assertFalse(dao.delete("11431859912"));
    }
}
