
import java.util.*;
// java.util package madhil utility classes import karto.
// Ya program madhye directly utility class vaprali nahi.
// Pan original code madhye aahe mhanun tasach thevla aahe.

class FractionalKnapsack {
    // FractionalKnapsack navacha class create kela.
    // Ya class madhye Greedy algorithm implement kela aahe.
    // Fractional mhanje item cha kahi part suddha select karu shakto.

    public static void main(String[] args) {
        // main() method pasun program execution suru hote.
        // public = method baherun access karta yeto.
        // static = object create na karta main() run hote.
        // void = kontihi value return karat nahi.
        // String[] args = command-line arguments sathi vapartat.

        int n = 3;
        // n mhanje total number of items.
        // Ya example madhye aaplyakade 3 items aahet.

        int capacity = 50;
        // capacity mhanje knapsack (bag) chi maximum weight limit.
        // Ya bag madhye maximum 50 kg weight thevu shakto.
        // Items select hotana remaining capacity kami hot jate.

        int[] weight = {10, 20, 30};
        // weight navacha integer array create kela.
        // Item 1 = 10 kg
        // Item 2 = 20 kg
        // Item 3 = 30 kg

        int[] profit = {60, 100, 120};
        // Pratyek item cha profit store kela.
        // Item 1 = Rs.60
        // Item 2 = Rs.100
        // Item 3 = Rs.120

        double totalProfit = 0;
        // Selected items cha total profit store karnyasathi variable.
        // double vaparla karan fractional item mule decimal profit yeu shakto.
        // Suruvatila profit 0 aahe.

        // Calculate profit/weight ratio
        // Pratyek item cha profit per kg calculate karaycha.
        // Formula: Ratio = Profit / Weight

        double[] ratio = new double[n];
        // ratio navacha double array create kela.
        // Size n = 3 aahe.
        // Pratyek item cha profit-to-weight ratio store honar.

        for (int i = 0; i < n; i++) {
            // Loop saglya items var ek-ek karun chalto.
            // i = 0 pasun suruvat hote.
            // i < n mhanje 3 items check hotil.
            // i++ mule pratyek iteration nantar i ekane vadhato.

            ratio[i] = (double) profit[i] / weight[i];
            // Current item cha profit / weight calculate karto.
            // (double) mule division decimal precision madhye hote.
            // Item 1: 60 / 10 = 6
            // Item 2: 100 / 20 = 5
            // Item 3: 120 / 30 = 4
            // Final ratio array = {6.0, 5.0, 4.0}

        }

        // Sort items according to highest ratio
        // Items descending order of profit/weight ratio madhye sort karto.
        // Highest ratio aslela item aadhi select karaycha.
        // Hach Greedy method cha main concept aahe.

        for (int i = 0; i < n - 1; i++) {
            // Outer loop sorting sathi vaparla aahe.
            // i = current item chi position.
            // n - 1 mhanje last item paryant comparisons karaychi garaj nahi.

            for (int j = i + 1; j < n; j++) {
                // Inner loop current item chi pudhchya items sobat comparison karto.
                // j = i + 1 mhanje next item pasun suruvat.
                // j++ mule next item check karto.

                if (ratio[i] < ratio[j]) {
                    // Jar pudhchya item cha ratio current peksha jast asel,
                    // tar donhi items swap karayche.
                    // Yane higher ratio aslela item aadhi yeto.

                    double temp = ratio[i];
                    // Current ratio temporary variable madhye save karto.

                    ratio[i] = ratio[j];
                    // Higher ratio current position var anto.

                    ratio[j] = temp;
                    // Old ratio next position var thevto.
                    // Ya 3 statements mule ratio swap hoto.

                    int tempW = weight[i];
                    // Current item cha weight temporarily save karto.

                    weight[i] = weight[j];
                    // Next item cha weight current position var anto.

                    weight[j] = tempW;
                    // Old weight next position var thevto.
                    // Ratio sobat weight swap karne garjeche aahe,
                    // nahitar item cha ratio ani weight mismatch hoil.

                    int tempP = profit[i];
                    // Current item cha profit temporarily save karto.

                    profit[i] = profit[j];
                    // Next item cha profit current position var anto.

                    profit[j] = tempP;
                    // Old profit next position var thevto.
                    // Ratio, weight ani profit ekatra swap kele pahijet.
                    // Mhanje pratyek item chi correct information maintain hote.

                }
            }
        }
        // Sorting complete zali.
        // Ya example madhye ratios already 6, 5, 4 aahet.
        // Mhanun actual swapping hot nahi.

        // Select items
        // Ata highest ratio pasun items bag madhye select karayche.

        for (int i = 0; i < n; i++) {
            // Pratyek item ek-ek karun consider karto.
            // Sorted order mule highest profit/weight ratio item aadhi yeto.

            if (capacity >= weight[i]) {
                // Bag madhye current item purnapane basu shakto ka te check karto.
                // Jar remaining capacity item weight peksha jast kiwa equal asel,
                // tar complete item select karto.

                capacity = capacity - weight[i];
                // Selected item cha weight remaining capacity madhun subtract karto.
                // Example: 50 - 10 = 40 kg capacity remaining.
                // Next item select kelyavar 40 - 20 = 20 kg remaining.

                totalProfit = totalProfit + profit[i];
                // Full item select zalyamule tyacha complete profit add karto.
                // Item 1 select: totalProfit = 0 + 60 = 60.
                // Item 2 select: totalProfit = 60 + 100 = 160.

                System.out.println("Full item selected: " + weight[i] + " kg");
                // Complete item select zala he output var print karto.
                // Tyasobat selected item cha weight display karto.

            } else {
                // Jar complete item bag madhye basat nasel,
                // tar item cha fraction (part) select karto.
                // Fractional Knapsack madhye he allowed aahe.

                double fraction =  (double) capacity / weight[i];
                // Kiti part select karta yeil te calculate karto.
                // Formula: Fraction = Remaining Capacity / Item Weight
                // Example: capacity = 20 kg, item weight = 30 kg.
                // fraction = 20 / 30 = 0.666666...
                // Mhanje item cha approximately 66.67% part select honar.

                totalProfit = totalProfit + profit[i] * fraction;
                // Fraction nusar item cha proportional profit calculate karto.
                // Item 3 cha full profit = Rs.120.
                // Fractional profit = 120 * (20 / 30) = Rs.80.
                // totalProfit = 160 + 80 = Rs.240.

                System.out.println("Fraction selected: " + (fraction * 100) + "%");
                // Fraction la percentage madhye convert karto.
                // fraction * 100 = approximately 66.67%.
                // Selected percentage output var print karto.

                capacity = 0;
                // Fraction select kelyanantar bag full zali.
                // Mhanun remaining capacity 0 karto.

                break;
                // Bag full zalyamule pudhche items check karaychi garaj nahi.
                // break mule selection loop stop hoto.

            }
        }

        System.out.println("Maximum Profit = ₹" + totalProfit);
        // Shevti bag madhye select kelelya items cha total profit print karto.
        // Ya example madhye maximum profit = Rs.240.0.

    }
}
