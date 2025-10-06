package matheus.dev.CadastroLoja.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import matheus.dev.CadastroLoja.Produto.ProdutoModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String cpf;
    private String sexo;
    private String telefone;
    private String endereco;
    private ProdutoModel produtos;
}
