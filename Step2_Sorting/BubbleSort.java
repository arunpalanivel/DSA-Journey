/**
 * Bubble_Sort.java
 *
 * 📘 Description:
 * This program implements the Bubble Sort algorithm in Java.
 * Bubble Sort works by repeatedly swapping adjacent elements if they are in the wrong order.
 * After each pass, the largest element moves (or “bubbles up”) to its correct position.
 *
 * 🔍 Example:
 * Input:  [2, 3, 1, 5, 6, 7]
 * Output: [1, 2, 3, 5, 6, 7]
 *
 * ⚙️ Working Principle:
 * 1. Traverse the array multiple times.
 * 2. Compare adjacent elements and swap if they are in the wrong order.
 * 3. After each iteration, the largest element gets placed at the end.
 * 4. Repeat until the array is fully sorted.
 *
 * 🧮 Time Complexity:
 *  - Best Case: O(n)     (when the array is already sorted)
 *  - Average Case: O(n²)
 *  - Worst Case: O(n²)
 *  - Space Complexity: O(1)  (in-place sorting)
 *
 * 🧠 Key Insight:
 * Simple but inefficient for large datasets. However, it helps beginners
 * understand the concept of adjacent comparisons and iterative improvement.
 *
 * 🧑‍💻 Author: Arun Palanivel
 * 🗓️ Date: November 2025
 * 🔗 Part of: Striver’s A2Z DSA Sheet — Step 2 (Sorting Algorithms)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class BubbleSort {
    public static void bubble(int[] arr, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){ // < for descending.
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
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
