package cat.itacademy.s05.t01.S05T01.service;

import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import cat.itacademy.s05.t01.S05T01.repository.BlackJackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BlackJackService {

    private final BlackJackRepository blackJackRepository;

    @Autowired
    public BlackJackService(BlackJackRepository blackJackRepository) {
        this.blackJackRepository = blackJackRepository;
    }

    public Mono<BlackJack> createGame(String playerName) {
        BlackJack game = new BlackJack();
        game.setPlayerName(playerName);
        // Initialize game with necessary details
        return Mono.just(game)
                .flatMap(blackJackRepository::save);
    }

    public Mono<BlackJack> getGameDetails(Long id) {
        return blackJackRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Game not found")));
    }
}
