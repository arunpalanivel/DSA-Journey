// Problem: Rectangular Star Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-01
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Take input 'n' — the number of rows and columns.
// 2. Outer loop (i): runs from 0 to n-1 → controls the number of rows.
// 3. Inner loop (j): runs from 0 to n-1 → controls the number of columns.
// 4. Print "* " in each column without a newline.
// 5. After finishing one row, print a newline to start the next row.

import java.util.Scanner;

public class Rectangular_Star_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

/*
Sample Output for n = 4:

* * * *
* * * *
* * * *
* * * *

Explanation:
- Each row prints 'n' stars separated by spaces.
- Both outer and inner loops run 'n' times, forming a perfect square grid.
*/
