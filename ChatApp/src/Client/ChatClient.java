package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8081;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server");

            Scanner scanner = new Scanner(System.in);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            Thread receiverThread = new Thread(new Receiver(socket));
            receiverThread.start();

            while (true) {
                String message = scanner.nextLine();
                writer.println(message);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Receiver implements Runnable {
        private Socket socket;

        public Receiver(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                Scanner reader = new Scanner(socket.getInputStream());
                while (true) {
                    if (reader.hasNextLine()) {
                        String message = reader.nextLine();
                        System.out.println("Received: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
