package matheus.dev.CadastroLoja.Cliente;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente/ui")
public class ClienteControllerUi {

    private final ClienteService clienteService;

    public ClienteControllerUi(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    //Mostrar todos os Clientes
    @GetMapping("/listar")
    public String listarClientes(Model model) {
        List<ClienteDTO> clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "listarClientes";
    }

    //Deletar Cliente
    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return "redirect:/cliente/ui/listar";
    }

    //Procurar Cliente por ID
    @GetMapping("/listar/{id}")
    public String listarClientePorId(@PathVariable Long id, Model model){

        ClienteDTO clientes = clienteService.listarClientesPorId(id);
        if(clientes != null) {
            model.addAttribute("cliente", clientes);
            return "detalhescliente";
        }else {
            model.addAttribute("error", "Cliente com o ID " + id + " não encontrado");
            return "redirect:/cliente/ui/listar";
        }
    }

    //Adicionar Cliente
    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarCliente(Model model){
        model.addAttribute("cliente", new ClienteDTO());

        return "adicionarCliente";
    }

    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute("cliente") ClienteDTO cliente, Model model){

        ClienteDTO clienteDTO = clienteService.criarCliente(cliente);
        model.addAttribute("mensagem", "Cliente criado com sucesso: " + clienteDTO.getNome() + " (ID): " + clienteDTO.getId());
        return "redirect:/cliente/ui/listar";
    }


    // Exibe o formulário de alteração
    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterarCliente(@PathVariable Long id, Model model) {
        ClienteDTO cliente = clienteService.listarClientesPorId(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "alterarCliente";
        } else {
            model.addAttribute("error", "Cliente não encontrado");
            return "redirect:/cliente/ui/listar";
        }
    }

    // Recebe os dados alterados
    @PostMapping("/alterar/{id}")
    public String alterarCliente(@PathVariable Long id, @ModelAttribute("cliente") ClienteDTO clienteAtualizado, Model model) {
        ClienteDTO cliente = clienteService.atualizarCliente(id, clienteAtualizado);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "detalhescliente";
        } else {
            model.addAttribute("error", "O cliente com o ID " + id + " não foi encontrado");
            return "redirect:/cliente/ui/listar";
        }
    }

}
