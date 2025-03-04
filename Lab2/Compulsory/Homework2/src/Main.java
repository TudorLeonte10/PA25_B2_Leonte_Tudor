import java.util.List;

enum Type{
    THEORETICAL,
    PRACTICAL
}

public class Main {
    public static void main(String[] args) {
        Project p1 = new Project("A", Type.PRACTICAL);
        Project p2 = new Project("B", Type.PRACTICAL);
        Project p3 = new Project("C", Type.THEORETICAL);
        Project p4 = new Project("D", Type.THEORETICAL);

        Teacher t1 = new Teacher("Barjoveanu" , "23.04.1989", new Project[]{p2,p3});
        Teacher t2 = new Teacher("Captarencu" , "23.04.1989", new Project[]{p1,p4});
    }
}