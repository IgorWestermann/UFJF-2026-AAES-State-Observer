package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class EstadosPedidoTest {
    @Test
    void pedidoRecebidoAvancaParaEmPreparo() {
        Pedido pedido = novoPedidoEm("Recebido");
        
        pedido.avancar();

        assertEquals("Em preparo", pedido.getNomeEstado());
    }

    @Test
    void pedidoEmPreparoAvancaParaPronto() {
        Pedido pedido = novoPedidoEm("Em preparo");

        pedido.avancar();

        assertEquals("Pronto", pedido.getNomeEstado());
    }

    @Test
    void pedidoProntoAvancaParaEntregue() {
        Pedido pedido = novoPedidoEm("Pronto");

        pedido.avancar();

        assertEquals("Entregue", pedido.getNomeEstado());
    }

    @Test
    void pedidoEntregueNaoPodeAvancar() {
        Pedido pedido = novoPedidoEm("Entregue");

        assertThrows(IllegalStateException.class, pedido::avancar);
    }

    @Test
    void pedidoCanceladoNaoPodeAvancar() {
        Pedido pedido = new Pedido(1);

        pedido.cancelar();

        assertThrows(IllegalStateException.class, pedido::avancar);
    }

    @Test
    void pedidoPodeSerCanceladoDurantePreparo() {
        Pedido pedido = novoPedidoEm("Em preparo");

        pedido.cancelar();

        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void pedidoProntoNaoPodeSerCancelado() {
        Pedido pedido = novoPedidoEm("Pronto");

        assertThrows(IllegalStateException.class, pedido::cancelar);
    }

    private Pedido novoPedidoEm(String estadoDesejado) {
        Pedido pedido = new Pedido(1);

        while (!pedido.getNomeEstado().equals(estadoDesejado)) {
            pedido.avancar();
        }
        
        return pedido;
    }
}
