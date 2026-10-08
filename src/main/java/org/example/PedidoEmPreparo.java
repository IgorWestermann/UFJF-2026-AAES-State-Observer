package org.example;

public class PedidoEmPreparo implements PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        pedido.alterarEstado(new PedidoPronto());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.alterarEstado(new PedidoCancelado());
    }

    @Override
    public String nome() {
        return "Em preparo";
    }
}
