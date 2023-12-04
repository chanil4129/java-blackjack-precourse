package domain.controller;

import domain.card.Cards;
import domain.service.BlackjackService;
import domain.service.DealerService;
import domain.service.PlayerService;
import domain.user.Dealer;
import domain.user.Player;
import domain.view.output.OutputView;
import java.util.List;
import java.util.Map;

public class BlackjackController {
    private final BlackjackService blackjackService;
    private final DealerService dealerService;
    private final PlayerService playerService;
    private final OutputView outputView;

    public BlackjackController(BlackjackService blackjackService, DealerService dealerService,
                               PlayerService playerService, OutputView outputView) {
        this.blackjackService = blackjackService;
        this.dealerService = dealerService;
        this.playerService = playerService;
        this.outputView = outputView;
    }

    public void run() {
        Cards cards = blackjackService.initGameStart();

        List<String> playerNames = null;
        List<Double> bettingPrices = null;

        Dealer dealer = dealerService.create(cards);
        List<Player> players = playerService.creates(cards, playerNames, bettingPrices);

        outputView.printDealCard(dealer, players);

        while (playerService.validateDraw(players)) {
            List<Player> canReceivePlayers = playerService.findCanDraw(players);
            List<Player> receiveMorePlayer = null; // TODO: 2023-12-04 validateDraw 결과만 input
            playerService.receiveMoreCard(cards, receiveMorePlayer);
        }


    }
}
