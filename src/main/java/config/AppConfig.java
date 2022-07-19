package config;

import data.Database;

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
