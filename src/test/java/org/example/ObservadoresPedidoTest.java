package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class ObservadoresPedidoTest {
    @Test
    void clienteRecebeOAtualEstadoDoPedido() {
        Pedido pedido = new Pedido(10);
        Cliente cliente = new Cliente();
        
        pedido.adicionarObservador(cliente);
        pedido.avancar();

        assertEquals("Cliente: pedido 10 agora está Em preparo.", cliente.getUltimaMensagem());
    }

    @Test
    void painelDaCozinhaRecebeATransicaoCompleta() {
        Pedido pedido = new Pedido(11);
        PainelCozinha painel = new PainelCozinha();

        pedido.adicionarObservador(painel);
        pedido.avancar();

        assertEquals("Cozinha: pedido 11 mudou de Recebido para Em preparo.", painel.getUltimaMensagem());
    }

    @Test
    void atendenteRecebeOAtualEstadoDoPedido() {
        Pedido pedido = new Pedido(12);
        Atendente atendente = new Atendente();

        pedido.adicionarObservador(atendente);
        pedido.avancar();

        assertEquals("Atendente: pedido 12 — Em preparo.", atendente.getUltimaMensagem());
    }

    @Test
    void multiplosObservadoresSaoNotificadosNaMesmaTransicao() {
        Pedido pedido = new Pedido(20);
        Cliente cliente = new Cliente();
        PainelCozinha painel = new PainelCozinha();
        Atendente atendente = new Atendente();
        
        pedido.adicionarObservador(cliente);
        pedido.adicionarObservador(painel);
        pedido.adicionarObservador(atendente);
        pedido.avancar();

        assertEquals("Cliente: pedido 20 agora está Em preparo.", cliente.getUltimaMensagem());
        assertEquals("Cozinha: pedido 20 mudou de Recebido para Em preparo.", painel.getUltimaMensagem());
        assertEquals("Atendente: pedido 20 — Em preparo.", atendente.getUltimaMensagem());
    }

    @Test
    void observadorRemovidoNaoRecebeNovasAtualizacoes() {
        Pedido pedido = new Pedido(21);
        Cliente cliente = new Cliente();

        pedido.adicionarObservador(cliente);
        pedido.removerObservador(cliente);
        pedido.avancar();

        assertNull(cliente.getUltimaMensagem());
    }

    @Test
    void observadoresAcompanhamAOrdemDasMudancasDeEstado() {
        Pedido pedido = new Pedido(22);
        PainelCozinha painel = new PainelCozinha();

        pedido.adicionarObservador(painel);
        pedido.avancar();
        pedido.avancar();

        assertEquals("Cozinha: pedido 22 mudou de Em preparo para Pronto.", painel.getUltimaMensagem());
    }
}
