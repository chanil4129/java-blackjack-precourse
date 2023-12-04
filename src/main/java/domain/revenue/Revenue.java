package domain.revenue;

import domain.user.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Revenue {
    private final int SIGN_CONVERTER = -1;
    private final List<Player> players;
    private Map<Player, Integer> revenues = new HashMap<>();

    public Revenue(List<Player> players) {
        this.players = players;
        initRevenues();
    }

    private void initRevenues() {
        for (Player player : players) {
            revenues.put(player, 0);
        }
    }

    public int calculateDealerRevenue() {
        int playerRevenue = revenues.entrySet().stream()
                .mapToInt(revenue -> revenue.getValue())
                .sum();
        return SIGN_CONVERTER * playerRevenue;
    }

    public void addPlayerRevenue(Player player, int playerRevenue) {
        revenues.put(player, playerRevenue);
    }

    public int getPlayerRevenue(Player player) {
        return revenues.get(player);
    }
}
