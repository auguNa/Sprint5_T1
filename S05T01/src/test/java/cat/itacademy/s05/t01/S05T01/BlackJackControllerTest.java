package cat.itacademy.s05.t01.S05T01;

import cat.itacademy.s05.t01.S05T01.model.BlackJack;
import cat.itacademy.s05.t01.S05T01.controller.BlackJackController;
import cat.itacademy.s05.t01.S05T01.service.BlackJackService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(BlackJackController.class)
public class BlackJackControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private BlackJackService gameService;

    @Test
    public void testCreateGame() {
        String playerName = "John Doe";
        BlackJack game = new BlackJack(); // assuming default constructor and setters
        game.setId(1L);
        game.setPlayerName(playerName);

        Mockito.when(gameService.createGame(playerName)).thenReturn(Mono.just(game));

        webTestClient.post()
                .uri("/game/new")
                .bodyValue(playerName)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(BlackJack.class).isEqualTo(game);
    }
}