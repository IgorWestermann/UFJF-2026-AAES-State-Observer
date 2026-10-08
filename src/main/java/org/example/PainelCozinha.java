package org.example;

public class PainelCozinha implements ObservadorPedido {
    private String ultimaMensagem;

    @Override
    public void atualizar(Pedido pedido, String estadoAnterior, String novoEstado) {
        ultimaMensagem = "Cozinha: pedido " + pedido.getNumero() + " mudou de "
                + estadoAnterior + " para " + novoEstado + ".";
        System.out.println(ultimaMensagem);
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}
