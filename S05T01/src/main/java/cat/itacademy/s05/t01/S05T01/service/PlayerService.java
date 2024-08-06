package cat.itacademy.s05.t01.S05T01.service;


import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import cat.itacademy.s05.t01.S05T01.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public BlackJack.Player changePlayerName(Long playerId, String newName) {
        // Find the player by ID, or throw an exception if not found
        BlackJack.Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));

        // Update the player's name
        player.setName(newName);

        // Save the updated player and return it
        return playerRepository.save(player);
    }
}