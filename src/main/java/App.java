import controller.CustomerController;
import csvThreads.ThreadHandler;

import java.util.SortedMap;

public class App {
    public static CustomerController controller = new CustomerController();

    public static void main (String[] arcs) throws InterruptedException {
        ThreadHandler threadHandler = new ThreadHandler();
        threadHandler.run();

        Thread.sleep(1000);
        System.out.println(controller.getAllCustomers().size());
    }
}
