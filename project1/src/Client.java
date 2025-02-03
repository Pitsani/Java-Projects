import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Socket socket;
    public static Scanner reader;
    public static PrintStream writer;
    public static Scanner scanner;

    public static void main(String[] args) throws IOException {
        socket = new Socket("127.0.0.1", 8080);

        var out = socket.getOutputStream();
        var in = socket.getInputStream();

        reader = new Scanner(in);
        writer = new PrintStream(out);

        scanner = new Scanner(System.in);

        RunLogic();

        reader.close();
        writer.close();
        socket.close();
    }
    public static void PerformAction(String wholeMessage)
    {
        String[] commandArray = wholeMessage.split(":");

        Commands cmd = Commands.valueOf(commandArray[0]);
        String args = commandArray[1];

        var thread = Thread.currentThread();
        System.out.println("(R" + thread.threadId() + ")[" + cmd  + "]: " + args);

        switch (cmd)
        {
            case WELCOME:
                SendMessage(Commands.WELCOME, "Welcome from the client");
                break;
            case ASK_ACCOUNT_NUMBER:
                var accountNumber = scanner.nextLine();
                SendMessage(Commands.ACCOUNT_NUMBER, accountNumber);
                break;
            case ACCOUNT_NUMBER:
                System.out.println("Account number: " + args);
                break;
            case PIN:
                System.out.println("PIN: " + args);
                break;
            case ASK_PIN:
                var pin = scanner.nextLine();
                SendMessage(Commands.PIN, pin);
                break;
            case WITHDRAW:
                var amount = scanner.nextLine();
                SendMessage(Commands.WITHDRAW, amount);
                break;
            case DEPOSIT:
                amount = scanner.nextLine();
                SendMessage(Commands.DEPOSIT, amount);
                break;
            case GET_BALANCE:
                SendStatus(Commands.GET_BALANCE, Status.OK);
                break;
            case ERROR:
                SendStatus(Commands.GET_BALANCE, Status.ERROR);
                break;
            default:
                SendMessage(Commands.ERROR, "Command not recognized");
                break;
        }
    }

    public static void SendMessage(Commands command, String message)
    {
        var thread = Thread.currentThread();
        System.out.println("(S" + thread.threadId() + ")[" + command + "] " + message);
        writer.printf("%s:%s\n", command, message);

        String wholeMessage = reader.nextLine();
        System.out.println("(R" + thread.threadId() + ")[" + command + "] " + wholeMessage.split(":")[1]);
    }


    public static void SendStatus(Commands command, Status status)
    {
        var thread = Thread.currentThread();
        System.out.println("(S" + thread.threadId() + ")[" + command + "] " + status);
        writer.printf("%s:%s\n", command, status);
    }


    public static void RunLogic()
    {

        String wholeMessage = null;

        do {

            wholeMessage = reader.nextLine();

            PerformAction(wholeMessage);
        } while (!wholeMessage.isEmpty() && !wholeMessage.isBlank());
    }
}
