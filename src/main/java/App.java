import controller.CustomerController;
import csvThreads.ThreadHandler;


public class App {
    public static CustomerController controller = new CustomerController();

    public static void main (String[] arcs) throws InterruptedException {
        ThreadHandler threadHandler = new ThreadHandler();
        threadHandler.run();

        while (controller.getAllCustomers().size() != 1000) {
            Thread.sleep(500);
        }

        System.out.println(controller.getAllCustomers().size());

    }
}
