// Problem: Binary Number Triangle Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-02
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. The pattern alternates between 1s and 0s in a triangular shape.
// 3. If the current row index 'i' is even, start with 1; if odd, start with 0.
// 4. For each row, print alternating binary digits by flipping 'start' (using start = 1 - start).
// 5. After each row, print a new line.
//
// Example (n = 5):
// 1
// 01
// 101
// 0101
// 10101

import java.util.Scanner;

public class Binary_Number_Triangle_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        int start = 1;
        for (int i = 0; i < n; i++) {
            // Determine the starting bit based on row index
            if (i % 2 == 0) {
                start = 1;
            } else {
                start = 0;
            }

            // Print alternating 1s and 0s
            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start = 1 - start;  // Flip the bit
            }
            System.out.println();
        }
    }
}
