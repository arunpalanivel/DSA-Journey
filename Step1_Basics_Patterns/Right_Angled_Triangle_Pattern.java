// Problem: Right-Angled Star Triangle Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-01
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Take input 'n' — total number of rows.
// 2. Outer loop (i): runs from 0 to n-1 → controls the current row.
// 3. Inner loop (j): runs from 0 to i → prints stars for that row.
// 4. Each row prints one more star than the previous row.
// 5. After completing each row, print a newline to start the next row.

import java.util.Scanner;

public class Right_Angled_Triangle_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

/*
Sample Output for n = 5:

*
* *
* * *
* * * *
* * * * *

Explanation:
- Outer loop (i) defines the current row.
- Inner loop (j) prints 'i + 1' stars per row.
- The pattern grows by one star per line.
*/
