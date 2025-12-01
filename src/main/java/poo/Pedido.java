package poo;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    LocalDateTime data;
    private int mesa;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.data = LocalDateTime.now();
        this.status = StatusPedido.PENDENTE;
    }

    public Pedido(int mesa) {
        this.data = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.mesa = mesa;
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarItem(Item item, int quantidade) {
        itens.add(new ItemPedido(item, quantidade));
        this.precoTotal += item.getPreco() * quantidade;
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }

    public double getPrecoTotal() {
        return this.precoTotal;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public Long getId() {
        return id;
    }

    public int getMesa() {
        return mesa;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
