package matheus.dev.CadastroLoja.Produto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Adicionar Produto
    @PostMapping("/criar")
    public ProdutoDTO criarProduto(@RequestBody ProdutoDTO produto){
        return produtoService.criarProduto(produto);
    }

    //Procurar Produto por ID
    @GetMapping("/listarID")
    public ProdutoModel listarProdutoPorId(@PathVariable Long id){
        return produtoService.listarProdutoPorId(id);
    }

    //Listar todos os Produtos
    @GetMapping("/listar")
        public List<ProdutoModel> listarProdutos(){
        return produtoService.listarProdutos();
    }

    //Alterar dados do Produto
    @PutMapping("/alterar/{id}")
    public ProdutoModel atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel produtoAtualizado) {
        return produtoService.atualizarProduto(id, produtoAtualizado);
    }

    //Deletar Produto
    @PostMapping("/deletar/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
