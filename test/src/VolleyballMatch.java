public class VolleyballMatch extends Event {
    protected String firstTeam;
    protected String secondTeam;

    public VolleyballMatch(String place, String date, String startHour, int numberOfTickets, double priceOfTicket, String firstTeam, String secondTeam) {
        super(place, date, startHour, numberOfTickets, priceOfTicket);
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    @Override
    public boolean sellTicket(int num) throws NoMoreTicketException {
        if (num > this.numberOfTickets || numberOfTickets == 0) {
            throw new NoMoreTicketException(this.firstTeam + " - " + this.secondTeam);
        } else {
            this.numberOfTickets = this.numberOfTickets - num;
            return true;
        }
    }
}
