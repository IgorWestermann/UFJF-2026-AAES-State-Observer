package org.example;

public class PedidoCancelado implements PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado. Não é possível avançar");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("O pedido já foi cancelado");
    }

    @Override
    public String nome() {
        return "Cancelado";
    }
}
