/*
 * Hollow_Rectangle_Pattern.java
 *
 * Problem Description:
 * ---------------------
 * Given an integer N, print a hollow square/rectangle pattern using '*' characters.
 * The border should be filled with stars while the inner area remains empty.
 *
 * Example:
 * Input:  N = 5
 *
 * Output:
 * *****
 * *   *
 * *   *
 * *   *
 * *****
 *
 * Logic / Approach:
 * ------------------
 * - We iterate through a grid of N × N.
 * - For each cell (i, j):
 *   → If the current position is on the boundary (first/last row or first/last column), print '*'.
 *   → Otherwise, print a space ' '.
 *
 * Boundary Condition:
 *  i == 0 || i == n-1 || j == 0 || j == n-1 → print('*')
 *  else → print(' ')
 */


import java.util.Scanner;

public class Hollow_Rectangle_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || i == n-1 || j == 0 || j==n-1){
                    System.out.print("*");
                }
                //else if (j != 0 || j!=n-1){
                else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
        scanner.close();
    }
}
