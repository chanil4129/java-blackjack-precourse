package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getFirstCard() {
        return cards.get(0);
    }

    public int calculateTotal() {
        return cards.stream()
                .mapToInt(card -> card.getSymbol().getScore())
                .sum();
    }

    public boolean validateDraw() {
        return calculateTotal() <= 16;
    }

    public boolean nonValidateDraw() {
        return calculateTotal() > 16;
    }

    public boolean isOver21() {
        return calculateTotal() > 21;
    }
}
