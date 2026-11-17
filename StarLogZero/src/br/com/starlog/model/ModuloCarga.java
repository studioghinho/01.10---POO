package br.com.starlog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.starlog.exception.CapacidadeExcedidaException;

/** Representa um contêiner físico que armazena cargas. */
public class ModuloCarga {
    private String idModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas;

    public ModuloCarga(String idModulo, int capacidadeMaxima) {
        this.idModulo = idModulo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.cargas = new ArrayList<>();
    }

    public String getIdModulo() {
        return idModulo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void carregarCarga(Carga carga) throws CapacidadeExcedidaException {
        if (this.cargas.size() >= this.capacidadeMaxima) {
            throw new CapacidadeExcedidaException(
                    "Capacidade maxima de " + this.capacidadeMaxima
                    + " atingida no modulo " + this.idModulo);
        }

        this.cargas.add(carga);
    }

    public double calcularSeguroTotal() {
        return this.cargas.stream()
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }

    public long contarPorCategoria(String categoria) {
        return this.cargas.stream()
                .filter(carga -> Objects.equals(carga.getCategoria(), categoria))
                .count();
    }

    public double calcularSeguroPesadas(double pesoCorte) {
        return this.cargas.stream()
                .filter(carga -> carga.getPesoKg() > pesoCorte)
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }
}
