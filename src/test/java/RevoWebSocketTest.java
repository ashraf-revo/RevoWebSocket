import org.junit.Test;
import org.revo.Message;
import org.revo.RevoStompHandler;
import org.revo.RevoWebSocket;

import java.util.function.Consumer;

/**
 * Created by revo on 23/12/15.
 */
public class RevoWebSocketTest {
    @Test
    public void testsend() throws Exception {
        RevoWebSocket revoWebSocket = new RevoWebSocket("wss://springwebsocketclient.herokuapp.com/hello", "revo", "revo");
        revoWebSocket.Connect();
        if (revoWebSocket.isConnected()) {
            revoWebSocket.subscribe("/user/topic/greetings", new RevoStompHandler<Message>(Message.class, new Consumer<Message>() {
                public void accept(Message m) {
                    System.out.println(m.getContent());
                }
            }));
            revoWebSocket.send("/app/hello", new Message("lovex"));
            Thread.sleep(1000);
        }
    }
}