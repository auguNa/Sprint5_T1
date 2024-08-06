package cat.itacademy.s05.t01.S05T01.controller;

import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import cat.itacademy.s05.t01.S05T01.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PutMapping("/{playerId}")
    public ResponseEntity<BlackJack.Player> changePlayerName(@PathVariable Long playerId, @RequestBody String newName) {
        BlackJack.Player updatedPlayer = playerService.changePlayerName(playerId, newName);
        return ResponseEntity.ok(updatedPlayer);
    }

    // Other endpoints
}

