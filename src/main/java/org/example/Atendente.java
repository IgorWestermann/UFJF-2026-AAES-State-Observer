package org.example;

public class Atendente implements ObservadorPedido {
    private String ultimaMensagem;

    @Override
    public void atualizar(Pedido pedido, String estadoAnterior, String novoEstado) {
        ultimaMensagem = "Atendente: pedido " + pedido.getNumero() + " — " + novoEstado + ".";
        System.out.println(ultimaMensagem);
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}
