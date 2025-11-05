// Problem: Right-Angled Number Pyramid
// Source: Striver A2Z Step 1
// Date: 2025-11-01
// Mistake Log: (if any)
//
// Logic / Steps:
// 1. Take input 'n' — total number of rows.
// 2. Outer loop (i): runs from 1 to n → controls the number of rows.
// 3. Inner loop (j): runs from 1 to i → prints numbers in ascending order for each row.
// 4. After printing numbers in one row, move to the next line using println().

import java.util.Scanner;

public class Right_Angled_Number_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
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

1
1 2
1 2 3
1 2 3 4
1 2 3 4 5

Explanation:
- Each row prints numbers from 1 up to the current row index.
- As 'i' increases, the number of printed elements also increases.
*/
