import Entity.Reminder;

import java.io.*;
import java.net.Socket;

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

                Reminder reminder = (Reminder) objectInputStream.readObject();
                System.out.println(reminder.getMessage());
            }
        }
    }
}
