package energybills.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

// vachter
public class FrontController {

    public void run() throws Throwable {
        while(true) {              // вечный цикл, boolean, генерятся с помощью операторов,
            this.parseCommand();
        }
    }

    private void parseCommand() throws Throwable {

        System.out.println("Enter a command:");

        Scanner in = new Scanner(System.in);
        String command = in.nextLine();

        // chuvak v kabinete
        ElectricityController ec = new ElectricityController();

        Method method = null; // тип данных, переменной еще не присвоено значение.

        try {
            method = ec.getClass().getMethod(command);

        } catch (SecurityException e) {
            System.out.println("An error has occurred :((( " + e.getMessage());
        }
        catch (NoSuchMethodException e) {
            System.out.println("We are terribly sorry");
        }

        if(method != null) {
            try {
                method.invoke(ec);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
                // System.out.println(e.getMessage());
            } catch(Throwable e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
