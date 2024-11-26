package dev.malfatti.API.entities.dtos;

public class AtualizarValorProdutoDTO {

    private Long id;
    private float valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
