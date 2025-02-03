import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HashFile {
    protected String fileName;
    protected HashMap<String, Integer> items;

    public HashFile(String fileName) {
        this.fileName = fileName;
    }

    public void openAndRead(String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(name + ".txt"))) {
            String line;

            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                items.put(line, lineNumber);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
