package matheus.dev.CadastroLoja.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClienteController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "boas vindas ao /cliente";
    }

    //Adicionar Cliente
    @PostMapping("/criarCliente")
    public String criarCliente(){
        return "Cliente criado com sucesso!";
    }
    
    //Procurar Cliente por ID
    @GetMapping("/listarID")
    public String listarID(){
        return "Cliente encontrado com sucesso!";
    }

    //Mostrar todos os Clientes
    @GetMapping("/listarTodos")
    public String listarTodos() {
        return "Lista de Clientes!";
    }

    //Alterar dados do Cliente
    @PutMapping("/alterarCliente")
    public String alterarCliente(){
        return "Cliente alterado com sucesso!";
    }

    //Deletar Cliente
    @PostMapping("/deletarCliente")
    public String deletarCliente(){
        return "Cliente deletado com sucesso!";
    }
}
