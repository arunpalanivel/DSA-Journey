// Problem: Number Crown Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-02
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. For each row 'i' (from 1 to n):
//    - Print numbers increasing from 1 to i.
//    - Then print spaces: count = 2 * (n - i).
//    - Then print numbers decreasing from i down to 1.
// 3. Print a new line after each row.
//
// Example (n = 5):
// 1        1
// 12      21
// 123    321
// 1234  4321
// 1234554321

import java.util.Scanner;

public class Number_Crown_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {

            // Left side numbers (increasing)
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Middle spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // Right side numbers (decreasing)
            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
