package matheus.dev.CadastroLoja.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Mensagem de boas vindas", description = "Endpoint para retornar uma mensagem de boas vindas ao acessar /cliente")
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "boas vindas ao /cliente";
    }

    //Adicionar Cliente
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Requisição inválida")
    })

    @Operation(summary = "Cria um novo cliente", description = "Rota cria novo cliente e insere no banco de dados")
    @PostMapping("/criar")
    public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO cliente){

        ClienteDTO clienteDTO = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cliente criado com sucesso: " + clienteDTO.getNome() + " (ID): " + clienteDTO.getId());
    }
    
    //Procurar Cliente por ID
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })

    @Operation(summary = "Lista um cliente por ID", description = "Rota lista cliente pelo seu ID")
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
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Requisição inválida")
    })

    @Operation(summary = "Atualiza um cliente por ID", description = "Rota atualiza um cliente pelo seu ID")
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarCliente(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados atualizados no corpo da requisicao")
            @RequestBody ClienteDTO clienteAtualizado){

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
    @DeleteMapping("/deletar/{id}")
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
