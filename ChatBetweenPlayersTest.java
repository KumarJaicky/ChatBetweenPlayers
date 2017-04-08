import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ChatBetweenPlayers test example (1 player1 thread - 1 player2 thread)
 * @author jaicky.kumar
 *
 */
public class ChatBetweenPlayersTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(20);

        Thread player1 = new Thread(new Player1(queue));

        Thread player2 = new Thread(new Player2(queue));

        player1.start();
        player2.start();

    }
}