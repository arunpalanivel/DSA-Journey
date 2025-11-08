/**
 * Bubble_Sort_Optimized.java
 *
 * 📘 Description:
 * This program implements an optimized version of the Bubble Sort algorithm in Java.
 * It introduces an early-exit condition using a flag to detect if the array is already sorted,
 * reducing unnecessary passes.
 *
 * 🔍 Example:
 * Input:  [2, 3, 1, 5, 6, 7]
 * Output: [1, 2, 3, 5, 6, 7]
 *
 * ⚙️ Working Principle:
 * 1. Repeatedly compare adjacent elements and swap if they are in the wrong order.
 * 2. Use a boolean flag to track if any swaps were made.
 * 3. If no swaps occur in a pass, the array is already sorted — stop early.
 *
 * 🧮 Time Complexity:
 *  - Best Case: O(n)     (when the array is already sorted)
 *  - Average Case: O(n²)
 *  - Worst Case: O(n²)
 *  - Space Complexity: O(1)  (in-place sorting)
 *
 * 💡 Optimization:
 * The early termination check significantly improves performance for nearly sorted arrays.
 *
 * 🧑‍💻 Author: Arun Palanivel
 * 🗓️ Date: November 2025
 * 🔗 Part of: Striver’s A2Z DSA Sheet — Step 2 (Sorting Algorithms)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class Bubble_Sort_Optimized {
    public static void bubble(int[] arr, int n){
        for(int i=0;i<n;i++){
            boolean swapped = false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){// < for descending.
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }
    public static void display(int[] arr, int n){
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,5,6,7};
        int n = arr.length;
        System.out.print("Before Sorting: ");
        display(arr,n);
        System.out.println();
        bubble(arr,n);
        System.out.print("After Sorting: ");
        display(arr,n);

    }
}
