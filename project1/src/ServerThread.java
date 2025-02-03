import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ServerThread implements Runnable {
    private ArrayList<Account> accounts;
    private HashMap<Data, Object> sessionData;
    private Socket socket;
    private Scanner reader;
    private PrintStream writer;

    public ServerThread(Socket server) throws IOException {
        accounts = new ArrayList<Account>() {{
            add(new Account(100, "1234", "123456789"));
            add(new Account(400, "4321", "182935617"));
            add(new Account(950, "1111", "890245162"));
        }};

        sessionData = new HashMap<Data, Object>();
        socket = server;
    }

    public void run() {
        try {
            var out = socket.getOutputStream();
            var in = socket.getInputStream();

            Scanner scanner = new Scanner(System.in);

            reader = new Scanner(in);
            writer = new PrintStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ServerLogic();

        try {
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Commands command, String message) {
        var thread = Thread.currentThread();
        System.out.println("(S" + thread.threadId() + ")[" + command + "] " + message);
        writer.printf("%s:%s\n", command, message);
    }

    public void getMessage()
    {
        var thread = Thread.currentThread();
        String wholeMessage = reader.nextLine();
        String[] commandArray = wholeMessage.split(":");
        Commands cmd = Commands.valueOf(commandArray[0]);
        String args = commandArray[1];
        ProcessMessage(cmd, args);
    }

    public void SendStatus(Commands command, Status status) {
        var thread = Thread.currentThread();
        System.out.println("(S" + thread.threadId() + ")[" + command + "] " + status);
        writer.printf("%s:%s\n", command, status);
    }

    public void ProcessMessage(Commands cmd, String args) {
        switch (cmd) {
            case WELCOME:
                SendStatus(Commands.WELCOME, Status.OK);
                break;
            case ACCOUNT_NUMBER:
                Status message = accounts.stream()
                        .anyMatch(account -> account.getAccountNumber()
                        .equals(args)) ? Status.OK : Status.ERROR;

                if (message == Status.OK) sessionData.put(Data.ACCOUNT_NUMBER, args);

                SendStatus(Commands.ACCOUNT_NUMBER, message);
                break;
            case PIN:
                var accountNumber = sessionData.get(Data.ACCOUNT_NUMBER);

                var account = accounts.stream().filter(acc -> acc.getAccountNumber()
                                                            .equals(accountNumber))
                                                            .findFirst().get();
                message = account.checkPin(args) ? Status.OK : Status.ERROR;
                if (message == Status.OK) sessionData.put(Data.ACCOUNT, account);

                SendStatus(Commands.PIN, message);
                break;
            case WITHDRAW:
                try {
                    account = (Account) sessionData.get(Data.ACCOUNT);
                    account.withdraw(Double.parseDouble(args));
                    SendStatus(Commands.WITHDRAW, Status.OK);
                } catch (Exception e) {
                    SendStatus(Commands.WITHDRAW, Status.ERROR);
                    break;
                }
                break;
            case DEPOSIT:
                try {
                    account = (Account) sessionData.get(Data.ACCOUNT);
                    account.deposit(Double.parseDouble(args));
                    SendStatus(Commands.DEPOSIT, Status.OK);
                } catch (Exception e) {
                    SendStatus(Commands.DEPOSIT, Status.ERROR);
                    break;
                }
                break;
            case GET_BALANCE:
                break;
            default:
                SendStatus(Commands.ERROR, Status.ERROR);
                break;
        }
    }
    public void ServerLogic() {
        sendMessage(Commands.WELCOME, "Welcome to the ATM");
        getMessage();
    }
}

