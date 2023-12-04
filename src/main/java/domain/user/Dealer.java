package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final String TO_STRING_SEPARATOR = ", ";
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

    public String getCards() {
        return cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(TO_STRING_SEPARATOR));
    }
}
