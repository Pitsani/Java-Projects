import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;

public class TicketLoader implements Importable {
    private final static String FILE_WITH_CONCERTS_NAME = "dailytickets.txt";
    public BufferedReader br = null;

    @Override
    public Object[] importDataFromFile() throws IOException {
        Event[] arrayofEvents = null;
        int numberOfRows = getNumberOfRows();

        br = new BufferedReader(new FileReader(FILE_WITH_CONCERTS_NAME));

        arrayofEvents = new Event[numberOfRows];
        String line;
        int currentRowIndex = 0;

        Field[] fieldsOfConcertClass = Concert.class.getDeclaredFields();
        Field[] fieldsOfEventClass = VolleyballMatch.class.getSuperclass().getDeclaredFields();
        Field[] fieldsOfVolleyClass = VolleyballMatch.class.getDeclaredFields();

        int totalNumberOfFieldsOfVolleyClass = fieldsOfEventClass.length + fieldsOfVolleyClass.length;
        int totalNumberOfFieldsOfConcertClass = fieldsOfEventClass.length + fieldsOfConcertClass.length;

        while ((line = br.readLine()) != null) {
            try {
                if (line.startsWith("1")) {
                    String[] concertArray = line.split("\\*");

                    if (concertArray.length == (totalNumberOfFieldsOfConcertClass + 1)) {
                        Concert c = new Concert(concertArray[1], concertArray[2], concertArray[3], concertArray[4], Integer.parseInt(concertArray[5]), Double.parseDouble(concertArray[6]));

                        arrayofEvents[currentRowIndex++] = c;
                    }
                } else if (line.startsWith("2")) {
                    String[] volleyArray = line.split("\\*");
                    if (volleyArray.length == (totalNumberOfFieldsOfVolleyClass + 1)) {
                        VolleyballMatch v = new VolleyballMatch(volleyArray[1], volleyArray[2], volleyArray[3], volleyArray[4], volleyArray[5], Integer.parseInt(volleyArray[6]), Double.parseDouble(volleyArray[7]));
                        arrayofEvents[currentRowIndex++] = v;
                    } else {
                        throw new UnrecognisedRowException(
                                "One unrecognised row was founded at " + (currentRowIndex + 1) + " row!");
                    }
                }
            } catch (UnrecognisedRowException e) {
                System.out.println(e.getMessage());
            }

        }

        return arrayofEvents;
    }

    private int getNumberOfRows() throws IOException {
        br = new BufferedReader(new FileReader(FILE_WITH_CONCERTS_NAME));

        int numberOfRows = 0;
        while (br.readLine() != null) {
            numberOfRows++;
        }
        br.close();
        return numberOfRows;
    }

}