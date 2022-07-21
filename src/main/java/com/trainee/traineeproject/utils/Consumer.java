package com.trainee.traineeproject.utils;

import com.trainee.traineeproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;

import static com.trainee.traineeproject.utils.CsvParser.lineToCustomer;

@Component
public class Consumer implements Runnable {
    private final BlockingQueue<String> blockingQueue;
    final
    CustomerRepository customerRepository;

    public Consumer(BlockingQueue<String> blockingQueue, CustomerRepository customerRepository) {
        this.blockingQueue = blockingQueue;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getId() + " Start time " + System.currentTimeMillis());
        while (true) {
            try {
                String line = blockingQueue.take();
                if(line.equals("EOF")) {
//                    System.out.println(Thread.currentThread().getId() + " End time " + System.currentTimeMillis());
                    break;
                }
                customerRepository.addCustomer(lineToCustomer(line));
//                sleep(1);

            } catch (InterruptedException e) {
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
