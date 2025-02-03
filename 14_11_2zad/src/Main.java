import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        WebsiteStatistics statistics = new WebsiteStatistics();
        try(BufferedReader br = new BufferedReader(new FileReader("src/visits.txt"))){
            String line;
            while((line = br.readLine())!= null){
                String[] parts = line.split(" ");
                if(parts.length!=3){
                    System.out.println("Wrong line "+line);
                    continue;
                }
                String data = parts[0] + " " + parts[1];
                String url = parts[2];

                VisitImpl visit = new VisitImpl(data, url);
                statistics.addVisit(visit);

            }
            statistics.analyze();
        }
        catch (IOException e){
            System.out.println("Wrong line reading");
        }
    }
}