import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Fare {
    private String fareType;
    private double price;
    private List<Seat> seats;

    public Fare(String fareType, double price, List<Seat> seats) {
        this.fareType = fareType;
        this.price = price;
        this.seats = seats;
    }

    public String getFareType() {
        return fareType;
    }

    public double getPrice() {
        return price;
    }

    public List<Seat>  getAvailableSeats(int paxCount) {
        List<Seat> availableSeats=new ArrayList<>();

        for(Seat seat:seats) {
            if(!seat.isBooked()) {
                availableSeats.add(seat);
                if(availableSeats.size()==paxCount) {
                    return availableSeats;
                }
            }
        }
        return availableSeats.size()>=paxCount?availableSeats:null;
    }

    @Override
    public String toString() {
        return "Fare{" +
                "fareType='" + fareType + '\'' +
                ", price=" + price +
                ", seats=" + seats +
                '}';
    }
}
