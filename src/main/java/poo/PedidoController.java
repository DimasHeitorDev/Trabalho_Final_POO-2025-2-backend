package poo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemRepository itemRepository;

    public PedidoController() {

    }

    @PostMapping
    public Pedido criarPedido(@RequestBody PedidoDTO dto) {
        Pedido pedido = new Pedido(dto.getMesa());

        for (Map.Entry<Long, Integer> entry : dto.getItens().entrySet()) {
            Item item = itemRepository.findById(entry.getKey()).orElseThrow(() -> new RuntimeException("Item não encontrado: " + entry.getKey()));
            pedido.adicionarItem(item, entry.getValue());
        }

        return pedidoRepository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @DeleteMapping
    public void deletarPedido() {

    }
}
