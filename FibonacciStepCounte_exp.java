
import java.util.Scanner;
// Scanner class import keli, karan user kadun keyboard input ghyaycha aahe.

public class FibonacciStepCount {
    // Ha aapla class aahe.
    // Java madhye code class chya aat lihila jato.

    public static void main(String[] args) {
        // main() method pasun program execution suru hote.
        // public = kuthunahi access karta yeto.
        // static = object create na karta main() run hote.
        // void = kontihi value return karat nahi.
        // String[] args = command-line arguments sathi vapartat.

        Scanner sc = new Scanner(System.in);
        // Scanner cha sc navacha object create kela.
        // System.in mhanje keyboard varun input ghene.

        System.out.print("Enter the number of terms: ");
        // User la kiti Fibonacci terms pahijet te vicharto.
        // print() mule cursor tyach line var rahto.

        int n = sc.nextInt();
        // User ne enter keleli integer value n madhye store hote.
        // Example: n = 5 mhanje pahile 5 Fibonacci numbers print karayche.

        int a = 0, b = 1, c;
        // Fibonacci series che pahile don numbers 0 ani 1 aahet.
        // a = previous number
        // b = current number
        // c = pudhcha number store karnyasathi vaparto.

        int stepCount = 0;
        // Kiti operations count kele te track karnyasathi variable aahe.
        // Suruvatila 0 thevla, karan ajun ekahi counted step zala nahi.

        System.out.println("Fibonacci Series:");
        // Output screen var heading print karto.
        // println() mule pudhcha output navin line var yeto.

        if (n >= 1) {
            // Jar user la kamit kami 1 term pahije asel,
            // tarch ha if block execute hoto.

            System.out.print(a + " ");
            // Pahila Fibonacci number 0 print hoto.
            // " " mule numbers madhye space yete.

            stepCount++;
            // Ek counted step vadhavla.
            // ++ mhanje stepCount = stepCount + 1

        }

        if (n >= 2) {
            // Jar user la 2 kinva tyapeksha jast terms pahijet,
            // tar ha block execute hoto.

            System.out.print(b + " ");
            // Dusra Fibonacci number 1 print hoto.

            stepCount++;
            // Dusrya printed term sathi ek counted step add kela.

        }

        for (int i = 3; i <= n; i++) {
            // for loop tisrya term pasun suru hoto.
            // Karan pahile don terms aadhich print kele aahet.
            // i = 3 : tisrya term pasun suruvat.
            // i <= n : n terms purna hoeparyant loop chalto.
            // i++ : pratyek iteration nantar i ekane vadhato.

            c = a + b;
            // Magil don Fibonacci numbers chi addition karto.
            // Example: a = 0, b = 1 tar c = 0 + 1 = 1
            // Hach Fibonacci series cha main logic aahe.

            stepCount++;      // Addition step
            // a + b ya addition operation sathi 1 step count kela.

            System.out.print(c + " ");
            // Navin calculate zalele Fibonacci number print karto.

            a = b;
            // b chi juni value ata a madhye store karto.
            // Mhanje pudhchya iteration sathi numbers shift hotat.

            b = c;
            // c chi navin value ata b madhye store karto.
            // Tyamule pudhchya iteration madhye next number calculate hoto.

            stepCount += 2;   // Assignment steps
            // Varchya a = b ani b = c ya don assignments aahet.
            // Mhanun stepCount madhye 2 add kele.
            // += 2 mhanje stepCount = stepCount + 2

        }

        System.out.println("\n\nTotal Step Count = " + stepCount);
        // \n\n mhanje don newlines.
        // Shevti ekun counted operations print karto.
        // Ya program madhye fakt selected operations count kele aahet.

        sc.close();
        // Scanner close karto.
        // Input resource vaprun zalyavar close karne hi good practice aahe.

    } // main() method sampli.

} // FibonacciStepCount class sampla.
