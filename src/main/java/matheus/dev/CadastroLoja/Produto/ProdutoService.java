package matheus.dev.CadastroLoja.Produto;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //listar produtos
    public List<ProdutoModel> listarProdutos(){
        return produtoRepository.findAll();
    }

    //listar produto por id
    public ProdutoModel listarProdutoPorId(Long id){
        Optional<ProdutoModel> produtoPorId = produtoRepository.findById(id);
        return produtoPorId.orElse(null);
    }

    //criar produto
    public ProdutoModel criarProduto(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    //deletar produto
    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    //atualizar produto
    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoAtualizado){
        if(produtoRepository.existsById(id)){
            produtoAtualizado.setId(id);
            produtoRepository.save(produtoAtualizado);
        }
        return null;


    }
}
