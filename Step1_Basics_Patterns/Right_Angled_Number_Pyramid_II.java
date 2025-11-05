// Problem: Right-Angled Number Pyramid II
// Source: Striver A2Z Step 1
// Date: 2025-11-01
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Take input 'n' — the total number of rows.
// 2. Outer loop (i): runs from 1 to n → represents the current row.
// 3. Inner loop (j): runs from 1 to i → prints the current row number (i) repeatedly.
// 4. After printing all numbers for one row, move to a new line using println().

import java.util.Scanner;

public class Right_Angled_Number_Pyramid_II {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

/*
Sample Output for n = 5:

1
2 2
3 3 3
4 4 4 4
5 5 5 5 5

Explanation:
- The outer loop (i) decides which number to print in each row.
- The inner loop repeats that number 'i' times.
*/
