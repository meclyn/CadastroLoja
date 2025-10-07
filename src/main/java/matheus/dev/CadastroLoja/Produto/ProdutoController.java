package matheus.dev.CadastroLoja.Produto;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Adicionar Produto
    @PostMapping("/criar")
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoDTO produto){
         ProdutoDTO produtoDTO = produtoService.criarProduto(produto);
         return ResponseEntity.status(HttpStatus.CREATED)
                 .body("Produto criado com sucesso" + produtoDTO.getNome() + "ID: " + produtoDTO.getId());
    }

    //Procurar Produto por ID
    @GetMapping("/listarID")
    public ResponseEntity<?> listarProdutoPorId(@PathVariable Long id){

        ProdutoDTO produto = produtoService.listarProdutoPorId(id);

        if(produto != null) {
            return ResponseEntity.ok(produto);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com o ID " + id + " não foi encontrado");
        }
    }

    //Listar todos os Produtos
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        List<ProdutoDTO> produto = produtoService.listarProdutos();
        return ResponseEntity.ok(produto);
    }

    //Alterar dados do Produto
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoAtualizado) {

        ProdutoDTO produto = produtoService.atualizarProduto(id, produtoAtualizado);

        if (produto != null) {
            return ResponseEntity
                    .ok(produto);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com o ID " + id + " não foi encontrado");
        }
    }

    //Deletar Produto
    @PostMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        if(produtoService.listarProdutoPorId(id) != null){
            produtoService.deletarProduto(id);
            return ResponseEntity.ok("Produto com o ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com o ID " + id + " não encontrado");
        }

    }
}
