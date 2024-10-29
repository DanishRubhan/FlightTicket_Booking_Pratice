import java.util.HashMap;
import java.util.Map;

public class Flight {
    private String flightNumber;
    private String airline;
    private String from;
    private String to;
    private int departDate;
    private double departTime;
    private Map<String,Fare> fares;

    public Flight(String flightNumber, String airline, String from, String to, int departDate, double departTime) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.departDate = departDate;
        this.departTime = departTime;
        this.fares = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", airline='" + airline + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departDate=" + departDate +
                ", departTime=" + departTime +
                ", fares=" + fares +
                '}';
    }

    public int getDepartDate() {
        return departDate;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public  void addFare(Fare fare) {
        fares.put(fare.getFareType(), fare);
    }

    public boolean isAvailable(String fareType, int paxCount) {
        Fare fare=fares.get(fareType);
        return fare!=null && fare.getAvailableSeats(paxCount)!=null;
    }

    public Fare getFare(String fareType) {
        return fares.get(fareType);
    }
}
