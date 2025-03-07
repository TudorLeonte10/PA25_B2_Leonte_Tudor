public class Problem {/** Leonte Calin **/
Student[] students;
    Teacher[] teachers;
    Project[] projects;

    public Problem (Student[] students, Teacher[] teachers, Project[] projects){
        this.students = students;
        this.teachers = teachers;
        this.projects = projects;

        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].equals(students[j])) {
                    throw new IllegalArgumentException("Există deja un student cu registrationNumber " + students[i].getRegNumber());
                }
            }
        }

        for (int i = 0; i < teachers.length; i++) {
            for (int j = i + 1; j < teachers.length; j++) {
                if (teachers[i].equals(teachers[j])) {
                    throw new IllegalArgumentException("Există deja un profesor cu aceleași date.");
                }
            }
        }

        for (int i = 0; i < projects.length; i++) {
            for (int j = i + 1; j < projects.length; j++) {
                if (projects[i].equals(projects[j])) {
                    throw new IllegalArgumentException("Există deja un proiect cu acelasi titlu si tip.");
                }
            }
        }

    }

    public Person[] getAllPersons() {
        Person[] allPersons = new Person[students.length + teachers.length];
        int contor = 0;
        for (Student student : students) {
            allPersons[contor] = student;
            contor++;
        }
        for (Teacher teacher : teachers) {
            allPersons[contor] = teacher;
            contor++;
        }
        return allPersons;
    }
}
