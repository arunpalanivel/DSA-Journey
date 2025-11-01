// Problem: Inverted Star Pyramid (Centered)
// Source: Striver A2Z Step 1
// Date: 2025-11-01
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Take input 'n' — total number of rows.
// 2. The pyramid starts with the widest row (2*n - 1 stars) and shrinks by 2 stars each row.
// 3. Outer loop (i): controls the current row, runs from 0 to n-1.
// 4. First inner loop prints the leading spaces ('i' spaces) — shifts stars to the right.
// 5. Second inner loop prints the stars for that row → ((2*n)-1)-(2*i) stars.
// 6. Third inner loop prints the trailing spaces (optional, for symmetry).
// 7. Move to a new line after each row.

import java.util.Scanner;

public class Inverted_Star_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            // Left Empty Spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // Print Stars
            for (int j = 0; j < ((2 * n) - 1) - (2 * i); j++) {
                System.out.print("*");
            }

            // Right Empty Spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}

/*
Sample Output for n = 5:

*********
 *******
  *****
   ***
    *

Explanation:
- Each row prints fewer stars than the previous one.
- The spaces on both sides keep the pyramid centered.
*/
