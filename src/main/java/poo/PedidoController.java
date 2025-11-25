package poo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping estMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping
    public Pedido criarPedido(@RequestBody PedidoDTO dto) {

        List<Item> itens = itemRepository.findAllById(dto.itens);

        Pedido pedido = new Pedido(dto.cliente, itens);

        return pedidoRepository.save(pedido);
    }
}
