public class Freighter extends Aircraft implements CargoCapable {
    private int cargoCapacity;

    public Freighter(String model, String name, int tailNumber, int cargoCapacity) {
        super(model, name, tailNumber);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public int getCargoCapacity(){
        return cargoCapacity;
    }

    @Override
    public String toString() {
        return "Freighter{" +
                "cargoCapacity=" + cargoCapacity +
                '}';
    }
}
