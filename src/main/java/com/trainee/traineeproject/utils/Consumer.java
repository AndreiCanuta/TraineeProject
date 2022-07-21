package com.trainee.traineeproject.utils;

import com.trainee.traineeproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.BlockingQueue;

import static com.trainee.traineeproject.utils.CsvParser.lineToCustomer;

public class Consumer implements Runnable {
    private final BlockingQueue<String> blockingQueue;
    @Autowired
    CustomerRepository customerRepository;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
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
