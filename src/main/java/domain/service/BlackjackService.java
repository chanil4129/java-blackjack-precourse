package domain.service;

import domain.card.Cards;
import domain.user.Player;
import java.util.List;

public class BlackjackService {
    public Cards initGameStart() {
        Cards cards = new Cards();
        cards.createAndShuffle();
        return cards;
    }
}
