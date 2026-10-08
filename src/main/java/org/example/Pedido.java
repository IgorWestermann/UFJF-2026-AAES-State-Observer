package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private final int numero;
    private final List<ObservadorPedido> observadores = new ArrayList<>();
    private PedidoEstado estado = new PedidoRecebido();

    public Pedido(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeEstado() {
        return estado.nome();
    }

    public void avancar() {
        estado.avancar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void adicionarObservador(ObservadorPedido observador) {
        observadores.add(Objects.requireNonNull(observador));
    }

    public void removerObservador(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    void alterarEstado(PedidoEstado novoEstado) {
        String estadoAnterior = estado.nome();
        estado = Objects.requireNonNull(novoEstado);
        notificarObservadores(estadoAnterior, estado.nome());
    }

    private void notificarObservadores(String estadoAnterior, String novoEstado) {
        for (ObservadorPedido observador : List.copyOf(observadores)) {
            observador.atualizar(this, estadoAnterior, novoEstado);
        }
    }
}
