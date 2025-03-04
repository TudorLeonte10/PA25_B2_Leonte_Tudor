import java.util.Date;
import java.util.List;

public class Student extends Person{
    private Integer regNumber;
    private Project[] okProjects;

    public Student(String name, Integer regNumber, String dateOfBirth, Project[] okProjects){
        super(name, dateOfBirth);
        this.regNumber = regNumber;
        this.okProjects = okProjects;
    }

    public Integer getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Integer regNumber) {
        this.regNumber = regNumber;
    }

    public Project[] getOkProject() {
        return okProjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNumber=" + regNumber +
                "project=" + okProjects +
                '}';
    }
}
