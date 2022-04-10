import Entity.Message;

import java.io.*;
import java.net.Socket;
import java.time.ZonedDateTime;

public class ClientThread {
    protected Socket socket;

    public ClientThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() throws IOException, ClassNotFoundException {
        while(!socket.isClosed())
        {
            InputStream inputStream = socket.getInputStream();
            if(inputStream != null)
            {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                Message message = (Message) objectInputStream.readObject();
                System.out.println(message.getMessage());
                long time = ZonedDateTime.now().toInstant().toEpochMilli() - message.getTime().getTime();
                System.out.println("Time between send and receive message: " + time + " ms");
            }
        }
    }
}
