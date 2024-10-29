import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
    private Map<String, Booking> bookings=new HashMap<>();

    private int bookingCounter;

    public String bookFlight(User user, Flight flight, Fare fare, List<Seat> seats) {
        double totalCost=fare.getPrice()*seats.size();
        if(user.getFunds()<totalCost) {
            return "Insufficient fund";
        }

        seats.forEach(Seat::book);
        user.deductFund(totalCost);
        String bookingId="B" +(++bookingCounter);
        Booking booking =new Booking(bookingId,user,flight,fare,seats);
        bookings.put(bookingId, booking);
        return "Booked successfully , Booking id : " +booking.getBookingId();
    }

    public List<Booking> getUserBooking(String userId) {
        List<Booking> ls=new ArrayList<>();
        for(Booking b:bookings.values()) {
            if(b.getUser().getUserId().equals(userId)) {
                ls.add(b);
            }
        }
        return ls;
    }

    public String cancelBooking(String userId, String bookingId) {
        Booking booking=bookings.get(bookingId);
        if(booking==null) {
            return "Booking not found .....";
        }

        if(!booking.getUser().getUserId().equals(userId)) {
            return "Booking does not belong to the specific user...";
        }

        if(booking.isCancelled()) {
            return "Booking is already cancelled...";
        }

        booking.cancel();
        booking.getSeats().forEach(Seat::release);
        booking.getUser().refund(booking.getFare().getPrice() * booking.getSeats().size());

        return "Booking canceled successfully!!";
    }
}
