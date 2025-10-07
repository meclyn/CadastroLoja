package matheus.dev.CadastroLoja.Cliente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import matheus.dev.CadastroLoja.Produto.ProdutoModel;


@Entity
@Table(name = "tb_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "produtos")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "Sexo")
    private String sexo;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;



    @JoinColumn(name = "pedido_id")
    @ManyToOne
    private ProdutoModel produtos;


}
