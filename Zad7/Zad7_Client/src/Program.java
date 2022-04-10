import Entity.Date;
import Entity.Reminder;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 1234);
        client.runClient();

        Reminder reminder = new Reminder("Czy dziala", new Date());

        client.SendReminder(reminder);
    }
}
