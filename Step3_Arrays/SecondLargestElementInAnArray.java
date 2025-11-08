/**
 * 🧩 Problem #02 - Second Largest Element in an Array
 * Step: 3 (Arrays)
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force:
 *    - Sort the array and iterate backward to find the first element smaller than the largest.
 *    - Time Complexity: O(n log n)
 *    - Space Complexity: O(1)
 *
 * 2️⃣ Better:
 *    - First, find the largest element by one traversal.
 *    - Then, traverse again to find the maximum element smaller than the largest.
 *    - Time Complexity: O(2n) ≈ O(n)
 *    - Space Complexity: O(1)
 *
 * 3️⃣ Optimal:
 *    - Maintain two variables — `largest` and `secondLargest`.
 *    - Update both in a single traversal of the array.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 *
 * 🔢 Example:
 * Input: [1, 2, 4, 7, 7, 5]
 * Output: 6
 *
 * ⚙️ Explanation:
 * - Brute Force sorts and scans backward.
 * - Better finds the largest first, then the second largest.
 * - Optimal keeps track of both simultaneously — the most efficient and clean approach.
 *
 * 📅 Date: 2025-11-08
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


import java.util.Arrays;
public class SecondLargestElementInAnArray {
    public static int bruteForce(int[] arr, int n){
        Arrays.sort(arr);
        int largest = arr[n-1];
        int secondLargest = -1;
        for(int i=n-2;i>=0;i--){
            if(arr[i] != largest){
                secondLargest = arr[i];
                break;
            }
        }
        return secondLargest;

    }
    public static int better(int[] arr, int n){
        int largest = arr[0];
        int secondLargest = -1;
        for(int i=0; i<n;i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }

        for(int i=0; i<n;i++){
            if(arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;

    }
    public static int secondLargest(int[] arr, int n){
        int largest = arr[0];
        int secondLargest = -1;
        for(int i=0; i<n;i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] < largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,7,5};
        int n = arr.length;
        int bruteForceResult = bruteForce(arr,n);
        System.out.print("Second Largest Element: " + bruteForceResult);
        System.out.println();
        int betterResult = better(arr,n);
        System.out.print("Second Largest Element: " + betterResult);
        System.out.println();
        int result = secondLargest(arr, n);
        System.out.print("Second Largest Element: " + result);
    }
}
