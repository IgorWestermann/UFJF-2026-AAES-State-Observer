package org.example;

public class Cliente implements ObservadorPedido {
    private String ultimaMensagem;

    @Override
    public void atualizar(Pedido pedido, String estadoAnterior, String novoEstado) {
        ultimaMensagem = "Cliente: pedido " + pedido.getNumero() + " agora está " + novoEstado + ".";
        System.out.println(ultimaMensagem);
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}
