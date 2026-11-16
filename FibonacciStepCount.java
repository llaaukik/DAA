import java.util.Scanner;

public class FibonacciStepCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");

        int n = sc.nextInt();

        int a = 0, b = 1, c;

        int stepCount = 0;

        System.out.println("Fibonacci Series:");

        if (n >= 1) {

            System.out.print(a + " ");

            stepCount++;

        }

        if (n >= 2) {

            System.out.print(b + " ");

            stepCount++;

        }

        for (int i = 3; i <= n; i++) {

            c = a + b;

            stepCount++;      // Addition step

            System.out.print(c + " ");

            a = b;

            b = c;

            stepCount += 2;   // Assignment steps

        }

        System.out.println("\n\nTotal Step Count = " + stepCount);

        sc.close();

    }

}

