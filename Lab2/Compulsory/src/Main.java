import java.util.List;

enum Type{
    THEORETICAL,
    PRACTICAL
}

public class Main {
    public static void main(String[] args) {
        Project p1 = new Project(".NetApp", Type.PRACTICAL);
        Project p2 = new Project("AI Bot", Type.PRACTICAL);
        Project p3 = new Project("Essay", Type.THEORETICAL);
        Project p4 = new Project("Documentation", Type.THEORETICAL);

        Student s1 = new Student("Tudor", new Project[]{p1,p2});
        Student s2 = new Student("Calin", new Project[]{p1,p3});
        Student s3 = new Student("Robert", new Project[]{p3,p4});
        Student s4 = new Student("Agnes", new Project[]{p1,p4});

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}