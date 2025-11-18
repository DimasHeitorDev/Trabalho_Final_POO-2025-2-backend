package poo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;

@Entity
public class Item {
    private String name;
    private String descricao;
    private double preco;
    private ItemCategoria categoria;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Item(String name, String descricao, double preco, ItemCategoria categoria,Long id){
        this.name = name;
        this.descricao= descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public double getPreco(){
        return this.preco;
    }
    public ItemCategoria getItemCategoria(){
        return this.categoria;
    }
    public double getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public void setItemCategoria(ItemCategoria categoria){
        this.categoria = categoria;
    }
    public void setId(Long id){
        this.id = id;
    }
}
