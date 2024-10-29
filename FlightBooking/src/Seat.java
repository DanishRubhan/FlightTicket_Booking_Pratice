public class Seat {
    private String seatNumber;
    private boolean isBooked;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book() {
        this.isBooked=true;
    }

    public void release() {
        this.isBooked=false;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", isBooked=" + isBooked +
                '}';
    }
}
