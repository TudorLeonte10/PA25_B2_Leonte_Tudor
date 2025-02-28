import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Pune java Main n k ");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        if (n < 2 * k || k < 2) {
            System.out.println("Trebuie n >= 2 * k si n > 2");
            return;
        }

        long startTime = System.nanoTime();

        int[][] matrix = new int[n][n];
        Random random = new Random();

        Set<Integer> cliqueVertices = new HashSet<>();
        while (cliqueVertices.size() < k) {
            cliqueVertices.add(random.nextInt(n));
        }

        for (int u : cliqueVertices) {
            for (int v : cliqueVertices) {
                if (u != v) {
                    matrix[u][v] = 1;
                    matrix[v][u] = 1;
                }
            }
        }

        System.out.println("Clica: " + cliqueVertices);

        List<Integer> remainingVertices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!cliqueVertices.contains(i)) {
                remainingVertices.add(i);
            }
        }

        Set<Integer> stableSetVertices = new HashSet<>();
        while (stableSetVertices.size() < k) {
            int index = random.nextInt(remainingVertices.size());
            stableSetVertices.add(remainingVertices.get(index));
        }

        for (int u : stableSetVertices) {
            for (int v : stableSetVertices) {
                matrix[u][v] = 0;
                matrix[v][u] = 0;
            }
        }

        System.out.println("Multimea stabila: " + stableSetVertices);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!cliqueVertices.contains(i) && !cliqueVertices.contains(j) &&
                        !stableSetVertices.contains(i) && !stableSetVertices.contains(j)) {
                    matrix[i][j] = random.nextInt(2);
                    matrix[j][i] = matrix[i][j];
                }
            }
        }

        int count = 0;
        int degree, ξ = n, Δ = 0;

        if (n < 30000) {
            String prettyMatrix = buildMatrixString(matrix);
            System.out.println("Matrix pretty:");
            System.out.println(prettyMatrix);

            for (int i = 0; i < n; i++) {
                degree = 0;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        count++;
                        degree++;
                    }
                }
                if (ξ > degree) ξ = degree;
                if (Δ < degree) Δ = degree;
            }
            System.out.println("Nr de muchii: " + count / 2);
            System.out.println("Grad minim: " + ξ);
            System.out.println("Grad maxim: " + Δ);
        } else {
            for (int i = 0; i < n; i++) {
                degree = 0;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        count++;
                        degree++;
                    }
                }
                if (ξ > degree) ξ = degree;
                if (Δ < degree) Δ = degree;
            }
            System.out.println("Nr de muchii: " + count / 2);
            System.out.println("Grad minim: " + ξ);
            System.out.println("Grad maxim: " + Δ);
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Timp de rulare: " + duration + " ms");
    }

    public static String buildMatrixString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int cell : row) {
                sb.append(cell == 1 ? "!" : "#").append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
