package csvThreads;

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
                if (blockingQueue.peek() == null) {
                    break;
                }
                String line = blockingQueue.take();
                System.out.println(line);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
