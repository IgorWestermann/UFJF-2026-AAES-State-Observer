package org.example;

public class PedidoPronto implements PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        pedido.alterarEstado(new PedidoEntregue());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Não é possível cancelar o pedido");
    }

    @Override
    public String nome() {
        return "Pronto";
    }
}
