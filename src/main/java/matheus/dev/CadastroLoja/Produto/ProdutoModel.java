package matheus.dev.CadastroLoja.Produto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import matheus.dev.CadastroLoja.Cliente.ClienteModel;

import java.util.List;

@Entity
@Table(name = "tab_produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private double preco;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "marca")
    private String marca;

    @Column(name = "img_url")
    private String imgUrl;

    @OneToMany(mappedBy = "produtos")
    @JsonIgnore
    private List<ClienteModel> cliente;
}
