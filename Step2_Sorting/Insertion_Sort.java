/**
 * Insertion_Sort.java
 *
 * 📘 Description:
 * This program implements the Insertion Sort algorithm in Java.
 * Insertion Sort works by building a sorted portion of the array one element at a time,
 * inserting each new element into its correct position among the previously sorted elements.
 *
 * 🔍 Example:
 * Input:  [2, 3, 1, 5, 6, 7]
 * Output: [1, 2, 3, 5, 6, 7]
 *
 * ⚙️ Working Principle:
 * 1. Iterate through the array from the second element to the end.
 * 2. Pick the current element (key) and compare it with all elements before it.
 * 3. Shift all elements greater than the key to one position ahead.
 * 4. Insert the key at its correct position.
 *
 * 🧮 Time Complexity:
 *  - Best Case: O(n)     (when the array is already sorted)
 *  - Average Case: O(n²)
 *  - Worst Case: O(n²)
 *  - Space Complexity: O(1)  (in-place sorting)
 *
 * 🧠 Key Insight:
 * More efficient than Bubble Sort for small or nearly sorted datasets.
 * Ideal for understanding the concept of incremental sorting and array shifting.
 *
 * 🧑‍💻 Author: Arun Palanivel
 * 🗓️ Date: November 2025
 * 🔗 Part of: Striver’s A2Z DSA Sheet — Step 2 (Sorting Algorithms)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class Insertion_Sort {
    public static void insertion(int[] arr, int n){
        for(int i = 1; i < n; i++){ // starts from index 1
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void display(int[] arr, int n){
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 6, 7};
        int n = arr.length;
        System.out.print("Before Sorting: ");
        display(arr, n);
        System.out.println();
        insertion(arr, n);
        System.out.print("After Sorting: ");
        display(arr, n);
    }
}
