package domain.service;

import domain.card.Cards;
import domain.user.Player;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    public List<Player> creates(Cards cards, List<String> playerNames, List<Double> bettingPrices) {
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < playerNames.size(); i++) {
            String name = playerNames.get(i);
            double bettingPrice = bettingPrices.get(i);

            Player player = createPlayer(cards, name, bettingPrice);
            players.add(player);
        }

        return players;
    }

    private Player createPlayer(Cards cards, String name, double bettingPrice) {
        Player player = new Player(name, bettingPrice);

        player.addCard(cards.draw());
        player.addCard(cards.draw());

        return player;
    }

    public void receiveMoreCard(Cards cards, List<Player> drawPlayers) {
        for (Player player : drawPlayers) {
            player.addCard(cards.draw());
        }
    }

    public boolean validateDraw(List<Player> players) {
        for (Player player : players) {
            if (player.isBelow21()) {
                return true;
            }
        }
        return false;
    }

    public List<Player> findCanDraw(List<Player> players) {
        List<Player> canDrawPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.isBelow21()) {
                canDrawPlayers.add(player);
            }
        }
        return canDrawPlayers;
    }
}
