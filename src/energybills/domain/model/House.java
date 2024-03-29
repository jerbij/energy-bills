package energybills.domain.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class House { //будинок

    // properties of class
    private List<Customer> customerList;

    private List<EnergyConsume> energyConsumeList;

    private Set<Fare> fareList;

    private int number;

    private static House instance;

    // constructor
    // this method is used to initialize consumer list
    public House (){
        customerList =  new ArrayList();
        energyConsumeList = new ArrayList();
        fareList = new HashSet<>();
    }

    public List<EnergyConsume> getEnergyConsumeList() {
        return energyConsumeList;
    }
    public void addEnergyConsume(EnergyConsume energyConsumeList) {
        this.energyConsumeList.add(energyConsumeList);
    }


    public Set<Fare> getFareList() {
        return fareList;
    }
    public void addFare(Fare myValue) {
        this.fareList.add(myValue);
    }

    public static House getInstance() {
        // nothing has been set to the property "instance" yet
        if (instance == null) {
            instance = new House();
        }

        return instance;
    }

    // getters/setters
    public List<Customer> getConsumerList() {
        return customerList;
    }
    public Customer getConsumerByLogin(String login) {
        List<Customer> cns = getConsumerList();

        Customer c1 = null;

        for (int i = 0; i< cns.size(); i++){
            // get current consumer element from the list;

            // compare their "login" property with entered by user
            Customer curC = cns.get(i);

            if (curC.getLogin().equals(login)) {
                c1=curC;
                break;
            }
        }


        return c1;
    }

    // we will use this method to add one particular consumer to the house
    public void addConsumer(Customer c1) {
        customerList.add(c1);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // this method will be used to generate certain energy consume for some customer
    public EnergyConsume  generateRandomEnergyConsume(Customer customer, int month) {


        EnergyConsume energyConsume = new EnergyConsume();

        // who?
        energyConsume.setConsumer(customer);

        // how much?
        energyConsume.setAmount(generateRandomAmount());

        energyConsume.setMonthNumber(month);

        return energyConsume;
    }

    public void generateEnergyConsumes() throws InterruptedException {

        List<Customer> allCustomers = getConsumerList();

        int month = 1;

        while (true) {
            // enternal loop


            for (int i = 0; i < allCustomers.size(); i++) {

                // go through all consumer in the house

                // get a consumer with "i" index in list
                Customer currentCustomer = allCustomers.get(i);

                // generate energyConsume for them
                EnergyConsume generatedConsume = generateRandomEnergyConsume(currentCustomer,month);

                // add this energyConsume into our list, that lives in our house
                addEnergyConsume(generatedConsume);

                // System.out.println(String.format("Generated for the costumer #%d", i));
            }

            month = month + 1;
            Thread.sleep(15000);
        }

    }

    private int generateRandomAmount() {
        int min = 10;
        int max = 2000;
        int random = (int)(Math.random() * (max - min + 1) + min);

        return random;
    }
}
