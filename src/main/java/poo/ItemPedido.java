package poo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class ItemPedido {
    private Item item;
    private int quantidade;

    public ItemPedido(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantiade) {
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