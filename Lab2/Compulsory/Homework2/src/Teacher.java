import java.util.Arrays;

public class Teacher extends Person{
    private Project[] proposedProjects;

    public Teacher(String name, String dateOfBirth, Project[] proposedProjects){
        super(name,dateOfBirth);
        this.proposedProjects = proposedProjects;
    }

    public Project[] getProposedProjects() {
        return proposedProjects;
    }

    public void setProposedProjects(Project[] proposedProjects) {
        this.proposedProjects = proposedProjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "proposedProjects=" + Arrays.toString(proposedProjects) +
                '}';
    }

}