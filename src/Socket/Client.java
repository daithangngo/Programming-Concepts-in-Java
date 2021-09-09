package Socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000); // zum Server verbinden
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()));
            out.println("Dieser Text wird an den Server geschickt");
            out.flush();
            System.out.println("Antwort des Servers: " + in.readLine());
        } finally {
            socket.close();
        }
    }
}
