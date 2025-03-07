
enum Type{
    theoretical, practical
}

public class Main { /** Leonte Calin **/
public static void main(String[] args) {

    Project p1 = new Project("QuizzGame", Type.theoretical);
    Project p2 = new Project("Championship", Type.practical);
    Project p3 = new Project("TrainsApp", Type.theoretical);
    Project p4 = new Project("DerivateCalculator", Type.practical);
    Project p5 = new Project("DerivateCalculator", Type.theoretical);

    Teacher t1 = new Teacher("Sabin Buraga", "1975-05-21", new Project[]{p1, p2});
    Teacher t2 = new Teacher("Ferucio Tiplea", "1980-11-13", new Project[]{p3, p4});
    Teacher t3 = new Teacher("Mihaela Breaban", "1975-05-21", new Project[]{p5});
    Teacher t4 = new Teacher("Lenuta Alboaie", "1980-11-13", new Project[]{p1, p3, p2});

    Student s1 = new Student("Niko", "2004-04-21", new Project[]{p1, p2}, 1);
    Student s2 = new Student("Niku", "2004-04-21", new Project[]{p1, p2}, 2);
    Student s3 = new Student("Jimmy", "2004-06-21", new Project[]{p2, p3, p4}, 3);
    Student s4 = new Student("Mzinho", "2004-02-20", new Project[]{p2, p5}, 4);
    Student s5 = new Student("Xantares", "2004-01-11", new Project[]{p4}, 5);

    Problem problem = new Problem(new Student[]{s1,s2,s3,s4,s5}, new Teacher[]{t1,t2,t3,t4}, new Project[]{p1,p2,p3,p4,p5});
    Person[] peopleList = problem.getAllPersons();
    for (Person p : peopleList)
        System.out.println(p.name);
    Solution.allocateProjects(problem);

}
}
