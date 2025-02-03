import java.util.regex.Pattern;

public class Website{
    protected int visits;
    protected String address;

    public Website(String address, int visits) {
        this.address = address;
        this.visits = 1;
    }

    public int getVisits() {
        return visits;
    }

    public String getAddress() {
        return address;
    }

    public void addVisits(){
        visits++;
    }
}
