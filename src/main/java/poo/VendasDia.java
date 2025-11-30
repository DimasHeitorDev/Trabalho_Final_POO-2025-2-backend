package poo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VendasDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private LocalDate data;

    private double totalVendas;

    public VendasDia() {
    }

    public VendasDia(LocalDate data, double totalVendas) {
        this.data = data;
        this.totalVendas = totalVendas;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public void adicionarVenda(double valor) {
        this.totalVendas += valor;
    }
}
