package poo;

import java.util.List;
import java.util.Map;

public class PedidoDTO {
    private int mesa;
    private Map<Long, Integer> itens;

    public PedidoDTO() {

    }

    public PedidoDTO(int mesa, Map<Long, Integer> itens) {
        this.mesa = mesa;
        this.itens = itens;
    }

    public int getMesa() {
        return mesa;
    }

    public Map<Long, Integer> getItens() {
        return itens;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public void setItens(Map<Long, Integer> itens) {
        this.itens = itens;
    }
}
