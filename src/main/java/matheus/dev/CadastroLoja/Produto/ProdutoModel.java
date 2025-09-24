package matheus.dev.CadastroLoja.Produto;

import jakarta.persistence.*;
import matheus.dev.CadastroLoja.Cliente.ClienteModel;

import java.util.List;

@Entity
@Table(name = "tab_produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int quantidade;

    @OneToMany(mappedBy = "produtos")
    private List<ClienteModel> cliente;

    public ProdutoModel() {
    }

    public ProdutoModel(int quantidade, String nome) {
        this.quantidade = quantidade;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
