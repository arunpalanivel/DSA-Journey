// Problem: Alpha Triangle Pattern
// Source: Striver A2Z Step 1
// Date: 2025-11-03
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Get the number 'n' from the user.
// 2. Compute the starting (maximum) character as 'A' + (n - 1).
//    → For n = 5, the first row starts with 'E'.
// 3. Outer loop (i = 0 → n-1): builds each row.
// 4. Initialize a variable `val` with the current `max` character.
// 5. Inner loop (j = 0 → i): print `val`, then increment it by one character.
// 6. After completing a row, decrement `max` (so next row starts from one character earlier).
// 7. Move to the next line after each row.
//
// Example Output (n = 5):
// E
// D E
// C D E
// B C D E
// A B C D E


import java.util.Scanner;

public class Alpha_Triangle_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

         // F for n = 5
        char max = 'A';
        max+= (char)(n-1);
        for(int i=0;i<n;i++){
            char val = max; // E D C
            for(int j=0;j<=i;j++){
                System.out.print(val + " "); // E D E C D E
                val++; //F E D E
            }
            max--; // D C B ;
            System.out.println();
        }


    }

}
