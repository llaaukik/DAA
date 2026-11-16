import java.util.*;

public class JobSequencing {

    public static void main(String[] args) {
        char[] job = {'A', 'B', 'C', 'D', 'E'};
        int[] deadline = {2, 1, 2, 1, 3};
        int[] profit = {100, 19, 27, 25, 15};

        for (int i = 0; i < job.length - 1; i++) {
            for (int j = i + 1; j < job.length; j++) {
                if (profit[i] < profit[j]) {
                    int temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;

                    temp = deadline[i];
                    deadline[i] = deadline[j];
                    deadline[j] = temp;

                    char c = job[i];
                    job[i] = job[j];
                    job[j] = c;
                }
            }
        }

        char[] result = new char[3];
        boolean[] used = new boolean[3];

        int totalProfit = 0;

        for (int i = 0; i < job.length; i++) {

            for (int j = deadline[i] - 1; j >= 0; j--) {
                if (used[j] == false) {
                    result[j] = job[i];
                    used[j] = true;
                    totalProfit = totalProfit + profit[i];
                    break;
                }
            }
        }

        System.out.println("Job Sequence:");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("\nTotal Profit = " + totalProfit);
    }
}

