package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
    private List<Card> cards;

    public void createAndShuffle() {
        cards = new ArrayList<>(CardFactory.create());
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

    public List<Card> getCards() {
        return cards;
    }
}
