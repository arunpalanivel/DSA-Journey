/**
 * Selection_Sort.java
 *
 * 📘 Description:
 * This program implements the Selection Sort algorithm in Java.
 * Selection Sort works by repeatedly finding the minimum element from
 * the unsorted portion of the array and swapping it with the first unsorted element.
 *
 * 🔍 Example:
 * Input:  [2, 3, 1, 5, 6, 7]
 * Output: [1, 2, 3, 5, 6, 7]
 *
 * ⚙️ Working Principle:
 * 1. Divide the array into two parts — sorted and unsorted.
 * 2. Find the minimum element from the unsorted part.
 * 3. Swap it with the first element of the unsorted part.
 * 4. Repeat until the entire array is sorted.
 *
 * 🧮 Time Complexity:
 *  - Best Case: O(n²)
 *  - Average Case: O(n²)
 *  - Worst Case: O(n²)
 *  - Space Complexity: O(1)  (in-place sorting)
 *
 * 🧠 Key Insight:
 * Selection Sort makes the minimum number of swaps (compared to Bubble Sort),
 * but it is still inefficient for large datasets.
 *
 * 🧑‍💻 Author: Arun Palanivel
 * 🗓️ Date: November 2025
 * 🔗 Part of: Striver’s A2Z DSA Sheet — Step 2 (Sorting Algorithms)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class SelectionSort {
    public static void selection(int[] arr, int n){
        for(int i=0;i<n;i++){
            int min_index = i;
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[min_index]){ // > for descending.
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
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
        selection(arr,n);
        System.out.print("After Sorting: ");
        display(arr,n);

    }
}
