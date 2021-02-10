package energybills.domain.model;

public class Bill {   // рахунок
    private int moneyAmount; //сумма

    private EnergyConsume consume;  // спожито

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public EnergyConsume getConsume() {
        return consume;
    }

    public void setConsume(EnergyConsume consume) {
        this.consume = consume;
    }
}
