public class Concert extends Event{
    protected String starName;

    public Concert(String place, String date, String startHour, int numberOFTickets, double priceOfTicket, String starName) {
        super(place, date, startHour, numberOFTickets, priceOfTicket);
        this.starName = starName;
    }

    @Override
    public boolean sellTicket(int num) throws NoMoreTicketException {
        if (num > this.numberOfTickets || numberOfTickets == 0) {
            throw new NoMoreTicketException(this.starName + "'s concert.");
        } else {
            this.numberOfTickets -= num;
            System.out.println(num + " tickets saled!");
            System.out.println("All free tickets are: " + this.numberOfTickets);
            return true;
        }
    }
}
