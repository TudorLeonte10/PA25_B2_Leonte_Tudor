import jdk.jfr.Frequency;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Student extends Person{ /** Leonte Calin **/
Project[] availableProjects;
    private int regNumber;

    public Student (String name, String birthDate, Project[] projects, int regNumber)
    {
        super(name, birthDate);
        availableProjects = projects;
        this.regNumber = regNumber;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return regNumber == student.regNumber;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }
}
