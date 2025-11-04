/*
 * The_Number_Pattern.java
 *
 * Problem Description:
 * ---------------------
 * Given a number N, print a (2*N - 1) x (2*N - 1) pattern of numbers in concentric squares.
 * The outermost layer starts with N, and each inner layer decreases by 1 until it reaches 1 in the center.
 *
 * Example:
 * Input:  N = 3
 *
 * Output:
 * 3 3 3 3 3
 * 3 2 2 2 3
 * 3 2 1 2 3
 * 3 2 2 2 3
 * 3 3 3 3 3
 *
 * Input:  N = 6
 *
 * Output:
 * 6 6 6 6 6 6 6 6 6 6 6
 * 6 5 5 5 5 5 5 5 5 5 6
 * 6 5 4 4 4 4 4 4 4 5 6
 * 6 5 4 3 3 3 3 3 4 5 6
 * 6 5 4 3 2 2 2 3 4 5 6
 * 6 5 4 3 2 1 2 3 4 5 6
 * 6 5 4 3 2 2 2 3 4 5 6
 * 6 5 4 3 3 3 3 3 4 5 6
 * 6 5 4 4 4 4 4 4 4 5 6
 * 6 5 5 5 5 5 5 5 5 5 6
 * 6 6 6 6 6 6 6 6 6 6 6
 *
 * Logic Explanation:
 * -------------------
 * Each position in the grid depends on its minimum distance from the edges:
 * - top    → i
 * - left   → j
 * - right  → (2*N - 2 - j)
 * - bottom → (2*N - 2 - i)
 *
 * The minimum of these four values gives how far you are from the outer layer.
 * Subtract that from N to get the correct number to print.
 *
 * Formula:
 * number = N - min(top, left, right, bottom)
 */


import java.lang.Math;
import java.util.Scanner;

public class The_Number_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();


        for(int i=0;i<(2*n)-1;i++){

            for(int j=0;j<(2*n)-1;j++){
                int top = i;
                int left = j;
                int right = 2*n-2-j;
                int bottom = 2*n-2-i;
                System.out.print(n-Math.min(Math.min(top,left),Math.min(right,bottom)));
            }
            System.out.println();

        }
    }
}
