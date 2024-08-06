package cat.itacademy.s05.t01.S05T01.repository;

import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<BlackJack.Player, Long> {
    Optional<BlackJack.Player> findById(Long id);
    BlackJack.Player save(BlackJack.Player player);
}