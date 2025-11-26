package unitarios;

import daos.ProdutoDAO;
import daos.ProdutoDAO;
import entity.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static entity.Produto.createProduto;

public class AlterarProdutoTest {

    @Test
    public void deveAlterarDadosProduto(){
        //Arrange
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = dao.consultarPeloId(16);
        Produto novoProduto = createProduto(16,"Pão crocante", 5.99,10,"Pão");

        //Act
        dao.update(novoProduto);
        Produto produtoAtualizado = dao.consultarPeloId(produto.getId());


        //Assert
        Assertions.assertEquals(produtoAtualizado.getNome(), novoProduto.getNome());
        System.out.println("Informações do produto alteradas com sucesso");
    }

    @Test
     public void deveAlterarNomeProduto(){
        //Arrange
        ProdutoDAO dao = new ProdutoDAO();

        Produto produto = dao.consultarPeloId(16);
        Produto novoProduto = createProduto(16,"Pão Delicioso", 5.99,10,"Pão");

        //Act
        dao.update(novoProduto);
        Produto produtoAtualizado = dao.consultarPeloId(produto.getId());
        //Assert

        Assertions.assertEquals(produtoAtualizado.getNome(), novoProduto.getNome());
        System.out.println("O nome do produto foi alterado com sucesso");
    }
    @Test
    public void deveAlterarPrecoProduto(){
        //Arrange
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = dao.consultarPeloId(16);
        Produto novoProduto = createProduto(16,"Pão Americano", 9.99,10,"Pão");

        //Act
        dao.update(novoProduto);
        Produto produtoAtualizado = dao.consultarPeloId(produto.getId());
        //Assert

        Assertions.assertEquals(produtoAtualizado.getPreco(), novoProduto.getPreco());
        System.out.println("O valor do produto foi alterado com sucesso");
    }
    @Test
    public void deveAlterarQuantidadeProduto(){
        //Arrange
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = dao.consultarPeloId(16);
        Produto novoProduto = createProduto(16,"Pão Americano", 5.99,15,"Pão");

        //Act
        dao.update(novoProduto);
        Produto produtoAtualizado = dao.consultarPeloId(produto.getId());

        //Assert
        Assertions.assertEquals(produtoAtualizado.getQuantidade(), novoProduto.getQuantidade());
        System.out.println("A quantidade do produto foi alterado com sucesso");
    }
}
