package poo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "pedido_itens")
    private List<ItemPedido> itens = new ArrayList<>();

    double precoTotal;
    LocalDate data;
    private int mesa;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.data = LocalDate.now();
    }

    public Pedido(int mesa) {
        this.data = LocalDate.now();
        this.itens = new ArrayList<>();
        this.mesa = mesa;
    }

    public void adicionarItem(Item item, int quantidade) {
        itens.add(new ItemPedido(item, quantidade));
    }

    public List<ItemPedido> getItens() {
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

    public int getMesa() {
        return mesa;
    }
}
