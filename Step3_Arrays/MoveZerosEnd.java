/**
 * 🧩 Problem #07 – Move Zeros to the End
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 🔗 Related LeetCode Problem: #283 – Move Zeroes
 *
 * 📘 Description:
 * Given an array of integers, move all zeros to the end while maintaining
 * the relative order of the non-zero elements. The operation must be done in-place.
 *
 * 🔍 Example:
 * Input:  [0, 1, 0, 3, 12]
 * Output: [1, 3, 12, 0, 0]
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (Using Temporary Array)
 *    - Create a new array and copy all non-zero elements sequentially.
 *    - Fill remaining positions with zeros.
 *    - Copy elements back to the original array.
 *    - Time Complexity: O(2n) ≈ O(n)
 *    - Space Complexity: O(n)
 *
 * 2️⃣ Optimal (Two-Pointer Technique)
 *    - Step 1: Find the first zero's index (`j`).
 *    - Step 2: Traverse the array from j+1 to end:
 *        - If `arr[i]` is non-zero, swap it with `arr[j]` and increment `j`.
 *    - This approach rearranges elements in-place, maintaining order.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 *
 * ⚙️ Example Walkthrough:
 * arr = [0, 1, 0, 3, 12]
 * Step 1: j = 0 (first zero)
 * Step 2:
 *   i = 1 → swap(arr[1], arr[0]) → [1, 0, 0, 3, 12]
 *   i = 3 → swap(arr[3], arr[1]) → [1, 3, 0, 0, 12]
 *   i = 4 → swap(arr[4], arr[2]) → [1, 3, 12, 0, 0]
 *
 * ✅ Final Array: [1, 3, 12, 0, 0]
 *
 * 🧩 Edge Cases:
 * - No zeros → array remains unchanged.
 * - All zeros → no swaps needed.
 * - Mixed duplicates and zeros → works seamlessly.
 *
 * 📅 Date: 2025-11-10
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class MoveZerosEnd {
    public static void bruteForce(int[] arr, int n){
        int[] temp = new int[n];
        int index = 0;
        for(int i=0; i<n;i++){
            if(arr[i] != 0){
                temp[index] = arr[i];
                index++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] = temp[i];
        }
    }

    public static void optimal(int[]arr, int n){
        int j = -1;
        for(int i=0;i<n;i++){
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }
        if(j == -1) return;
        for(int i = j+1; i<n;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
    public static void display(int[] arr, int n){
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,0,0,1,2,4,7,0};
        int n = arr.length;
        bruteForce(arr,n);
        display(arr,n);
        System.out.println();
        int[] arr1 = {0,1,0,3,12};
        int n1 = arr1.length;
        optimal(arr1,n1);
        display(arr1,n1);
    }
}

