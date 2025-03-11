import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Airliner a = new Airliner("Lufthansa", "Boeing737" , 123, 250);
        Freighter f = new Freighter("Airbus2" , "Wizz", 234, 1000);
        Drone d = new Drone("Tesla" , "V200" , 345, 100);

        List<CargoCapable> cargoPlanes = new ArrayList<>();
        if(f instanceof CargoCapable)
            cargoPlanes.add(f);
        if(d instanceof CargoCapable)
            cargoPlanes.add(d);

        System.out.println("Avioanele care pot cara marfa:");
        for(CargoCapable aircraft: cargoPlanes){
            System.out.println(aircraft);
        }
    }
}