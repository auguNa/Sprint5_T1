package cat.itacademy.s05.t01.S05T01.service;

import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import cat.itacademy.s05.t01.S05T01.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerService {


    @Autowired
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Mono<BlackJack.Player> getPlayerById(String id) {
        return playerRepository.findById(Long.valueOf(id));
    }

    public Flux<BlackJack.Player> getPlayersByName(String name) {
        return playerRepository.findByName(name);
    }

    public Mono<BlackJack.Player> savePlayer(BlackJack.Player player) {
        return playerRepository.save(player);
    }

    public Mono<BlackJack.Player> createPlayer(BlackJack.Player player) {
        return playerRepository.save(player);
    }

    public Flux<BlackJack.Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Mono<BlackJack.Player> updatePlayer(String id, BlackJack.Player player) {
        return playerRepository.findById(Long.valueOf(id))
                .flatMap(existingPlayer -> {
                    existingPlayer.setName(player.getName());
                    existingPlayer.setScore(player.getScore());
                    return playerRepository.save(existingPlayer);
                });
    }

    public Mono<Void> deletePlayer(String id) {
        return playerRepository.deleteById(Long.valueOf(id));
    }
}