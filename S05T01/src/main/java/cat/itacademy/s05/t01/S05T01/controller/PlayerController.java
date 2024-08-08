package cat.itacademy.s05.t01.S05T01.controller;

import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import cat.itacademy.s05.t01.S05T01.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    public Mono<BlackJack.Player> getPlayerById(@PathVariable String id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/name/{name}")
    public Flux<BlackJack.Player> getPlayersByName(@PathVariable String name) {
        return playerService.getPlayersByName(name);
    }

    @PostMapping
    public Mono<BlackJack.Player> savePlayer(@RequestBody BlackJack.Player player) {
        return playerService.savePlayer(player);
    }

    @PostMapping
    public Mono<BlackJack.Player> createPlayer(@RequestBody BlackJack.Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping
    public Flux<BlackJack.Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{id}")
    public Mono<BlackJack.Player> updatePlayer(@PathVariable String id, @RequestBody BlackJack.Player player) {
        return playerService.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePlayer(@PathVariable String id) {
        return playerService.deletePlayer(id);
    }
}


