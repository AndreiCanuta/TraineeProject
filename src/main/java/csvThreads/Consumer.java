package csvThreads;

import entity.Customer;
import entity.CustomerType;
import repository.CustomerRepository;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
   private BlockingQueue<String> blockingQueue;
   private final CsvParser csvParser = new CsvParser();
   private final CustomerRepository customerRepository = new CustomerRepository();

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                if (blockingQueue.peek() == null) {
                    break;
                }
                String line = blockingQueue.take();
                Customer customer = csvParser.lineToCustomer(line);
                customerRepository.addCustomer(customer);


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
