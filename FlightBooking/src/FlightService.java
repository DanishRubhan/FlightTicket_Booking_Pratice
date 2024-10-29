import java.util.*;

public class FlightService {
    private Map<String, Flight> flights=new HashMap<>();

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber() , flight);
    }

    public Flight getFlight(String flightNumber) {
        return flights.get(flightNumber);
    }

    public List<Flight> searchFlight(String from, String to, int departDate, int paxCount) {
        List<Flight> result=new ArrayList<>();
        for(Flight flight:flights.values()) {
            if(flight.getDepartDate()==departDate && flight.getFrom().equals(from) && flight.getTo().equals(to)) {
                result.add(flight);
            }
        }
        return result;
    }

    public List<Flight> searchFlightByPreferredAirline(String from, String to, int departDate, int paxCount,String sortBy, String sortType) {
        List<Flight> result=new ArrayList<>();
        for(Flight flight:flights.values()) {
            if(flight.getDepartDate()==departDate && flight.getFrom().equals(from) && flight.getTo().equals(to)) {
                result.add(flight);
                if(sortBy=="PRICE" && sortType=="ASC") {
                    Collections.sort(result, new Comparator<Flight>() {
                        @Override
                        public int compare(Flight f1, Flight f2) {
                            return (int) (f1.getFare("F1").getPrice() - f2.getFare("F1").getPrice());
                        }
                    });
                }
            }
        }
        return result;
    }


}
