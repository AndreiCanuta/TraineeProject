package csvThreads;

import entity.Customer;
import repository.CustomerRepository;

import java.util.concurrent.BlockingQueue;

import static csvThreads.CsvParser.lineToCustomer;

public class Consumer implements Runnable {
    private final BlockingQueue<String> blockingQueue;
    private final CustomerRepository customerRepository = new CustomerRepository();

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String line = blockingQueue.take();
                if(line.equals("EOF")) {
                    break;
                }
                customerRepository.addCustomer(lineToCustomer(line));

            } catch (InterruptedException e) {
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
