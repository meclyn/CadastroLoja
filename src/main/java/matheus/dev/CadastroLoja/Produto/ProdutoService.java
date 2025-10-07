package matheus.dev.CadastroLoja.Produto;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    //listar produtos
    public List<ProdutoDTO> listarProdutos(){
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produtoMapper::map)
                .collect(Collectors.toList());

    }

    //listar produto por id
    public ProdutoDTO listarProdutoPorId(Long id){
        Optional<ProdutoModel> produtoPorId = produtoRepository.findById(id);
        return produtoPorId.map(produtoMapper::map).orElse(null);
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
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO){
        Optional<ProdutoModel> produtoExistente = produtoRepository.findById(id);
        if(produtoExistente.isPresent()) {
            ProdutoModel produtoAtualizado = produtoMapper.map(produtoDTO);
            produtoAtualizado.setId(id);
            ProdutoModel produtoSalvo = produtoRepository.save(produtoAtualizado);
            return produtoMapper.map(produtoSalvo);
        }
        return null;



    }
}
