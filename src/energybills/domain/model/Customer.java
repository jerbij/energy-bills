package energybills.domain.model;

public class Customer { // клас споживач
    private String login;

    private String name;

    int amount; // кількість спожитого

    Customer customer; //споживач метод

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
