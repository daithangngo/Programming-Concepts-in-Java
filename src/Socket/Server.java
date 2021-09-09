package Socket;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket server = null;
    try {
      server = new ServerSocket(8000); // Server-Socket erzeugen
    } catch (BindException e) {
      System.out.println("8000 ist bereits durch einen Server belegt.");
      return;
    }
    try {
      while (true) { // dauerhaft Clients akzeptieren (jeweils nur einer gleichzeitig)
        Socket client = server.accept(); // neuen Client annehmen
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        // Start: Ab jetzt kann mit dem Client kommuniziert werden (über in und out)
        while (true) {
          String line = in.readLine(); // empfange Daten vom Client
          if (line == null) // Client hat Verbindung geschlossen
          break;
          out.println(line); // dieselben Daten an den Client zurückschicken
          out.flush(); // Senden durchführen (println schreibt nur in den Buffer)
        }
        // Ende
        client.close(); // Verbindung zum zuvor angenommenen Client schließen
      }
    } finally {
      server.close(); // am Ende das Server-Socket wieder schließen (in jedem Fall)
    }
  }
}
