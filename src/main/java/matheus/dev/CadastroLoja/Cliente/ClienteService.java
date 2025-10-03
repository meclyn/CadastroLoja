package matheus.dev.CadastroLoja.Cliente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
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
    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        ClienteModel cliente = clienteMapper.map(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.map(cliente);
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
