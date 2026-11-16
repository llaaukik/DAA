
import java.util.*;
// java.util package madhlya classes import karto.
// Ya specific program madhye utility class vaprali nahi,
// pan original code madhye import aahe mhanun tasach thevla aahe.

public class JobSequencing {
    // JobSequencing ha class cha nav aahe.
    // Ya class madhye Greedy algorithm implement kela aahe.

    public static void main(String[] args) {
        // main() method pasun program execution suru hote.
        // public = method baherun access karta yeto.
        // static = object create na karta method execute hote.
        // void = method kontihi value return karat nahi.

        char[] job = {'A', 'B', 'C', 'D', 'E'};
        // job navacha character array create kela.
        // Ya array madhye 5 jobs aahet: A, B, C, D, E.
        // Pratyek job complete honyasathi 1 unit time lagto.

        int[] deadline = {2, 1, 2, 1, 3};
        // Pratyek job chi deadline store keli aahe.
        // Job A chi deadline 2 mhanje Slot 1 kiwa 2 madhye complete karaycha.
        // Job B chi deadline 1 mhanje fakt Slot 1 madhye complete karaycha.
        // Job E chi deadline 3 mhanje Slot 1, 2 kiwa 3 madhye karu shakto.

        int[] profit = {100, 19, 27, 25, 15};
        // Pratyek job complete kelyavar milnara profit store kela.
        // A = 100, B = 19, C = 27, D = 25, E = 15.
        // Greedy method madhye highest profit job la priority deto.

        // Sort jobs according to profit (highest first)
        // Jobs descending order of profit madhye sort karayche.
        // Mhanje jya job cha profit jast aahe to aadhi consider honar.

        for (int i = 0; i < job.length - 1; i++) {
            // Outer loop sorting sathi vaparla aahe.
            // i = current position.
            // job.length = 5, mhanun i chi range 0 te 3 aahe.

            for (int j = i + 1; j < job.length; j++) {
                // Inner loop pudhchya jobs sobat comparison karto.
                // j = i + 1 mhanje current job chya pudhchya position pasun.
                // j++ mule pratyek next job check hoto.

                if (profit[i] < profit[j]) {
                    // Jar pudhchya job cha profit current job peksha jast asel,
                    // tar donhi jobs chi positions swap karaychya.
                    // Yane highest profit job aadhi yeto.

                    int temp = profit[i];
                    // Current profit temporary variable madhye save karto.

                    profit[i] = profit[j];
                    // Higher profit current position var anto.

                    profit[j] = temp;
                    // Old profit pudhchya position var thevto.
                    // Ashya prakare don profit values swap hotat.

                    temp = deadline[i];
                    // Current job chi deadline temporary save karto.

                    deadline[i] = deadline[j];
                    // Pudhil job chi deadline current position var anto.

                    deadline[j] = temp;
                    // Old deadline pudhchya position var thevto.
                    // Profit sobat deadline swap karne garjeche aahe,
                    // nahitar job ani deadline cha sambandh chukel.

                    char c = job[i];
                    // Current job cha character temporary save karto.

                    job[i] = job[j];
                    // Higher profit aslelya job la current position var anto.

                    job[j] = c;
                    // Old job pudhchya position var thevto.
                    // Job, deadline ani profit he tinhi ekatra swap kele.

                }
            }
        }
        // Sorting nantar jobs cha order:
        // A(100), C(27), D(25), B(19), E(15).

        char[] result = new char[3];
        // Final selected jobs store karnyasathi result array create kela.
        // Size 3 aahe karan maximum deadline 3 aahe.
        // result[0] = Slot 1
        // result[1] = Slot 2
        // result[2] = Slot 3

        boolean[] used = new boolean[3];
        // Konta slot occupied aahe te check karnyasathi boolean array.
        // Suruvatila sarv values false astat.
        // false = slot empty.
        // true = slot occupied.

        int totalProfit = 0;
        // Selected jobs cha total profit calculate karnyasathi variable.
        // Suruvatila profit 0 aahe karan ajun job select zala nahi.

        // Select jobs
        // Ata sorted order madhun jobs select karayche.

        for (int i = 0; i < job.length; i++) {
            // Pratyek job ek-ek karun consider karto.
            // Highest profit job pasun selection suru hote.

            // Check slots from deadline backwards
            // Job chya deadline pasun ulat direction madhye slot check karto.

            for (int j = deadline[i] - 1; j >= 0; j--) {
                // deadline[i] - 1 karan array indexing 0 pasun suru hote.
                // Example: deadline = 2 tar j = 1 mhanje Slot 2.
                // j-- mule Slot 2 occupied asel tar Slot 1 check hoto.
                // Latest available slot madhye job thevaycha prayatna karto.

                if (used[j] == false) {
                    // Jar current slot empty asel tarch ha block execute hoto.
                    // false mhanje ya slot madhye ajun job assign zala nahi.

                    result[j] = job[i];
                    // Current job available slot madhye store karto.
                    // Example: Job A chi deadline 2 aslyamule Slot 2 madhye thevto.

                    used[j] = true;
                    // Ha slot ata occupied zala aahe ase mark karto.
                    // Mhanun dusra job ya slot madhye assign honar nahi.

                    totalProfit = totalProfit + profit[i];
                    // Selected job cha profit totalProfit madhye add karto.
                    // Example: A select zalyavar totalProfit = 0 + 100 = 100.

                    break;
                    // Job la slot milalyavar inner loop stop karto.
                    // Karan ek job fakt ekach slot madhye execute hoto.

                }
            }
        }

        System.out.println("Job Sequence:");
        // Final selected jobs sathi heading print karto.

        for (int i = 0; i < result.length; i++) {
            // Result array madhil sagle slots traverse karto.
            // i = 0, 1, 2 mhanje Slot 1, Slot 2, Slot 3.

            System.out.print(result[i] + " ");
            // Pratyek slot madhil selected job print karto.
            // Final sequence C A E ashi print hote.

        }

        System.out.println("\nTotal Profit = " + totalProfit);
        // \n mule output next line var print hoto.
        // Selected jobs cha total profit display karto.
        // Final totalProfit = 100 + 27 + 15 = 142.

    }
}
