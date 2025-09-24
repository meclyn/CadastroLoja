package matheus.dev.CadastroLoja.Cliente;


import jakarta.persistence.*;
import matheus.dev.CadastroLoja.Produto.ProdutoModel;

import java.util.List;

@Entity
@Table(name = "tb_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;

    @JoinColumn(name = "pedido_id")
    @ManyToOne
    private List<ProdutoModel> produtos;


}
