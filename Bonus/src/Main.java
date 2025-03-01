import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static int[][] generateRandomGraph(int n) {
        Random random = new Random();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = random.nextBoolean() ? 1 : 0;
                matrix[j][i] = matrix[i][j];
            }
        }
        return matrix;
    }

    public static int[][] complementGraph(int[][] matrix) {
        int n = matrix.length;
        int[][] complement = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    complement[i][j] = 1 - matrix[i][j]; // Inversăm muchiile (0 → 1, 1 → 0)
                }
            }
        }
        return complement;
    }

    public static boolean isClique(List<Integer> subset, int[][] matrix) {
        for (int i = 0; i < subset.size(); i++) {
            for (int j = i + 1; j < subset.size(); j++) {
                if (matrix[subset.get(i)][subset.get(j)] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean findClique(int[][] matrix, List<Integer> current, int start, int k) {
        if (current.size() >= k && isClique(current, matrix)) {
            return true;
        }

        for (int i = start; i < matrix.length; i++) {
            current.add(i);
            if (findClique(matrix, current, i + 1, k)) {
                return true;
            }
            current.remove(current.size() - 1);
        }
        return false;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("java Main n k");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        if (n < k || k < 2) {
            System.out.println("Avem grijă ca n >= k >= 2.");
            return;
        }

        int[][] matrix = generateRandomGraph(n);
        System.out.println("Matricea de adiacenta:");
        printMatrix(matrix);

        boolean hasClique = findClique(matrix, new ArrayList<>(), 0, k);
        System.out.println(hasClique
                ? "Graful conține o clica de cel puțin " + k + " noduri."
                : "Graful nu contine o clica de cel puțin " + k + " noduri.");

        int[][] complement = complementGraph(matrix);
        System.out.println("Complementul grafului:");
        printMatrix(complement);

        boolean hasStableSet = findClique(complement, new ArrayList<>(), 0, k);
        if(hasStableSet){
            System.out.println("Graful contine un set stabil de cel putin " + k + " noduri.");
        }
        else
            System.out.println("Graful nu contine un set stabil de cel putin " + k + " noduri.");
    }
}
