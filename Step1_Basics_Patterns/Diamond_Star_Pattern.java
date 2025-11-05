// Problem: Diamond Star Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-01
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. The pattern is built in two halves: the top pyramid and the bottom inverted pyramid.
//
// 3. --- Part 1: Top Pyramid (Outer loop 'i' from 0 to n-1') ---
// 4. For each row 'i', print leading spaces using (n - i - 1) spaces.
// 5. Then print (2*i + 1) stars to form the pyramid.
// 6. Repeat for all rows to form the upper diamond.
//
// 7. --- Part 2: Bottom Inverted Pyramid (Outer loop 'i' from 0 to n-1') ---
// 8. For each row 'i', print 'i' spaces to shift the stars right.
// 9. Then print ((2*n - 1) - (2*i)) stars to shrink the pyramid.
// 10. Repeat for all rows to complete the diamond shape.

import java.util.Scanner;

public class Diamond_Star_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number n: ");
        int n = scanner.nextInt();

        // Part 1: Top Pyramid
        for (int i = 0; i < n; i++) {
            // Left Side Empty Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Print Star
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // Right Side Empty Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        // Part 2: Bottom Inverted Pyramid
        for (int i = 0; i < n; i++) {
            // Left Side Empty Spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // Print Star
            for (int j = 0; j < ((2 * n) - 1) - (2 * i); j++) {
                System.out.print("*");
            }
            // Right Side Empty Spaces
            for (int j = 0; j < i; j++) {
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
*********
 *******
  *****
   ***
    *

Explanation:
- The top part forms a normal pyramid pattern of increasing stars.
- The bottom part mirrors it in reverse, forming a symmetric diamond.
*/
