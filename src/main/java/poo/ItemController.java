package poo;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemRepository repository;
    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Item> listar(){
        return repository.findAll();
    }
    @PostMapping
    public Item add(@RequestBody Item item) {
        return repository.save(item);
    }
    @GetMapping("/{id}")
    public Item buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
