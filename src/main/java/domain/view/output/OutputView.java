package domain.view.output;

import domain.revenue.Revenue;
import domain.user.Dealer;
import domain.user.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final String INPUT_PLAYERS_MESSAGE = "게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)";
    private final String INPUT_BETTING_AMOUNT_MESSAGE = "%s의 배팅 금액은?";
    private final String DEAL_CARDS_MESSAGE = "딜러와 %s에게 2장을 나누었습니다.";
    private final String DEALER_CARDS_MESSAGE = "딜러: %s";
    private final String PLAYER_CARDS_MESSAGE = "%s카드: %s";
    private final String MORE_CARD_PLAYER_MESSAGE = "%s는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private final String MORE_CARD_DEALER_MESSAGE = "딜러는 16이하라 한 장의 카드를 더 받았습니다.";
    private final String FINAL_DEALER_RESULT_MESSAGE = "딜러 카드: %s - 결과: %d";
    private final String FINAL_PLAYER_RESULT_MESSAGE = "%s카드: %s - 결과 %d";
    private final String FINAL_PROFIT_PREFIX_MESSAGE = "## 최종 수익";
    private final String FINAL_DEALER_PROFIT_MESSAGE = "딜러: %d";
    private final String FINAL_PLAYER_PROFIT_MESSAGE = "%s: %d";

    public void printPlayers() {
        System.out.println(INPUT_PLAYERS_MESSAGE);
    }

    public void printBattingPrice(Player player) {
        System.out.println(String.format(INPUT_BETTING_AMOUNT_MESSAGE, player.getName()));
    }

    public void printDealCard(Dealer dealer, List<Player> players) {
        String playersWithComma = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(", "));
        System.out.println(String.format(DEAL_CARDS_MESSAGE, playersWithComma));
        System.out.println(String.format(DEALER_CARDS_MESSAGE, dealer.getCards()));
        for (Player player : players) {
            System.out.println(String.format(PLAYER_CARDS_MESSAGE, player.getCards()));
        }
    }

    public void printMoreCard(Player player) {
        System.out.println(String.format(MORE_CARD_PLAYER_MESSAGE, player.getName()));
    }

    public void printMoreDealerCard() {
        System.out.println(MORE_CARD_DEALER_MESSAGE);
    }

    public void printFinalDealerResult(Dealer dealer) {
        System.out.println(String.format(FINAL_DEALER_RESULT_MESSAGE, dealer.getCards(), dealer.calculateTotal()));
    }

    public void printFinalPlayerResult(List<Player> players) {
        for (Player player : players) {
            System.out.println(String.format(FINAL_PLAYER_RESULT_MESSAGE, player.getName(), player.getCards(),
                    player.calculateTotal()));
        }
    }

    public void printFinalProfit(Revenue revenue, List<Player> players) {
        System.out.println(FINAL_PROFIT_PREFIX_MESSAGE);
        System.out.println(String.format(FINAL_DEALER_PROFIT_MESSAGE, revenue.calculateDealerRevenue()));
        for (Player player : players) {
            System.out.println(
                    String.format(FINAL_PLAYER_PROFIT_MESSAGE, player.getName(), revenue.getPlayerRevenue(player)));
        }
    }
}
