package cat.itacademy.s05.t01.S05T01.repository;

import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackJackRepository extends ReactiveCrudRepository<BlackJack, Long> {
}
