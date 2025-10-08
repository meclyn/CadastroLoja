package matheus.dev.CadastroLoja.Produto;

import matheus.dev.CadastroLoja.Cliente.ClienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "produto/listarProdutos";
    }

    //Procurar Produto por ID
    @GetMapping("/listar/{id}")
    public String listarProdutoPorId(@PathVariable Long id, Model model){

        ProdutoDTO produto = produtoService.listarProdutoPorId(id);

        if(produto != null) {
            model.addAttribute("produto", produto);
            return "produto/detalhesProduto";

        }else{
            model.addAttribute("error", "Produto com o ID " + id + " não foi encontrado")   ;
            return "redirect:/produto/ui/listar";
        }
    }

    //Adicionar Produto
    @GetMapping("/criar")
    public String mostrarFormularioAdicionarProduto(Model model){
            model.addAttribute("produto", new ProdutoDTO());
            return "produto/adicionarProduto";
    }


    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute("produto") ProdutoDTO produto, Model model) {
        ProdutoDTO produtoDTO = produtoService.criarProduto(produto);
        model.addAttribute("message", "Produto criado com sucesso: " + produtoDTO.getNome() + " (ID: " + produtoDTO.getId() + ")");
        return "redirect:/produto/ui/listar";
    }

    //Alterar dados do Produto
    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterarProduto(@PathVariable Long id, Model model) {
        ProdutoDTO produto = produtoService.listarProdutoPorId(id);

        if (produto != null) {
            model.addAttribute("produto", produto);
            return "produto/alterarProduto";
        }else {
            model.addAttribute("error", "Produto com o ID " + id + " não foi encontrado");
            return "redirect:/produto/ui/listar";
        }
    }

    // Recebe os dados alterados
    @PostMapping("/alterar/{id}")
    public String alterarProduto(@PathVariable Long id, @ModelAttribute("produto") ProdutoDTO produtoAtualizado, Model model) {
        ProdutoDTO produto = produtoService.atualizarProduto(id, produtoAtualizado);
        if (produto != null) {
            model.addAttribute("produto", produto);
            return "produto/detalhesProduto";
        } else {
            model.addAttribute("error", "O produto com o ID " + id + " não foi encontrado");
            return "redirect:/produto/ui/listar";
        }
    }

    //Deletar Produto
    @DeleteMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return "redirect:/produto/ui/listar";
    }
}
