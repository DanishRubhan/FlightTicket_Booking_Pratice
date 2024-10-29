import java.util.List;

public class Booking {
    private String bookingId;
    private User user;
    private Flight flight;
    private Fare fare;
    private List<Seat> seats;
    private boolean isCancelled;

    public Fare getFare() {
        return fare;
    }

    public Booking(String bookingId, User user, Flight flight, Fare fare, List<Seat> seats) {
        this.bookingId = bookingId;
        this.user = user;
        this.flight = flight;
        this.fare = fare;
        this.seats = seats;
        this.isCancelled = false;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", user=" + user +
                ", flight=" + flight +
                ", fare=" + fare +
                ", seats=" + seats +
                ", isCancelled=" + isCancelled +
                '}';
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancel() {
        this.isCancelled=true;
    }
}
