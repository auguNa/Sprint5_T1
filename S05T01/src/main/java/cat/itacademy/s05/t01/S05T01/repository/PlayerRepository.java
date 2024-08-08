package cat.itacademy.s05.t01.S05T01.repository;

import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<BlackJack.Player, Long> {
    Flux<BlackJack.Player> findByName(String name);
}