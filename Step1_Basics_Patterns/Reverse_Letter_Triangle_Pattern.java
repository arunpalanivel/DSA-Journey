// Problem: Reverse Letter Triangle Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-02
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. For each row 'i' (0 to n-1):
//    - Initialize `ch = 'A'` at the start of every row.
//    - For each column 'j' (0 to n-i-1):
//        • Print the current character `ch` followed by a space.
//        • Increment `ch` to move to the next letter.
// 3. Move to a new line after every row.
//
// Example (n = 5):
// A B C D E
// A B C D
// A B C
// A B
// A

import java.util.Scanner;

public class Reverse_Letter_Triangle_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            char ch = 'A';
            for (int j = 0; j < n - i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
        scanner.close();
    }
}
