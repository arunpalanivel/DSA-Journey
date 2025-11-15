/**
 * 🧩 Problem #17 — Sort an Array of 0s, 1s, and 2s
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📘 Also Known As: Dutch National Flag Algorithm
 *
 * 📌 Problem Statement:
 * Given an array consisting only of 0s, 1s, and 2s, sort the array in ascending order.
 * You must do it WITHOUT using any built-in sorting functions for the optimal approach.
 *
 * ⚙️ Example:
 * Input:  [0,1,2,0,1,2,0,0]
 * Output: [0,0,0,0,1,1,2,2]
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Better Approach (Counting Method)
 *    - Count number of 0s, 1s, and 2s.
 *    - Rewrite the array using these counts.
 *    - Time Complexity: O(2n) ≈ O(n)
 *    - Space Complexity: O(1)
 *
 * 2️⃣ Optimal Approach (Dutch National Flag Algorithm)
 *    - Use three pointers: low, mid, high.
 *    - Logic:
 *         arr[mid] == 0 → swap with low, low++, mid++
 *         arr[mid] == 1 → mid++
 *         arr[mid] == 2 → swap with high, high--
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 *
 * 🎯 Why This Is Optimal?
 * - No extra array
 * - Only single pass required
 * - One of the most famous array manipulation patterns
 *
 * 🧩 Edge Cases:
 * - All 0s
 * - All 1s
 * - All 2s
 * - Already sorted array
 * - Reverse sorted array
 *
 * 📅 Date: 2025-11-XX
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class SortAnArray012 {
    public static void better(int[] arr, int n){
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i=0; i<n; i++){
            if(arr[i] == 0) count0++;
            else if (arr[i]==1) count1++;
            else count2++;
        }
        for(int i=0;i<count0;i++){
            arr[i] = 0;
        }
        for(int i=count0; i<count0+count1; i++){
            arr[i] = 1;
        }
        for(int i=count0+count1; i<n; i++){
            arr[i] = 2;
        }
    }

    public static void optimal(int[] arr, int n){
        int low = 0;
        int mid = 0;
        int high = n-1;

        while (mid <= high){
            if(arr[mid] == 0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] == 1) mid++;
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void display(int[] arr, int n){
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,0,0};
        int n = arr.length;
        display(arr,n);
        better(arr,n);
        System.out.println();
        display(arr,n);
        System.out.println();
        optimal(arr,n);
        display(arr,n);
    }
}
