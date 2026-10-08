package org.example;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(42);

        pedido.adicionarObservador(new Cliente());
        pedido.adicionarObservador(new PainelCozinha());
        pedido.adicionarObservador(new Atendente());

        System.out.println("Estado inicial: " + pedido.getNomeEstado());
        pedido.avancar();
        pedido.avancar();
        pedido.avancar();
    }
}
