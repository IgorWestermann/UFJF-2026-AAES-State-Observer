package org.example;

public class PedidoEntregue implements PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        throw new IllegalStateException("O pedido já foi entregue");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Não é possível cancelar o pedido");
    }

    @Override
    public String nome() {
        return "Entregue";
    }
}
