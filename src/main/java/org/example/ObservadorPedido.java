package org.example;

public interface ObservadorPedido {
    void atualizar(Pedido pedido, String estadoAnterior, String novoEstado);
}
