import service.ThreadHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        ServerSocket server = null;
        try {

            server = new ServerSocket(port);
            server.setReuseAddress(true);

            while (true) {

                Socket client = server.accept();
                System.out.println("New client connected: "
                        + client.getInetAddress()
                        .getHostAddress());

                ThreadHandler threadPerClient = new ThreadHandler(client);
                new Thread(threadPerClient).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
