package domain.referee;

import domain.user.Dealer;
import domain.user.Player;

public class Referee {
    private Dealer dealer;
    private Player player;

    public Referee(Dealer dealer, Player player) {
        this.dealer = dealer;
        this.player = player;
    }

    public void updateDealer(Dealer updateDealer) {
        dealer = updateDealer;
    }

    public void updatePlayer(Player updatePlayer) {
        player = updatePlayer;
    }

    /**
     * 플레이어의 처음 두장이 21인지
     */
    public boolean isPlayer21AtFirstTime() {
        return player.calculateTotal() == 21;
    }

    public boolean isPlayerOver21() {
        return player.isOver21();
    }

    public boolean isWin() {
        return player.calculateTotal() > dealer.calculateTotal();
    }

    public boolean isTie() {
        return player.calculateTotal() == dealer.calculateTotal();
    }

    public boolean isLose() {
        return player.calculateTotal() < dealer.calculateTotal();
    }
}
