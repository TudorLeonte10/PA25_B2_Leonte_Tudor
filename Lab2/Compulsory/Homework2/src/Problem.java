
public class Problem {
    private Project[] projects;
    private Student[] students;
    private int projCount;
    private int studCount;

    public Problem(Project[] projects, Student[] students){
        this.projects = projects;
        this.students = students;
    }

    public void addStudent(Student student){
        for(int i = 0; i < studCount; i++) {
            if (students[i].equals(student)) {
                System.out.println("Student" + student.getName() + "exists");
                return;
            }
        }
        students[studCount++] = student;
    }

    public void addProject(Project project){
        for(int i = 0; i < projCount; i++) {
            if (projects[i].equals(project)) {
                System.out.println("Project" + project.getName() + "exists");
                return;
            }
        }
        projects[projCount++] = project;
    }

    public Person[] getAllPersonsInvolved(){
        Person[] persons = new Person[studCount + projCount];
        for (int i = 0; i < studCount; i++) {
            persons[i] = students[i];
        }
        return persons;
    }

}
