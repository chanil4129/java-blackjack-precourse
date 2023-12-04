package domain.money;

import java.util.List;

public class DealerRevenue {
    private final int SIGN_CONVERTER = -1;
    private final List<PlayerAsset> playerAssets;

    public DealerRevenue(List<PlayerAsset> playerAssets) {
        this.playerAssets = playerAssets;
    }

    public int calculateRevenue() {
        int playersRevenue = playerAssets.stream()
                .mapToInt(player -> player.calculateRevenue())
                .sum();
        return SIGN_CONVERTER * playersRevenue;
    }
}
