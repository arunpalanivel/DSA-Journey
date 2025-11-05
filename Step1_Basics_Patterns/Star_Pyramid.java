// Problem: Star Pyramid Pattern (Full Pyramid)
// Source: Striver A2Z Step 1
// Date: 2025-11-01
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Take input 'n' — total number of rows in the pyramid.
// 2. Outer loop (i): runs from 0 to n-1 → controls each row.
// 3. First inner loop: prints (n - i - 1) spaces on the left for alignment.
// 4. Second inner loop: prints (2 * i + 1) stars for the current row.
// 5. Third inner loop: prints (n - i - 1) spaces on the right (for symmetry).
// 6. Move to the next line after completing each row.

import java.util.Scanner;

public class Star_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            // Left Side WhiteSpaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // Print Stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            // Right Side WhiteSpaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
        scanner.close();
    }
}

/*
Sample Output for n = 5:

    *
   ***
  *****
 *******
*********

Explanation:
- The pyramid has 'n' rows.
- Stars increase by 2 each row (1, 3, 5, 7, 9...).
- Left and right spaces decrease by one each row for center alignment.
*/
