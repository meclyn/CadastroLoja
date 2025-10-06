package matheus.dev.CadastroLoja.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import matheus.dev.CadastroLoja.Cliente.ClienteModel;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private String categoria;
    private String marca;
    private String imgUrl;
    private List<ClienteModel> cliente;
}
