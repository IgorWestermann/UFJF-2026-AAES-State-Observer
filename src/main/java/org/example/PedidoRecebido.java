package org.example;

public class PedidoRecebido implements PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        pedido.alterarEstado(new PedidoEmPreparo());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.alterarEstado(new PedidoCancelado());
    }

    @Override
    public String nome() {
        return "Recebido";
    }
}
