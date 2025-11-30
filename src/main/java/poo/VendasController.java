package poo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    private final VendasDiaRepository repository;

    public VendasController(VendasDiaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hoje")
    public VendasDia getVendasHoje() {
        return repository.findByData(LocalDate.now())
                .orElse(new VendasDia(LocalDate.now(), 0.0));
    }
}
