import java.util.*;

class FractionalKnapsack {

    public static void main(String[] args) {

        int n = 3;

        int capacity = 50;

        int[] weight = {10, 20, 30};

        int[] profit = {60, 100, 120};

        double totalProfit = 0;

        // Calculate profit/weight ratio

        double[] ratio = new double[n];

        for (int i = 0; i < n; i++) {

            ratio[i] = (double) profit[i] / weight[i];

        }

        // Sort items according to highest ratio

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (ratio[i] < ratio[j]) {

                    double temp = ratio[i];

                    ratio[i] = ratio[j];

                    ratio[j] = temp;

                    int tempW = weight[i];

                    weight[i] = weight[j];

                    weight[j] = tempW;

                    int tempP = profit[i];

                    profit[i] = profit[j];

                    profit[j] = tempP;

                }

            }

        }

        // Select items

        for (int i = 0; i < n; i++) {

            if (capacity >= weight[i]) {

                capacity = capacity - weight[i];

                totalProfit = totalProfit + profit[i];

                System.out.println("Full item selected: " + weight[i] + " kg");

            } else {

                double fraction =  (double) capacity / weight[i];

                totalProfit = totalProfit + profit[i] * fraction;

                System.out.println("Fraction selected: " + (fraction * 100) + "%");

                capacity = 0;

                break;

            }

        }

        System.out.println("Maximum Profit = ₹" + totalProfit);

    }

}

