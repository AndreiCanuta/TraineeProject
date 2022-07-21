package com.trainee.traineeproject;

import com.trainee.traineeproject.utils.ThreadHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    static ThreadHandler threadHandler = new ThreadHandler();

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        threadHandler.run();

    }
}

