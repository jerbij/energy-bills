package energybills;
import energybills.controller.FrontController;
import energybills.lifecycle.Bootstrap;
import energybills.lifecycle.TestClass;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // create initalizer for our application
        Bootstrap b1 = new Bootstrap();

        TestClass b2 = new TestClass();

        // run initialization
        b1.init();

        // MVC
        // M = model
        // V = view
        // C = controller

        // SOLID
        FrontController fc = new FrontController();
        fc.run();

    }
}
