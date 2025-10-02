package matheus.dev.CadastroLoja.Cliente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // listar os clientes
    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAll();
    }

    // listar por id
    public ClienteModel listarClientesPorId(Long id) {
        Optional<ClienteModel> clientePorId = clienteRepository.findById(id);
        return clientePorId.orElse(null);
    }

    //criar um novo cliente
    public ClienteModel criarCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    //deletar o cliente
    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    //atualizar o cliente
    public ClienteModel atualizarCliente(Long id, ClienteModel clienteAtualizado){
        if(clienteRepository.existsById(id)){
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null;
    }


}
