import Entity.DateOwn;
import Entity.Message;
import Helpers.GetMessageFromUser;

import java.io.IOException;
import java.io.InputStream;

public class Program {
    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 1234);
        client.runClient();

        for(int i = 1; i < 3; i++)
        {
            Message message = new Message(GetMessageFromUser.GetMessage("Podaj tresc wiadomosci do wyslania: "), new DateOwn());
            client.SendMessageToServer(message);
        }

        client.disconnectClient();
    }
}
