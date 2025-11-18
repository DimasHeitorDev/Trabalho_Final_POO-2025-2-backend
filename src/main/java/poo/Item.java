package poo;

public class Item {
    private String name;
    private String descricao;
    private double preco;
    private ItemCategoria categoria;

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
}
