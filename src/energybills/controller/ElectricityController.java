package energybills.controller;

import java.util.NoSuchElementException;
import java.util.Scanner;

import energybills.domain.model.*;

import java.util.List;
import java.util.Set;


// Hren dlja command
public class ElectricityController {

    public void pay() {
        System.out.println("To pay");
    }
    public void consume() {
        System.out.println("Enter login:"); //consume

        Scanner in = new Scanner(System.in);
        String login = in.nextLine();

        // we should get consumer by login

        // 1. ) Get storage
        House h1 = House.getInstance();

        // 2. ) Get one particular user from storage
        Customer foundCustomer = h1.getConsumerByLogin(login);

        List<EnergyConsume> allConsumes = h1.getEnergyConsumeList();

        // initialize variable totaglAmount that will hold totalAmount of consumed energy
        int totalAmount = calculateConsumedEnergyByCustomer(foundCustomer, allConsumes);

        System.out.println("The overall consume by this user is: " + totalAmount);
    }

    private int calculateConsumedEnergyByCustomer(Customer foundCustomer, List<EnergyConsume> allConsumes) {
        int totalAmount = 0;

        // loop through allConsumes
        if(foundCustomer != null) {
            System.out.println("The customer found!");

            for (int i = 0; i < allConsumes.size(); i++) {

                EnergyConsume ecCur = allConsumes.get(i);

                if (foundCustomer.getLogin().equals(ecCur.getConsumer().getLogin())) {
                    // if match, add "amount" of ec to totalAmount
                    totalAmount = totalAmount + ecCur.getAmount();
                }
            }
        }
        // please, add "else" with message that customer wasnt found
        else {

        }

        return totalAmount;
    }

    public void assignMonthFare() {
        Scanner in = new Scanner(System.in);

        System.out.println("What month it is?");
        int month = in.nextInt();

        System.out.println("Price?");
        int price = in.nextInt();

        Fare f = new Fare(price, month);
        House h1 = House.getInstance();

        h1.addFare(f);

        System.out.println(String.format("The amount of fares for now is: %s", h1.getFareList().size()));
    }

    public void test1() {
        System.out.println("I have created such method test1!!");
    }

    public void bill() {

        System.out.println("Enter login:"); //consume

        Scanner in = new Scanner(System.in);
        String login = in.nextLine();

        // we should get consumer by login

        // 1. ) Get storage
        House h1 = House.getInstance();

        // 2. ) Get one particular user from storage
        Customer foundCustomer = h1.getConsumerByLogin(login);

        List<EnergyConsume> allConsumes = h1.getEnergyConsumeList();

        // initialize variable totalAmount that will hold totalAmount of consumed energy
        int totalAmount = calculateConsumedEnergyByCustomer(foundCustomer, allConsumes);

        System.out.println("The overall consume by this user is: " + totalAmount);

        Set<Fare> fares = h1.getFareList();

        Fare foundFare;

        try {
            foundFare = getLastElement(fares);

        } catch(Throwable e) {
            System.out.println("The fares was not set yet");
            return;
        }

        int cost = totalAmount * foundFare.getPrice();
        System.out.println("The cost is " + cost);
    }

    public void invoice() {
        System.out.println("To get invoice");
    }

    public void happynewyear() {
        System.out.println("Happy New Year!!!");
    }

    public void consumersinfo() {
        House h3 = House.getInstance();
        System.out.println("Overall amount of consumers in our house is: " + h3.getConsumerList().size());
    }

    private boolean checkString(String a) {
        return false;
    }


    public static <T> T getLastElement(final Iterable<T> elements) throws NoSuchElementException {
        T lastElement = null;

        for (T element : elements) {
            lastElement = element;
        }

        if(lastElement == null) {
            throw new NoSuchElementException("The collection is empty");
        }
        return lastElement;
    }

}
