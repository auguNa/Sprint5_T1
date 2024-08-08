package cat.itacademy.s05.t01.S05T01.controller;

import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import cat.itacademy.s05.t01.S05T01.service.BlackJackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/game")
public class BlackJackController {

    private final BlackJackService blackJackService;

    @Autowired
    public BlackJackController(BlackJackService blackJackService) {
        this.blackJackService = blackJackService;
    }

    @PostMapping("/new")
    public Mono<ResponseEntity<BlackJack>> createGame(@RequestBody String playerName) {
        return blackJackService.createGame(playerName)
                .map(game -> ResponseEntity.status(HttpStatus.CREATED).body(game));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BlackJack>> getGameDetails(@PathVariable Long id) {
        return blackJackService.getGameDetails(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
