package com.trainee.traineeproject.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

@Component
public class Producer implements Runnable{
    private final BlockingQueue<String> blockingQueue;
    protected transient BufferedReader bufferedReader;

    @Override
    public void run() {
        String line;
        try {
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                blockingQueue.put(line);
            }

            for (int i = 0; i < 3; i++) {
                blockingQueue.put("EOF");
            }

        } catch (IOException e) {
            System.out.println("Problem reading the log file!");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Producer(BlockingQueue<String> blockingQueue, BufferedReader bufferedReader) {
        this.blockingQueue = blockingQueue;
        this.bufferedReader = bufferedReader;
    }
}
