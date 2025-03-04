

public class Project {
    private String name;
    private Type type;

    public Project(String name, Type type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
