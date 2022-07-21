package com.trainee.traineeproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Configuration
public class CSVReadersConfig {

    @Bean
    public BlockingQueue<String> getBlockingQueue() {
        return new ArrayBlockingQueue<>(100);
    }

    @Bean
    public BufferedReader getBufferedReader() {
        try {
            return new BufferedReader(new FileReader("data/mockData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
