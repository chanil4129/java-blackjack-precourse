package domain.money;

public class PlayerAsset {
    private int battingMoney;
    private int resultMoney = 0;

    public PlayerAsset(int battingMoney) {
        this.battingMoney = battingMoney;
    }

    /**
     * 처음 블랙잭인 경우
     */
    public void calculateOnlyPlayerBlackJackAtFirst() {
        resultMoney = (int) (battingMoney * 2.5);
    }

    public void calculatePlayerWin() {
        resultMoney = battingMoney * 2;
    }

    public void calculateTie() {
        resultMoney = battingMoney;
    }

    public void calculateLose() {
        resultMoney = 0;
    }

    public int calculateRevenue() {
        return resultMoney - battingMoney;
    }
}
