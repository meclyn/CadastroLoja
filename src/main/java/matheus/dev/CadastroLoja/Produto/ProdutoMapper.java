package matheus.dev.CadastroLoja.Produto;

import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public ProdutoModel map(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(produtoDTO.getId());
        produtoModel.setNome(produtoDTO.getNome());
        produtoModel.setDescricao(produtoDTO.getDescricao());
        produtoModel.setPreco(produtoDTO.getPreco());
        produtoModel.setQuantidade(produtoDTO.getQuantidade());
        produtoModel.setCategoria(produtoDTO.getCategoria());
        produtoModel.setMarca(produtoDTO.getMarca());
        produtoModel.setImgUrl(produtoDTO.getImgUrl());
        produtoModel.setCliente(produtoDTO.getCliente());
        return produtoModel;
    }

    public ProdutoDTO map(ProdutoModel produtoModel) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoModel.getId());
        produtoDTO.setNome(produtoModel.getNome());
        produtoDTO.setDescricao(produtoModel.getDescricao());
        produtoDTO.setPreco(produtoModel.getPreco());
        produtoDTO.setQuantidade(produtoModel.getQuantidade());
        produtoDTO.setCategoria(produtoModel.getCategoria());
        produtoDTO.setMarca(produtoModel.getMarca());
        produtoDTO.setImgUrl(produtoModel.getImgUrl());
        produtoDTO.setCliente(produtoModel.getCliente());
        return produtoDTO;
    }
}
