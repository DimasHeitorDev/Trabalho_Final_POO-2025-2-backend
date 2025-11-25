package poo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemPedido {

    @ManyToOne(optional = false)
    private Item item;
    private int quantidade;

    public ItemPedido() {

    }

    public ItemPedido(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void add(int quantidade) {
        if (getQuantidade() + quantidade >= 0) {
            setQuantidade(getQuantidade() + quantidade);
        }
    }

    public Item getItem() {
        return this.item;
    }
}