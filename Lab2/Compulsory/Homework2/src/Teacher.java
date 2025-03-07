import java.util.Arrays;
import java.util.Date;

public class Teacher extends Person { /** Leonte Calin **/
private Project[] proposedProjects;

    public Teacher(String name, String birthDate, Project[] projects) {
        super(name, birthDate);
        proposedProjects = projects;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        Teacher teacher = (Teacher) obj;
        return Arrays.equals(((Teacher) obj).proposedProjects, proposedProjects);
    }
}
