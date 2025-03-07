public class Solution { 
    public static void allocateProjects(Problem problem) {
        boolean[] allocatedProjects = new boolean[problem.projects.length];
        String[] allocations = new String[problem.students.length];

        for (int i = 0; i < problem.students.length; i++) {
            for (Project preferredProject : problem.students[i].availableProjects) {
                for (int j = 0; j < problem.projects.length; j++) {
                    if (problem.projects[j].equals(preferredProject) && !allocatedProjects[j]) {
                        allocations[i] = problem.students[i].name + " va face proiectul " + problem.projects[j].title;
                        allocatedProjects[j] = true;
                        break;
                    }
                }
                if (allocations[i] != null) break;
            }
        }

        for (String allocation : allocations) {
            if (allocation != null)
                System.out.println(allocation);
        }
    }
}
