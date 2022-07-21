package com.trainee.traineeproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
