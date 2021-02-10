package energybills.controller;

import java.util.Scanner;

import energybills.domain.model.Customer;
import energybills.domain.model.EnergyConsume;
import energybills.domain.model.House;

import java.util.List;


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
        Customer c1 = h1.getConsumerByLogin(login);

        List<EnergyConsume> allConsumes = h1.getEnergyConsumeList();

        // initialize variable totalAmount that will hold totalAmount of consumed energy
        int totalAmount = 0;

        // loop through allConsumes


        if(c1 != null) {
            System.out.println("The customer found!");

            for (int i = 0; i < allConsumes.size(); i++) {

                // get current ec

                EnergyConsume ecCur = allConsumes.get(i);

                // returns boolean: ==, !=, <, >, <=, >=, &&, ||

                // or, methods, that returns booleans

            /*
            String a = "roma";
            String b = "neroma";

            if(checkString(a)) {

            }


            if(a.equals(b)) {
                System.out.println("The variables is equal");
            }
            */


                // get its customer

                // compare with found customer (c1)

                //

                totalAmount = (totalAmount + 10);

                if (c1.getLogin().equals(ecCur.getConsumer().getLogin())) {
                    // 0
                    // ta = 0 + 10
                    // ta == 10
                    // ta = 10 + 30
                    // ta == 40

                    // if match, add "amount" of ec to totalAmount
                    totalAmount = totalAmount + ecCur.getAmount();
                }
            }

            System.out.println("The overall consume by this user is: " + totalAmount);
        }
        // please, add "else" with message that customer wasnt found
        else {

        }

    }

    public void test1() {
        System.out.println("I have created such method test1!!");
    }

    public void bill() {

        // class vs object ??
        // i. e., "Roma" vs "human"

        House  h2 =  House.getInstance();

        // to take all "energy consumes" (i. e., electricity, consumed by each customer)
        List<EnergyConsume> ec = h2.getEnergyConsumeList();

        System.out.println("To bill for all bills (" + ec.size() + ")");
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




}
