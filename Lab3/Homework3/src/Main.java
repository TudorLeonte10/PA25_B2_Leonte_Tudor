import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Airport airport = new Airport("IasiAirport", 3 );

        Flight flight1 = new Flight("A123", LocalTime.of(10, 0), LocalTime.of(10, 30));
        Flight flight2 = new Flight("B456", LocalTime.of(10, 15), LocalTime.of(10, 45));
        Flight flight3 = new Flight("C789", LocalTime.of(11, 0), LocalTime.of(11, 30));
        Flight flight4 = new Flight("D101", LocalTime.of(10, 40), LocalTime.of(11, 10));
        Flight flight5 = new Flight("E202", LocalTime.of(11, 20), LocalTime.of(11, 50));

        Schedule problem = new Schedule(airport);

        problem.addFlight(flight1);
        problem.addFlight(flight2);
        problem.addFlight(flight3);
        problem.addFlight(flight4);
        problem.addFlight(flight5);

        problem.solve();
        problem.printSol();
    }
}
