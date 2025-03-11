import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String name;
    private List<String> runways;

    public Airport(String name, int runwaysCount) {
        this.name = name;
        this.runways = new ArrayList<>();

        for(int i = 1; i<=runwaysCount; i++){
            runways.add("Flight" + i);
        }
    }

    public List<String> getRunways() {
        return runways;
    }
}
