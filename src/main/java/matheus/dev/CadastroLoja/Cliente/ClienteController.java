package matheus.dev.CadastroLoja.Cliente;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO cliente){

        ClienteDTO clienteDTO = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cliente criado com sucesso: " + clienteDTO.getNome() + " (ID): " + clienteDTO.getId());
    }
    
    //Procurar Cliente por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarClientePorId(@PathVariable Long id){

        ClienteDTO clientes = clienteService.listarClientesPorId(id);
        if(clientes != null) {
            return ResponseEntity.ok(clientes);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com o ID " + id + " não encontrado");
        }
    }

    //Mostrar todos os Clientes
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    //Alterar dados do Cliente
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteAtualizado){

        ClienteDTO cliente = clienteService.atualizarCliente(id, clienteAtualizado);

        if (cliente != null) {
            return ResponseEntity
                    .ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O cliente com o ID " + id + " não foi encontrado");
        }
    }

    //Deletar Cliente
    @PostMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {

        if (clienteService.listarClientesPorId(id) != null) {
            clienteService.deletarCliente(id);
            return ResponseEntity.ok("Cliente com o ID " + id + " deletado com sucesso");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O cliente com o ID " + id + " não foi encontrado");
        }

    }
}
