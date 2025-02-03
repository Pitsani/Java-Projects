import java.util.regex.Pattern;

public class VisitImpl implements Visit {
    private String data;
    private String address;

    public VisitImpl(String data, String address) {
        this.data = data;
        this.address = address;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String getAddress() {
        return address;
    }


}
