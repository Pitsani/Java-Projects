import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private List<PrintStream> clients;
    private Object mutex;

    private Server() {
        clients = new ArrayList<>();
    }

    public static void main(String[] args) {
        new Server().start();
    }

    private void start() {
        try {
            ServerSocket socket = new ServerSocket(2101);

            while (true) {
                Socket client = socket.accept();

                new Thread(() -> {
                    try {
                        Scanner in = new Scanner(client.getInputStream());
                        PrintStream out = new PrintStream(client.getOutputStream());
                        synchronized (mutex) {
                            clients.add(out);
                        }

                        while (true) {
                            String line = in.nextLine();
                            if (line.contains("quit")) {
                                in.close();
                                out.close();
                                client.close();
                                synchronized (mutex) {
                                    clients.remove(out);
                                }
                                break;
                            }
                            synchronized (mutex) {
                                for (PrintStream c : clients) {
                                    c.println(line);
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}