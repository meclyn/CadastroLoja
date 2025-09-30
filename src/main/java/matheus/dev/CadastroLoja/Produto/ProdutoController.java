package matheus.dev.CadastroLoja.Produto;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProdutoController {

    //Adicionar Produto
    @PostMapping("/criarProduto")
    public String criarProduto(){
        return "Produto criado com sucesso!";
    }

    //Procurar Produto por ID
    @GetMapping("/listarPID")
    public String listarProdutoID(){
        return "Produto listado com sucesso!";
    }

    //Listar todos os Produtos
    @GetMapping("/listarTodosProdutos")
        public String listarProdutos(){
        return "Produtos listados com sucesso!";
    }

    //Alterar dados do Produto
    @PutMapping("/alterarProduto")
    public String alterarProduto() {
        return "Produto alterado com sucesso!";
    }

    //Deletar Produto
    @PostMapping("/deletarProduto")
    public String deletarProduto() {
        return "Produto deletado com sucesso!";
    }
}
