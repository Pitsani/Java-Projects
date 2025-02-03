import java.io.IOException;
public class EventProcessing {

    public static Concert[] arrayOfConcerts = null;
    public static VolleyballMatch[] arrayOfVolleyball = null;
    private final static int SIZE_OF_OBJECT_BUFFER = 100;

    public static void main(String[] args) {
        System.out.println("Only for testing:");
        try {
            processTickets();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Concert c = arrayOfConcerts[0];
        try {
            c.sellTicket(500);
            c.sellTicket(20000);
        } catch (NoMoreTicketException e) {

            System.out.println(e.getMessage());
        }

    }
    public static void processTickets() throws IOException {
        System.out.println("Processing...");
        arrayOfConcerts = new Concert[SIZE_OF_OBJECT_BUFFER];
        arrayOfVolleyball = new VolleyballMatch[SIZE_OF_OBJECT_BUFFER];
        TicketLoader t = new TicketLoader();
        Event[] arrayOfEvents = (Event[]) t.importDataFromFile();
        int i = 0;
        int j = 0;
        for (Event e : arrayOfEvents) {
            if (e instanceof Concert) {
                arrayOfConcerts[i++] = (Concert) e;
            } else if (e instanceof VolleyballMatch) {
                arrayOfVolleyball[j++] = (VolleyballMatch) e;
            }
        }
        System.out.println("Process of importing finished.");
        System.out.println("Num loaded concerts: " + i);
        System.out.println("Num loaded volleyballs: " + j);
    }

}