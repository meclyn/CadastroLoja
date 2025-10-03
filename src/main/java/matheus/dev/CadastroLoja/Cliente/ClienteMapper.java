package matheus.dev.CadastroLoja.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteModel map(ClienteDTO clienteDTO) {
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setIdade(clienteDTO.getIdade());
        clienteModel.setEmail(clienteDTO.getEmail());
        clienteModel.setCpf(clienteDTO.getCpf());
        clienteModel.setSexo(clienteDTO.getSexo());
        clienteModel.setTelefone(clienteDTO.getTelefone());
        clienteModel.setEndereco(clienteDTO.getEndereco());
        clienteModel.setProdutos(clienteDTO.getProdutos());
        return clienteModel;
    }

    public ClienteDTO map(ClienteModel clienteModel) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setIdade(clienteModel.getIdade());
        clienteDTO.setEmail(clienteModel.getEmail());
        clienteDTO.setCpf(clienteModel.getCpf());
        clienteDTO.setSexo(clienteModel.getSexo());
        clienteDTO.setTelefone(clienteModel.getTelefone());
        clienteDTO.setEndereco(clienteModel.getEndereco());
        clienteDTO.setProdutos(clienteModel.getProdutos());
        return clienteDTO;
    }


}
