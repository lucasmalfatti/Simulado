package dev.malfatti.API.services;

import dev.malfatti.API.entities.Produto;
import dev.malfatti.API.entities.dtos.AtualizarValorProdutoDTO;
import dev.malfatti.API.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }


    @Transactional
    public Produto adicionarProduto(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @Transactional
    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarValorProduto(AtualizarValorProdutoDTO valorProduto) {
        Optional<Produto> produto = produtoRepository.findById(valorProduto.getId());
        produto.get().setValor(valorProduto.getValor());
        produtoRepository.save(produto.get());
        return produto.get();
    }
}
