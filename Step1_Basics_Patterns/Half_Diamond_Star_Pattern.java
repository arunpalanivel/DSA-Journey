// Problem: Half Diamond Star Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-02
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. The pattern is formed by two parts:
//      - Increasing part (Top Half)
//      - Decreasing part (Bottom Half)
//
// --- Part 1: Increasing Half ---
// • Outer loop 'i' runs from 0 to n-1.
// • Inner loop 'j' runs from 0 to i, printing '*' each time.
// • After each row, move to a new line.
//
// --- Part 2: Decreasing Half ---
// • Outer loop 'i' runs from n-1 down to 1.
// • Inner loop 'j' runs from 0 to i-1, printing '*' each time.
// • After each row, move to a new line.
//
// Example (n = 4):
// *
// **
// ***
// ****
// ***
// **
// *

import java.util.Scanner;

public class Half_Diamond_Star_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        // Increasing Half
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // Decreasing Half
        for(int i = n - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
