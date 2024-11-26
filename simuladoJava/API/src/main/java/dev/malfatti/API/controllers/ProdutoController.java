package dev.malfatti.API.controllers;

import dev.malfatti.API.entities.Produto;
import dev.malfatti.API.services.ProdutoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> listarProdutos() {
        try {
            List<Produto> produtos = produtoService.listarProdutos();
            return ResponseEntity.ok(produtos);
        }
        catch (Exception e) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }

    }

    @PostMapping("/add")
    public ResponseEntity<?> adicionarProduto(@RequestBody Produto produto) {
        try{
            Produto produtoAdicionado = produtoService.adicionarProduto(produto);
            return ResponseEntity.ok(produtoAdicionado);
        }
        catch (Exception e) {
            return new ResponseEntity("Erro ao criar um produto", HttpStatusCode.valueOf(504));
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarProdutoPorId(@PathVariable Long id) {
        try{
            Optional<Produto> produto = produtoService.buscarProdutoPorId(id);
            return ResponseEntity.ok(produto);
        }
        catch (Exception e) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id) {
        try {
            produtoService.excluirProduto(id);
            return ResponseEntity.ok("Produto removido com sucesso");
        }
        catch (Exception e){
            return new ResponseEntity<>("Erro ao remover um produto", HttpStatusCode.valueOf(504));
        }
    }


}
