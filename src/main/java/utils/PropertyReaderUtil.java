package utils;

import config.AppConfig;

import java.io.*;

public class PropertyReaderUtil {

    public static void readAppProperty() {
        InputStream inputStream = PropertyReaderUtil.class.getClassLoader().getResourceAsStream("application.properties");
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
