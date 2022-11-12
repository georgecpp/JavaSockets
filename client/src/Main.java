import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Socket socket = new Socket(args[0], Integer.parseInt(args[1]))) {

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            String line = null;

            do {
                line = sc.nextLine();

                out.println(line);

                System.out.println("Server replied "
                        + in.readLine());
            }
            while (!"stop".equalsIgnoreCase(line));
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
