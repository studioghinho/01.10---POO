package br.com.starlog.exception;

/** Exceção verificada lançada quando um módulo atinge sua capacidade máxima. */
public class CapacidadeExcedidaException extends Exception {
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}
