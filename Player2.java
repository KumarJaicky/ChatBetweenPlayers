import java.util.concurrent.BlockingQueue;

/**
 * Player2 is responsible for consuming the message from the queue.
 * @author jaicky.kumar
 *
 */
public class Player2 implements Runnable {
    private BlockingQueue<String> queue;

    public Player2(BlockingQueue<String> queue) {
        this.queue = queue;
    }
    int count = 0;
    public void run() {
        try {

            while (true) {
                count++;
                String number = queue.take();

                if (number == null || number.equals("")) {
                    break;
                }

                consume(number,count);

                Thread.sleep(1000);
            }

            System.out.println("Player2 STOPPED.");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void consume(String number, int count) {

        System.out.println(number.concat(String.valueOf(count)));

    }
}