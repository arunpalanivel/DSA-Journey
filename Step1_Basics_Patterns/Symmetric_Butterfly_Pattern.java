/*
 * Symmetric_Butterfly_Pattern.java
 *
 * Problem Description:
 * ---------------------
 * Given an integer N, print a symmetric butterfly pattern made of '*' characters.
 * The pattern expands outward and then contracts inward, forming a perfect mirror symmetry.
 *
 * Example:
 * Input:  N = 4
 *
 * Output:
 * *      *
 * **    **
 * ***  ***
 * ********
 * ********
 * ***  ***
 * **    **
 * *      *
 *
 * Logic / Approach:
 * ------------------
 * The butterfly pattern has two parts:
 *
 * 1️⃣ **Upper Half:**
 *    - Left stars increase from 1 → N
 *    - Middle spaces decrease by 2 each row
 *    - Right stars mirror the left
 *
 * 2️⃣ **Lower Half:**
 *    - Left stars decrease from N-1 → 1
 *    - Middle spaces increase by 2 each row
 *    - Right stars mirror the left again
 *
 * Formula:
 * - Left stars: i
 * - Spaces: (2 * N) - (2 * i)
 * - Right stars: i
 */


import java.util.Scanner;

public class Symmetric_Butterfly_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = scanner.nextInt();

        for (int i=1;i<=n;i++){
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
        for(int i=0;i<n-1;i++){
            for(int j=n-i-1;j>0;j--){
                System.out.print("*");
            }
            for (int j=0;j<2+(2*i);j++){
                System.out.print(" ");
            }
            for(int j=n-i-1;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
