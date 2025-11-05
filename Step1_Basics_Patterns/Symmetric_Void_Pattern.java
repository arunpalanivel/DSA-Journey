/*
 * Symmetric_Void_Pattern.java
 *
 * Problem Description:
 * ---------------------
 * Given a number N, print a symmetric star pattern forming a hollow diamond (or “void”) in the middle.
 * The top and bottom halves mirror each other.
 *
 * Example:
 * Input:  N = 5
 *
 * Output:
 * **********
 * ****  ****
 * ***    ***
 * **      **
 * *        *
 * *        *
 * **      **
 * ***    ***
 * ****  ****
 * **********
 *
 * Logic / Approach:
 * ------------------
 * The pattern has two parts:
 *
 * 1️⃣ **Upper Half (Decreasing Stars)**
 *    - Starts with N stars on both sides.
 *    - Between the left and right stars, spaces increase by 2 each row.
 *
 * 2️⃣ **Lower Half (Increasing Stars)**
 *    - Starts with 1 star on both sides.
 *    - Spaces between stars decrease by 2 each row.
 *
 * For each row:
 * - Left stars: (N - i)
 * - Middle spaces: (2 * i)
 * - Right stars: (N - i)
 *
 * Then, the same logic applies in reverse for the bottom half.
 */


import java.util.Scanner;

public class Symmetric_Void_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=0;j<(2*n)-(2*i);j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
