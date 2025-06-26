package dsAlgo.medium.heap;

import java.util.Arrays;

/**
 * A busy investor with an initial capital, c, needs an automated investment program. They can select k distinct projects from a list of n projects with corresponding capitals requirements and expected profits. For a given project ii, its capital requirement is capitals[i]capitals[i] , and the profit it yields is profits[i]profits[i].
 *
 * The goal is to maximize their cumulative capital by selecting a maximum of k distinct projects to invest in, subject to the constraint that the investor’s current capital must be greater than or equal to the capital requirement of all selected projects.
 *
 * When a selected project from the identified ones is finished, the pure profit from the project, along with the starting capital of that project is returned to the investor. This amount will be added to the total capital held by the investor. Now, the investor can invest in more projects with the new total capital. It is important to note that each project can only be invested once.
 *
 * As a basic risk-mitigation measure, the investor wants to limit the number of projects they invest in. For example, if k is 22, the program should identify the two projects that maximize the investor’s profits while ensuring that the investor’s capital is sufficient to invest in the projects.
 *
 * Overall, the program should help the investor to make informed investment decisions by picking a list of a maximum of k distinct projects to maximize the final profit while mitigating the risk.
 *
 * Constraints:
 *
 *     1≤1≤ k ≤103≤103
 *     0≤0≤ c ≤109≤109
 *     1≤1≤ n ≤103≤103
 *     k ≤≤ n
 *     n ==== profits.length
 *     n ==== capitals.length
 *     0≤0≤ profits[i] ≤104≤104
 *     0≤0≤ capitals[i] ≤109≤10
 */
public class MaximizeCapital {

    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        return -1;
    }

        public static void main(String[] args) {
        int[] c = { 0, 1, 2, 1, 7, 2 };
        int[] k = { 1, 2, 3, 3, 2, 4 };
        int[][] capitals = {
                { 1, 1, 2 },
                { 1, 2, 2, 3 },
                { 1, 3, 4, 5, 6 },
                { 1, 2, 3, 4 },
                { 6, 7, 8, 10 },
                { 2, 3, 5, 6, 8, 12 }
        };
        int[][] profits = {
                { 1, 2, 3 },
                { 2, 4, 6, 8 },
                { 1, 2, 3, 4, 5 },
                { 1, 3, 5, 7 },
                { 4, 8, 12, 14 },
                { 1, 2, 5, 6, 8, 9 }
        };

        for (int i = 0; i < k.length; i++) {
            System.out.println((i + 1) + ".\tProject capital requirements: " + Arrays.toString(capitals[i]));
            System.out.println("\tProject expected profits: " + Arrays.toString(profits[i]));
            System.out.println("\tNumber of projects: " + k[i]);
            System.out.println("\tStart-up capital: " + c[i]);
            System.out.println("\n\tMaximum Capital earned: " + maximumCapital(c[i], k[i], capitals[i], profits[i]));
        }
    }
}
