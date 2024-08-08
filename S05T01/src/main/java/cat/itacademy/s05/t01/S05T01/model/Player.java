package cat.itacademy.s05.t01.S05T01.model;

import cat.itacademy.s05.t01.S05T01.Game.Card;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Player {
    @Id
    private Long id;
    private String playerName;
    private List<cat.itacademy.s05.t01.S05T01.Game.Card> playerCards;
    private List<Card> dealerCards;
}

