package readers;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
   private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                String line = blockingQueue.take();
                // add parsing functions


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
