package matheus.dev.CadastroLoja.Cliente;

import org.springframework.stereotype.Service;

import java.util.List;

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

}
