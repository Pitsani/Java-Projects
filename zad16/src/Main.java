import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        hashFileContent("src/file1.txt");
        hashFileContent("src/file2.txt");
    }
    public static void hashFileContent(String filePath)
    {
        BufferedReader br = null;
        try {

            String currentLine;

            br = new BufferedReader(new FileReader(filePath));
            String code = "";
            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
                code = currentLine;

            }
            int hashCode = code.hashCode();
            System.out.println(hashCode);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}