import java.util.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

public class Main {

    public static Map<Integer, Set<Integer>> generateRandomGraph(int numStudents, int numProjects, int maxChoicesPerStudent) {
        Random random = new Random();
        Map<Integer, Set<Integer>> preferences = new HashMap<>();

        for (int student = 0; student < numStudents; student++) {
            int numChoices = random.nextInt(maxChoicesPerStudent) + 1;
            Set<Integer> projects = new HashSet<>();
            while (projects.size() < numChoices) {
                projects.add(random.nextInt(numProjects));
            }
            preferences.put(student, projects);
        }
        return preferences;
    }

    public static boolean hallConditionCheck(Map<Integer, Set<Integer>> preferences, int numStudents) {
        List<Integer> students = new ArrayList<>(preferences.keySet());

        for (int size = 1; size <= numStudents; size++) {
            List<List<Integer>> subsets = getSubsets(students, size);

            for (List<Integer> subset : subsets) {
                Set<Integer> coveredProjects = new HashSet<>();
                for (int student : subset) {
                    coveredProjects.addAll(preferences.get(student));
                }
                if (coveredProjects.size() < subset.size()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<List<Integer>> getSubsets(List<Integer> students, int size) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(students, new ArrayList<>(), 0, size, subsets);
        return subsets;
    }

    private static void generateSubsets(List<Integer> students, List<Integer> current, int index, int size, List<List<Integer>> subsets) {
        if (current.size() == size) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < students.size(); i++) {
            current.add(students.get(i));
            generateSubsets(students, current, i + 1, size, subsets);
            current.remove(current.size() - 1);
        }
    }

    public static void measurePerformance(int numStudents, int numProjects, int maxChoicesPerStudent) {
        long startTime = System.nanoTime();
        MemoryUsage heapBefore = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();

        Map<Integer, Set<Integer>> preferences = generateRandomGraph(numStudents, numProjects, maxChoicesPerStudent);

        boolean feasible = hallConditionCheck(preferences, numStudents);

        long endTime = System.nanoTime();
        MemoryUsage heapAfter = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();

        double executionTime = (endTime - startTime) / 1e6; // Convert to milliseconds
        double memoryUsed = (heapAfter.getUsed() - heapBefore.getUsed()) / (1024.0 * 1024.0); // Convert to MB

        System.out.println("Se poate face matching: " + feasible);
        System.out.println("Timp de executie: " + executionTime + " ms");
        System.out.println("Memorie utilizata: " + memoryUsed + " MB");
    }

    public static void main(String[] args) {
        int numStudents = 10;
        int numProjects = 10;
        int maxChoicesPerStudent = 5;

        measurePerformance(numStudents, numProjects, maxChoicesPerStudent);
    }
}
