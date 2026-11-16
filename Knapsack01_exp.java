
import java.util.Scanner;
// Scanner class import keli aahe.
// Karan aaplyala user kadun keyboard varun input ghyaycha aahe.

public class Knapsack01 {
    // Knapsack01 navacha public class create kela.
    // Ya class madhye 0/1 Knapsack problem solve karnaar aahot.
    // 0/1 mhanje item select karaycha (1) kiwa nahi (0).
    // Item cha fraction gheta yet nahi.

    public static void main(String[] args) {
        // main() method pasun program execution suru hote.
        // public = method baherun access karta yeto.
        // static = object create na karta method run hote.
        // void = method kontihi value return karat nahi.
        // String[] args = command-line arguments sathi.

        Scanner sc = new Scanner(System.in);
        // sc navacha Scanner object create kela.
        // System.in mule keyboard varun input gheta yeto.

        // Read number of items
        System.out.print("Enter number of items: ");
        // User la kiti items aahet te enter karayla sangto.
        // print() mule cursor same line var rahto.

        int n = sc.nextInt();
        // User ne enter kelela number n madhye store hoto.
        // Example: n = 4 mhanje total 4 items aahet.

        int[] weight = new int[n];
        // weight navacha integer array create kela.
        // Ya array madhye pratyek item cha weight store honar.
        // Array size n aahe, mhanje n items che weights store hotil.

        int[] profit = new int[n];
        // profit navacha integer array create kela.
        // Pratyek item cha profit ya array madhye store honar.

        // Read weights
        System.out.println("Enter weights of items:");
        // User la saglya items che weights enter karayla sangto.

        for (int i = 0; i < n; i++) {
            // Ha loop n vela execute hoto.
            // i = 0 pasun suruvat hote karan array indexing 0 pasun aste.
            // i < n mhanje last item paryant loop chalto.
            // i++ mule pratyek iteration nantar i ekane vadhato.

            weight[i] = sc.nextInt();
            // User ne enter kelela weight current index var store karto.
            // Example: weight = {2, 3, 4, 5}
        }

        // Read profits
        System.out.println("Enter profits of items:");
        // User la pratyek item cha profit enter karayla sangto.

        for (int i = 0; i < n; i++) {
            // Ha loop suddha n vela chalto.
            // Pratyek item cha profit ek-ek karun read karto.

            profit[i] = sc.nextInt();
            // User ne enter kelela profit array madhye store karto.
            // Example: profit = {3, 4, 5, 6}
        }

        // Read capacity
        System.out.print("Enter capacity of knapsack: ");
        // User la bag chi maximum capacity enter karayla sangto.

        int capacity = sc.nextInt();
        // Knapsack chi maximum weight limit capacity madhye store karto.
        // Example: capacity = 5 mhanje bag madhye maximum 5 kg thevu shakto.

        // Create DP table
        int[][] dp = new int[n + 1][capacity + 1];
        // dp navacha 2D integer array create kela.
        // DP mhanje Dynamic Programming.
        // Rows = n + 1, karan 0 items cha case suddha consider karto.
        // Columns = capacity + 1, karan capacity 0 pasun W paryant gheto.
        // dp[i][w] = first i items vaprun capacity w sathi maximum profit.
        // Java madhye int array chya saglya values initially 0 astat.
        // Mhanun dp[0][w] = 0 ani dp[i][0] = 0 initially astat.

        // Dynamic Programming
        for (int i = 1; i <= n; i++) {
            // Outer loop pratyek item consider karto.
            // i = 1 pasun suruvat karto karan 0 items cha row already 0 aahe.
            // i <= n mhanje sagle n items consider hotil.

            for (int w = 1; w <= capacity; w++) {
                // Inner loop pratyek possible capacity check karto.
                // w = 1 pasun maximum capacity paryant chalto.
                // Example: capacity = 5 asel tar w = 1, 2, 3, 4, 5.
                // Pratyek item sathi saglya capacities che answers calculate hotat.

                // Check if current item fits
                if (weight[i - 1] <= w) {
                    // Current item cha weight available capacity peksha
                    // kami kiwa equal aahe ka te check karto.
                    // i - 1 vaparla karan array indexing 0 pasun suru hote.
                    // Example: i = 1 tar first item weight[0] aahe.
                    // Item fit hot asel tar don choices available aahet:
                    // 1. Item select karne.
                    // 2. Item select na karne.

                    // Choose maximum of:
                    // 1. Including current item
                    // 2. Excluding current item

                    dp[i][w] = Math.max(
                            // Math.max() don values madhun mothi value return karto.
                            // Aaplyala maximum profit pahije mhanun vaparla aahe.

                            profit[i - 1]
                            // Current item select kelyavar milnara profit.
                            // i - 1 mhanje current item cha array index.

                            + dp[i - 1][w - weight[i - 1]],
                            // Current item select kelyavar remaining capacity:
                            // w - weight[i - 1]
                            // Ya remaining capacity madhye previous items vaprun
                            // milnara best profit add karto.
                            // i - 1 row vaparla karan current item
                            // punha select karaycha nahi.
                            // Example: current profit 4, remaining best profit 3.
                            // Include profit = 4 + 3 = 7.

                            dp[i - 1][w]
                            // Current item select nahi kela tar
                            // previous items madhun milnara best profit gheto.
                            // Capacity w same rahte.
                            // Ya value la exclude profit mhantat.
                    );
                    // Math.max(include profit, exclude profit)
                    // Donhi choices madhun maximum profit dp[i][w] madhye store hoto.

                } else {
                    // Jar current item cha weight available capacity peksha
                    // jast asel tar item bag madhye fit honar nahi.
                    // Mhanun current item select karu shakat nahi.

                    // Current item cannot fit
                    dp[i][w] = dp[i - 1][w];
                    // Current item skip karto.
                    // Previous row madhil same capacity cha best profit copy karto.
                    // Karan current item include karne possible nahi.
                }
            }
        }

        // Display maximum profit
        System.out.println("Maximum Profit = "
                + dp[n][capacity]);
        // dp[n][capacity] ha DP table cha final answer aahe.
        // n items ani full knapsack capacity consider kelyavar
        // milnara maximum possible profit print karto.
        // Example: dp[4][5] = 7.

        sc.close();
        // Scanner close karto.
        // Input resource vaprun zalyavar close karne good practice aahe.
    }
}
