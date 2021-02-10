package energybills.lifecycle;

/*
->
 */
import energybills.domain.model.Customer;
import energybills.domain.model.House;

public class Bootstrap {

    public static void printUsageStatistics() {
        System.out.println("The time now is: (time), the date now is (date)");
        System.out.println("I am (User)");
    }

    public void init() {

        House h1 = House.getInstance();  // создаю дом х1 через синглтон = blablabla.getInstance --- всегда для singleton

        Customer r = new Customer();        // создаю консумера р
        r.setLogin("roma");                //задаю логин
        r.setName("Roma");                //задаю имя

        Customer j = new Customer();     // тоже самое
        j.setLogin("julia");
        j.setName("Julia");

        h1.addConsumer(r);           //добавляю пользователя в дом h1 определенный дом h1
        h1.addConsumer(j);


        Thread t = new Thread( // поток, ибо потребление энергии генерирунтся в вечном цикле
                // и без отдельного потока прога зависнет в этом месте, без нее асинхронно
                new Runnable() {
                    @Override
                    public void run() {
                        try {

                            h1.generateEnergyConsumes();
                        } catch (Exception e) {
                            System.err.println("An exception occurred");
                        }


                    }
                });
        t.start();

        //run our generator
        //h1.generateEnergyConsumes();
    }
}
