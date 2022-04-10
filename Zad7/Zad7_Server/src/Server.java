import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int Port;
    private ServerSocket serverSocket = null;

    public Server(int port)
    {
        Port = port;
    }

    public void runServer() throws IOException {
        Socket socket = null;
        serverSocket = new ServerSocket(Port);
        System.out.println("Server has been started.");


        while(true)
        {
            try {
                socket = serverSocket.accept();
                System.out.println("Connection from " + socket + "!");
            } catch (Exception e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client

            try{
                new ClientThread(socket).run();
            }catch(Exception e)
            {
//                System.out.println(e.getMessage());
            }
        }
    }
}
