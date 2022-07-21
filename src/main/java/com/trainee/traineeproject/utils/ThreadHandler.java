package com.trainee.traineeproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.*;

@Component
public class ThreadHandler {
    private final BlockingQueue<String> queue;
    private final Consumer consumer;

    public ThreadHandler(BlockingQueue<String> queue, Consumer consumer) {
        this.queue = queue;
        this.consumer = consumer;
    }

    public void run () {

        Producer readFromCsv = new Producer(queue);
        new Thread(readFromCsv).start();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 3; i++) {
            executor.submit(consumer);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
