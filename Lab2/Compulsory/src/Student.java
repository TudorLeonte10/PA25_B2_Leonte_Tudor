import java.util.List;

public class Student {
    private String name;
    private Project[] okProjects;

public Student(String name, Project[] okProjects){
    this.name = name;
    this.okProjects = okProjects;
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project[] getOkProjects() {
        return okProjects;
    }

    public void setOkProjects(Project[] okProjects) {
        this.okProjects = okProjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", okProjects=" + okProjects +
                '}';
    }
}
