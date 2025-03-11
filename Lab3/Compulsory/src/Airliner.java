public class Airliner extends Aircraft implements PassangerCapable{
    private int passangerCapacity;

    public Airliner(String name, String model, int tailNumber, int passangerCapacity){
        super(name,model,tailNumber);
        this.passangerCapacity = passangerCapacity;
    }

    @Override
    public int getPassangerCapacity() {
        return passangerCapacity;
    }

    @Override
    public String toString() {
        return "Airliner{" +
                "passangerCapacity=" + passangerCapacity +
                '}';
    }
}
