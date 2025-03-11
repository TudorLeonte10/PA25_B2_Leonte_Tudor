import java.util.*;

public class Schedule {
    private Airport airport;
    private HashSet<Flight> flightSet;
    private Map<Flight, String> schedule;

    public Schedule(Airport airport) {
        this.airport = airport;
        this.flightSet = new HashSet<>();
        this.schedule = new HashMap<>();
    }

    public void addFlight(Flight f){
        flightSet.add(f);
    }

    public void solve(){
        List<Flight> flights = new ArrayList<>();
        flights.addAll(flightSet);

        flights.sort(Comparator.comparing(Flight::getLandingStart));


        for(Flight flight : flights){
            boolean assigned = false;
            for (String runway : airport.getRunways()){
                boolean conflict = false;

                for(Map.Entry<Flight, String> entry : schedule.entrySet()){
                    if(entry.getValue().equals(runway)  && entry.getKey().isInConflict(flight)){
                        conflict = true;
                        break;
                    }
                }
            if(!conflict){
                schedule.put(flight, runway);
                assigned = true;
                break;
            }
            }

            if (!assigned) {
                System.out.println("No available runway for flight: " + flight.getFlightId());
            }
        }
    }

    public void printSol(){
        for(Map.Entry<Flight, String> entry : schedule.entrySet()){
            System.out.println(entry.getKey().getFlightId() + "->" + entry.getValue());
        }
    }
}
