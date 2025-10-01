package matheus.dev.CadastroLoja.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "boas vindas ao /cliente";
    }

    //Adicionar Cliente
    @PostMapping("/criar")
    public String criarCliente(){
        return "Cliente criado com sucesso!";
    }
    
    //Procurar Cliente por ID
    @GetMapping("/listar/{id}")
    public ClienteModel listarClientePorId(@PathVariable Long id){
        return clienteService.listarClientesPorId(id);
    }

    //Mostrar todos os Clientes
    @GetMapping("/listar")
    public List<ClienteModel> listarClientes() {
        return clienteService.listarClientes();
    }

    //Alterar dados do Cliente
    @PutMapping("/alterar")
    public String alterarCliente(){
        return "Cliente alterado com sucesso!";
    }

    //Deletar Cliente
    @PostMapping("/deletar")
    public String deletarCliente(){
        return "Cliente deletado com sucesso!";
    }
}
