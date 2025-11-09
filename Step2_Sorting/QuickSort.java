/**
 * Quick_Sort.java
 *
 * 📘 Description:
 * This program implements the Quick Sort algorithm in Java.
 * Quick Sort is a Divide and Conquer algorithm that partitions an array into subarrays
 * around a pivot element and recursively sorts the subarrays.
 *
 * 🔍 Example:
 * Input:  [3, 5, 1, 2, 6]
 * Output: [1, 2, 3, 5, 6]
 *
 * ⚙️ Working Principle:
 * 1. Choose a pivot element (here, the first element of the array).
 * 2. Partition the array so that all elements smaller than the pivot are on its left,
 *    and all elements greater than the pivot are on its right.
 * 3. Recursively apply the same logic to the left and right subarrays.
 *
 * 🧮 Time Complexity:
 *  - Best Case: O(n log n)
 *  - Average Case: O(n log n)
 *  - Worst Case: O(n²)  (when the pivot is the smallest or largest element)
 *  - Space Complexity: O(log n) (recursive stack)
 *
 * 🧠 Key Insight:
 * Quick Sort is one of the fastest and most commonly used sorting algorithms in practice.
 * It performs best on large datasets when implemented with a good pivot strategy.
 *
 * 🧑‍💻 Author: Arun Palanivel
 * 🗓️ Date: November 2025
 * 🔗 Part of: Striver’s A2Z DSA Sheet — Step 2 (Sorting Algorithms)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class QuickSort {
    public static int partition(int[] arr, int low, int high){
        int start = low;
        int end = high;
        int pivot = arr[low];

        while (start < end){
            if(arr[start] <= pivot){
                start++;
            }
            if(arr[end] > pivot){
                end--;
            }
            if(start < end){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }

        }
        int temp = arr[end];
        arr[end] = arr[low];
        arr[low] = temp;

        return end;

    }

    public static void quick_sort(int[] arr, int low, int high){
        if (low < high){
            int loc = partition(arr,low,high);
            quick_sort(arr,low,loc-1);
            quick_sort(arr,loc+1,high);
        }
    }

    public static void display(int[] arr, int n){
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,2,6};
        int low = 0;
        int high = arr.length-1;
        System.out.print("Before Swaping: ");
        display(arr,high+1);
        System.out.println();
        quick_sort(arr,low,high);
        System.out.print("After Swaping: ");
        display(arr,high+1);

    }
}
