package com.trainee.traineeproject.csvThreads;

import com.trainee.traineeproject.repository.CustomerRepositoryMock;

import java.util.concurrent.BlockingQueue;

import static com.trainee.traineeproject.csvThreads.CsvParser.lineToCustomer;
import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    private final BlockingQueue<String> blockingQueue;
    private final CustomerRepositoryMock customerRepositoryMock = new CustomerRepositoryMock();

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
                customerRepositoryMock.addCustomer(lineToCustomer(line));
//                sleep(1);

            } catch (InterruptedException e) {
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
