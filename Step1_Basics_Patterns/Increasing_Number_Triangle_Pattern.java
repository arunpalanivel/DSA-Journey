// Problem: Increasing Number Triangle Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-02
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. Initialize a counter variable `num = 1` to track the numbers to print.
// 3. For each row 'i' from 1 to n:
//    - Print 'i' numbers in that row, each followed by a space.
//    - Increment 'num' after every print.
// 4. Move to the next line after each row.
//
// Example (n = 5):
// 1
// 2 3
// 4 5 6
// 7 8 9 10
// 11 12 13 14 15

import java.util.Scanner;

public class Increasing_Number_Triangle_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();
        int num = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
