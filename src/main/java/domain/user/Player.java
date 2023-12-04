package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateTotal() {
        return cards.stream()
                .mapToInt(card -> card.getSymbol().getScore())
                .sum();
    }

    public boolean isOver21() {
        return calculateTotal() > 21;
    }

    /**
     * 처음 블랙잭인 경우
     */
    public int calculateOnlyPlayerBlackJackAtFirst() {
        return (int) (bettingMoney * 2.5);
    }

    public int calculatePlayerWin() {
        return (int) bettingMoney * 2;
    }

    public int calculateTie() {
        return (int) bettingMoney;
    }

    public int calculateLose() {
        return 0;
    }

    public int calculateRevenue(int resultMoney) {
        return resultMoney - (int) bettingMoney;
    }
}
