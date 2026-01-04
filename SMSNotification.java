import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
        out.println("SMS message: " + message);
    }
}
