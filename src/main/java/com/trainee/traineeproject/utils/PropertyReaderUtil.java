package com.trainee.traineeproject.utils;

import com.trainee.traineeproject.config.AppConfig;

import java.io.*;

public class PropertyReaderUtil {

    public static void readAppProperty() {
        InputStream inputStream = PropertyReaderUtil.class.getClassLoader().getResourceAsStream("application.yaml");
        AppConfig appConfig = AppConfig.getInstance();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("=");
                if ("noConsumers".equals(split[0])) {
                    appConfig.setNoConsumer(Integer.parseInt(split[1]));
                }
            }

        } catch (IOException e) {
            System.out.println("Problem reading the log file!");
            e.printStackTrace();
        }
    }
}
