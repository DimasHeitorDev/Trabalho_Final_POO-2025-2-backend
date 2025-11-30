package poo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface VendasDiaRepository extends JpaRepository<VendasDia, Long> {
    Optional<VendasDia> findByData(LocalDate data);
}
