package poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    ArrayList<ItemPedido> itens;
    double precoTotal;
    LocalDate data;

    public Pedido() {
        this.data = LocalDate.now();
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item, int quantidade) {
        itens.add(new ItemPedido(item, quantidade));
    }

    private class ItemPedido {
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
}
