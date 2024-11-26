package dev.malfatti.API.services;

import dev.malfatti.API.entities.Pedido;
import dev.malfatti.API.entities.Produto;
import dev.malfatti.API.repositories.PedidoRepository;
import dev.malfatti.API.repositories.ProdutoRepository;

import java.util.List;

public class PedidoService {

    private PedidoRepository pedidoRepository;

    private ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido adicionarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
        return pedido;
    }

    //Put, atualiza o pedido por completo
    public Pedido atualizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }





}
