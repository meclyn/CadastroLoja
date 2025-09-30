package matheus.dev.CadastroLoja.Produto;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    //Adicionar Produto
    @PostMapping("/criar")
    public String criarProduto(){
        return "Produto criado com sucesso!";
    }

    //Procurar Produto por ID
    @GetMapping("/listarID")
    public String listarProdutoID(){
        return "Produto listado com sucesso!";
    }

    //Listar todos os Produtos
    @GetMapping("/listar")
        public String listarProdutos(){
        return "Produtos listados com sucesso!";
    }

    //Alterar dados do Produto
    @PutMapping("/alterar")
    public String alterarProduto() {
        return "Produto alterado com sucesso!";
    }

    //Deletar Produto
    @PostMapping("/deletar")
    public String deletarProduto() {
        return "Produto deletado com sucesso!";
    }
}
