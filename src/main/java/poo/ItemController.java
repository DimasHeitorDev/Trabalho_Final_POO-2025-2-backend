package poo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemRepository repository;
    private final poo.services.ImagemService imagemService;

    public ItemController(ItemRepository repository, poo.services.ImagemService imagemService) {
        this.repository = repository;
        this.imagemService = imagemService;
    }

    @GetMapping
    public List<Item> listar() {
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

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") org.springframework.web.multipart.MultipartFile file)
            throws java.io.IOException {
        return imagemService.upload(file);
    }

}
