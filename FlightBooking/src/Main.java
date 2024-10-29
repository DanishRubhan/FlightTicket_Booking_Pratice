import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService=new UserService();
        FlightService flightService=new FlightService();
        BookingService bookingService=new BookingService();

        //add user
        userService.addUser("u1","Danish",5000);
        userService.addUser("u2","Rubhan",1500);

        Flight flight1 =new Flight("101","6E","DEL","BEL",2,10.3);
        flight1.addFare(new Fare("F1",2000, Arrays.asList(new Seat("10A"), new Seat("10B"))));
        flightService.addFlight(flight1);

        //search and booking
        User user=userService.getUser("u1");
        List<Flight> flights=flightService.searchFlight("DEL","BEL",2,1);
        if(!flights.isEmpty()) {
            Flight flight=flights.get(0);
            Fare fare=flight.getFare("F1");
            List<Seat> seats=fare.getAvailableSeats(1);
            if(seats!=null) {
                System.out.println(bookingService.bookFlight(user,flight, fare,seats));
            }
        }

        //getuserbooking
        System.out.println(bookingService.getUserBooking("u1"));
        System.out.println(bookingService.getUserBooking("u2"));

        //cancel
//        System.out.println(bookingService.cancelBooking("u1","B1"));
    }
}