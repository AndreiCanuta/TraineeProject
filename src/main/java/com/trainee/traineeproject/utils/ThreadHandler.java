package com.trainee.traineeproject.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class ThreadHandler {
    private final BlockingQueue<String> queue;
    private final Consumer consumer;
    private final Producer producer;

    public ThreadHandler(BlockingQueue<String> queue, Consumer consumer, Producer producer) {
        this.queue = queue;
        this.consumer = consumer;
        this.producer = producer;
    }

    public void run () {

        new Thread(producer).start();

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
