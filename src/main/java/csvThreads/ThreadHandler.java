package csvThreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadHandler {

    public void run () {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

        Producer readFromCsv = new Producer(queue);
        new Thread(readFromCsv).start();

        Consumer addToDatabase = new Consumer(queue);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 3; i++) {
            executor.submit(addToDatabase);
        }
        executor.shutdown();
    }
}
