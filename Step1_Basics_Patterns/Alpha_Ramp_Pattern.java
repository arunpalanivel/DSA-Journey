// Problem: Alpha Ramp Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-03
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. Initialize a character variable `ch = 'A'`.
// 3. Outer loop (i = 0 → n-1): runs for each row.
// 4. Inner loop (j = 0 → i): prints the current character `ch` with a space.
// 5. After completing a row, increment `ch` to print the next alphabet in the next row.
// 6. Print newline after each row.
//
// Example Output (n = 5):
// A
// B B
// C C C
// D D D D
// E E E E E


import java.util.Scanner;

public class Alpha_Ramp_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scanner.nextInt();
        char ch = 'A';
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(ch + " ");
            }
            ch++;
            System.out.println();
        }
    }
}
