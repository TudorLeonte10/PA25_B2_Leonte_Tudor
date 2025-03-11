import java.time.LocalTime;

public class Flight {
    private String flightId;
    private LocalTime landingStart;
    private LocalTime landingEnd;

    public Flight(String flightId, LocalTime landingStart, LocalTime landingEnd) {
        this.flightId = flightId;
        this.landingStart = landingStart;
        this.landingEnd = landingEnd;
    }

    public boolean isInConflict(Flight flight){
        return !(this.landingEnd.isBefore(flight.landingStart) || this.landingStart.isAfter(flight.landingEnd));
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public LocalTime getLandingStart() {
        return landingStart;
    }
}
