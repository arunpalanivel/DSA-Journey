// Problem: Inverted Right-Angled Star Pyramid
// Source: Striver A2Z Step 1
// Date: 2025-11-01
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Take input 'n' — total number of rows.
// 2. The pyramid starts with 'n' stars in the first row and decreases by one star each subsequent row.
// 3. Outer loop (i): runs from n down to 1 — controls the number of rows.
// 4. Inner loop (j): runs from 0 to i-1 — prints stars for that row.
// 5. After each inner loop, print a newline to move to the next row.

import java.util.Scanner;

public class Inverted_Right_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

/*
Sample Output for n = 5:

* * * * *
* * * *
* * *
* *
*

Explanation:
- Outer loop (i) controls how many stars to print per row.
- As 'i' decreases, the number of stars printed reduces line by line.
*/
