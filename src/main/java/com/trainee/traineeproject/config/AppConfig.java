package com.trainee.traineeproject.config;

import com.trainee.traineeproject.data.Database;
import com.trainee.traineeproject.service.CustomerService;
import com.trainee.traineeproject.service.CustomerServiceMocks;

public class AppConfig {
    private static AppConfig instance;

    private AppConfig() {}


    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    private int noConsumer;

    public int getNoConsumer() {
        return noConsumer;
    }

    public void setNoConsumer(int noConsumer) {
        this.noConsumer = noConsumer;
    }

}
