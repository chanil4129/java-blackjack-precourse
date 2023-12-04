package domain.service;

import domain.card.Card;
import domain.card.CardFactory;
import domain.card.Cards;
import domain.user.Dealer;
import java.util.List;

public class DealerService {
    public Dealer create(Cards cards) {
        Dealer dealer = new Dealer();

        dealer.addCard(cards.draw());
        dealer.addCard(cards.draw());

        return dealer;
    }

    public Dealer receiveMoreCard(Cards cards, Dealer dealer) {

    }
}
