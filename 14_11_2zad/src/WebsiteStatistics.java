import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebsiteStatistics {
    private List<VisitImpl> visits = new ArrayList<>();
    public void addVisit(VisitImpl visit){
        visits.add(visit);
    }

    public void analyze(){
        List<String> dates = new ArrayList<>();
        for(Visit visit : visits){
            String data = visit.getData().split(" ")[0];
            if(!dates.contains(data)){
                dates.add(data);
            }
        }
        for(String data : dates){
            List<Website> websites = new ArrayList<>();
            for(Visit visit : visits){
                if(visit.getData().startsWith(data)){
                    String url = visit.getAddress();
                    boolean found = false;
                    for(Website website : websites){
                        if(website.getAddress().equals(url)){
                            website.addVisits();
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        websites.add(new Website(url,1));
                    }
                }
            }

            int visitsSum = websites.stream().mapToInt(Website::getVisits).sum();
            Website leastVisit = websites.stream()
                    .min(Comparator.comparingInt(Website::getVisits))
                    .orElse(null);
            System.out.println("Date: " + data);
            System.out.println("Visits: " + visitsSum);
            if(leastVisit!=null){
                System.out.println("Least visited: "+ leastVisit.getAddress()+" with " + leastVisit.getVisits() + " visits");

            }
        }
    }
}
