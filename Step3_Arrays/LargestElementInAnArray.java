/**
 * 🧩 Problem #01 - Largest Element in an Array
 * Step: 3 (Arrays)
 *
 * 🧠 Approaches Implemented:
 * 1️⃣ Brute Force: Sort the array using Arrays.sort() and return the last element.
 *     - Time Complexity: O(n log n)
 *     - Space Complexity: O(1)
 *
 * 2️⃣ Optimal: Traverse the array once and keep track of the largest element.
 *     - Time Complexity: O(n)
 *     - Space Complexity: O(1)
 *
 * 🔢 Example:
 * Input: [3, 2, 1, 5, 2]
 * Output: 5
 *
 * ⚙️ Explanation:
 * - The brute force approach sorts the array, making it easier to pick the last element.
 * - The optimal approach iterates through the array only once, making it efficient and simple.
 *
 * 📅 Date: 2025-11-08
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

import java.util.Arrays;

public class LargestElementInAnArray {

    public static int bruteForce(int[] arr, int n){
        Arrays.sort(arr);
        return arr[n-1];
    }
    // Optimal
    public static int largest_element(int[] arr, int n){
        int largest = arr[0];
        for(int i=0; i<n;i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,2};
        int n = arr.length;
        int bruteForceResult = bruteForce(arr,n);
        System.out.print("Largest element in an array: " +bruteForceResult);
        System.out.println();
        int result = largest_element(arr,n);
        System.out.print("Largest element in an array: " +result);
    }
}
