import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
/**
 * Player1 is responsible for initiating the message and putting in into the queue.
 * @author jaicky.kumar
 *
 */
public class Player1 implements Runnable {
    private BlockingQueue<String> queue;

    public Player1 (BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                queue.put(produce());

                Thread.sleep(500);
            }

            queue.put("");  // indicates end of producing

            System.out.println("Player1 STOPPED.");

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private String produce() {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        //System.out.println("Enter your message: ");
        String input = reader.nextLine();

        //System.out.println(input);

        return input;
    }
}