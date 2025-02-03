import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String myName;

    public static void main(String[] args) {
        new Client().start();
    }
    private void start(){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter name: ");
        myName = console.nextLine();

        try {
            Socket socket = new Socket("localhost", 2101);
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());

            Runnable writer = () -> {
                while(true){
                    String line = console.nextLine();
                    out.println(myName+":"+line);
                    if(line.contains("quit")){
                        in.close();
                        out.close();
                        try{
                            socket.close();
                        }
                        catch (IOException e ){
                            e.printStackTrace();
                        }
                        return;
                    }
                }
            };

            Runnable reader = () ->{
              while(true){
                  if(in.hasNext()){
                      System.out.println(in.nextLine());
                  }
              }
            };

            Thread writerThread = new Thread(writer);
            Thread readerThread = new Thread(reader);

            writerThread.start();
            readerThread.start();

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
