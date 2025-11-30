package poo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private VendasDiaRepository vendasDiaRepository;

    public PedidoController() {

    }

    @PostMapping
    public Pedido criarPedido(@RequestBody PedidoDTO dto) {
        Pedido pedido = new Pedido(dto.getMesa());

        for (Map.Entry<Long, Integer> entry : dto.getItens().entrySet()) {
            Item item = itemRepository.findById(entry.getKey())
                    .orElseThrow(() -> new RuntimeException("Item não encontrado: " + entry.getKey()));
            pedido.adicionarItem(item, entry.getValue());
        }

        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        messagingTemplate.convertAndSend("/topic/novos-pedidos", pedido);

        return pedidoSalvo;
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
        messagingTemplate.convertAndSend("/topic/pedidos-removidos", id);
    }

    @PatchMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id, @RequestParam StatusPedido status) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(status);

        if (status == StatusPedido.CONCLUIDO) {
            java.time.LocalDate hoje = java.time.LocalDate.now();
            VendasDia vendasDia = vendasDiaRepository.findByData(hoje)
                    .orElse(new VendasDia(hoje, 0.0));
            vendasDia.adicionarVenda(pedido.getPrecoTotal());
            vendasDiaRepository.save(vendasDia);
        }

        return pedidoRepository.save(pedido);
    }
}
