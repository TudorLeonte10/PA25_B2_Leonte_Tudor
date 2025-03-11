public class Drone extends Aircraft implements CargoCapable{
    private int batteryLife;

    public Drone(String name, String model, int tailNumber, int batteryLife){
        super(name, model, tailNumber);
        this.batteryLife = batteryLife;
    }

    @Override
    public int getCargoCapacity(){
        return 500;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "batteryLife=" + batteryLife +
                '}';
    }
}
