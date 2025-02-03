public class Main {

    private static int a;
    private static final Object mutex;

    static {
        a=0;
        mutex = new Object();
    }
    public static void main(String[] args) {
        Runnable r = () -> {
            synchronized (mutex) {
                for (int i = 0; i < 10000; i++) {
                    a++;
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(a);
    }
}