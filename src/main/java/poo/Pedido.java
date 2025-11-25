package poo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Pedido {
    ArrayList<ItemPedido> itens;
    double precoTotal;
    LocalDate data;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Pedido() {
        this.data = LocalDate.now();
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item, int quantidade) {
        itens.add(new ItemPedido(item, quantidade));
    }

    public ArrayList<ItemPedido> getItens() {
        return this.itens;
    }

    public double getPrecoTotal() {
        return this.precoTotal;
    }

    public LocalDate getData() {
        return this.data;
    }

    public Long getId() {
        return id;
    }
}
