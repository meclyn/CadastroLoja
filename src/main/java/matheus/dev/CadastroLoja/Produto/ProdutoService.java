package matheus.dev.CadastroLoja.Produto;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;
    private ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
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
    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produto = produtoMapper.map(produtoDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.map(produto);
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
