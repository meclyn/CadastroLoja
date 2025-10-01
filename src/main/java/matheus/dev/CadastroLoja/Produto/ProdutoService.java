package matheus.dev.CadastroLoja.Produto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoModel> listarProdutos(){
        return produtoRepository.findAll();
    }
}
