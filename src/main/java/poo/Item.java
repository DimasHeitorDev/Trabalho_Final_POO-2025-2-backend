package poo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Item {
    private String name;
    private String descricao;
    private double preco;
    @Enumerated(EnumType.STRING)
    private ItemCategoria categoria;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;

    public Item() {
    }

    public Item(String name, String descricao, double preco, ItemCategoria categoria, String imageUrl) {
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public ItemCategoria getCategoria() {
        return this.categoria;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCategoria(ItemCategoria categoria) {
        this.categoria = categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
