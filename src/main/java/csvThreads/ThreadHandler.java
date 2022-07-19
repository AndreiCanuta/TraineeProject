package csvThreads;

import config.AppConfig;

import java.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadHandler {

    Logger logger = LoggerFactory.getLogger(ThreadHandler.class);
    public void run () {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

        Producer readFromCsv = new Producer(queue);
        new Thread(readFromCsv).start();

        Consumer addToDatabase = new Consumer(queue);
        ExecutorService executor = Executors.newFixedThreadPool(AppConfig.getInstance().getNoConsumer());
        logger.info("Starting consumers");
        for (int i = 1; i <= AppConfig.getInstance().getNoConsumer(); i++) {
            executor.submit(addToDatabase);

        }
        logger.info("Consume");
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
