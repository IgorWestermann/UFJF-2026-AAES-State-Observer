package org.example;

public interface PedidoEstado {
    void avancar(Pedido pedido);

    void cancelar(Pedido pedido);

    String nome();
}
