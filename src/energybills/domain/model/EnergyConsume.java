package energybills.domain.model;

// class for energy consumed by some customer
public class EnergyConsume {   // спожито
    private int amount; // сумма

    private Customer customer; // споживач

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Customer getConsumer() {
        return customer;
    }

    public void setConsumer(Customer customer) {
        this.customer = customer;
    }
}
