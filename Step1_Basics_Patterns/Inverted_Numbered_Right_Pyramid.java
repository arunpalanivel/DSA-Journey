// Problem: Inverted Numbered Right Pyramid
// Source: Striver A2Z Step 1
// Date: 2025-11-01
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Take input 'n' — the total number of rows.
// 2. The pattern starts from 'n' numbers in the first row and decreases by 1 each subsequent row.
// 3. Outer loop (i): runs from n down to 1 → controls the number of rows.
// 4. Inner loop (j): runs from 1 to i → prints numbers in ascending order in each row.
// 5. After each inner loop, move to a new line.

import java.util.Scanner;

public class Inverted_Numbered_Right_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

/*
Sample Output for n = 5:

1 2 3 4 5
1 2 3 4
1 2 3
1 2
1

Explanation:
- The outer loop decreases the number of elements printed each row.
- The inner loop prints numbers starting from 1 up to the current row count.
*/
