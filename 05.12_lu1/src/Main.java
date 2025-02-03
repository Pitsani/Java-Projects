import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<String> arrayList;
    private static final Object mutex;

    static {
        arrayList = new ArrayList<>();
        mutex = new Object();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Runnable r = () -> {
            for (int i = 0; i <= 100; i++) {
                String text = sc.nextLine();
                synchronized (mutex) {
                    arrayList.add(text);
                }
            }
        };

        Runnable r1 = () -> {
            while (true) {
                try {
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread interrupted: " + e.getMessage());
                }
                synchronized (mutex) {
                    System.out.println("ArrayList contents: " + arrayList);
                }

            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}