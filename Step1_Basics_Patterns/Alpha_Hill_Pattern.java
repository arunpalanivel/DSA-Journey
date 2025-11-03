// Problem: Alpha Hill Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-03
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. Outer loop (i = 0 → n-1): builds each row.
// 3. Print leading spaces: (n - i - 1) spaces to center the pattern.
// 4. Initialize `ch = 'A'` for each row.
// 5. Print increasing characters from 'A' to 'A' + i.
// 6. Decrease `ch` once (to go back one step) and print decreasing characters until 'A' again.
// 7. Print trailing spaces (same count as leading spaces).
// 8. Move to the next line after each row.
//
// Example Output (n = 5):
//     A
//    ABA
//   ABCBA
//  ABCDCBA
// ABCDEDCBA


import java.util.Scanner;
public class Alpha_Hill_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for(int i=0;i<n;i++){
            //Left Side EMpty SPaces
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            char ch = 'A';

            for(int j=0;j<=i;j++){
                System.out.print(ch);
                ch++;
            }

            ch--;

            for(int j=0;j<i;j++){
                ch--;
                System.out.print(ch);
            }

            //Right Side Empty spaces.
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }


            System.out.println();
        }
    }
}
