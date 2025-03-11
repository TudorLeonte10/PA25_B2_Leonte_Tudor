public abstract class Aircraft implements Comparable<Aircraft>{
    protected String model;
    protected String name;
    private int tailNumber;

    public Aircraft(String model, String name, int tailNumber){
        this.model = model;
        this.name = name;
        this.tailNumber = tailNumber;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", tailNumber=" + tailNumber +
                '}';
    }

    @Override
    public int compareTo(Aircraft aircraft){
        return this.name.compareTo(aircraft.name);
    }
}
