package matheus.dev.CadastroLoja.Produto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produto/ui")
public class ProdutoControllerUi {

    private final ProdutoService produtoService;

    public ProdutoControllerUi(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }



    //Listar todos os Produtos
    @GetMapping("/listar")
    public String listarProdutos(Model model){
        List<ProdutoDTO> produto = produtoService.listarProdutos();
        model.addAttribute("produtos", produto);
        return "listarProdutos";
    }
}
