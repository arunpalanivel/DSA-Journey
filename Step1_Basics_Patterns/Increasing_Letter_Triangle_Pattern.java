// Problem: Increasing Letter Triangle Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-02
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. For each row 'i' (0 to n-1):
//    - Initialize a character variable `ch = 'A'`.
//    - For each column 'j' (0 to i):
//        • Print the character `ch` followed by a space.
//        • Increment `ch` to print the next letter in sequence.
// 3. Move to the next line after each row.
//
// Example (n = 5):
// A
// A B
// A B C
// A B C D
// A B C D E

import java.util.Scanner;

public class Increasing_Letter_Triangle_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            char ch = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }
}
