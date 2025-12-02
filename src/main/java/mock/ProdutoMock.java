package mock;

import entity.Produto;
import interfaces.ProdutoDaoInterface;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMock implements ProdutoDaoInterface {
    private List<Produto> produtos;

    public ProdutoMock(){
        this.produtos = new ArrayList<>();
    }

    @Override
    public void salvar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public List<Produto> consultar() {
        return produtos;
    }

    @Override
    public boolean delete(String nome) {
        for(Produto umProd : produtos){
            if(umProd.getNome().equalsIgnoreCase(nome)){
                produtos.remove(umProd);
                return true;
            }
        }
        return false;
    }

    @Override
    public Produto update(String nome, Produto prod){
        Produto produto = null;
        if(prod == null){
            return produto;
        }
        for(Produto umProd : produtos){
            if(umProd.getNome().equalsIgnoreCase(nome)){
                produtos.remove(umProd);
                salvar(prod);
                produto = prod;
                return produto;
            }
        }
        return produto;
    }

    @Override
    public Produto consultarPeloNome(String nome) {
        for(Produto umProd : produtos){
            if(umProd.getNome().equalsIgnoreCase(nome)){
                return umProd;
            }
        }
        return null;
    }
}
