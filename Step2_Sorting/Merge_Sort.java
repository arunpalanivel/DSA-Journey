/**
 * Merge_Sort.java
 *
 * 📘 Description:
 * This program implements the Merge Sort algorithm in Java.
 * Merge Sort is a classic example of the Divide and Conquer approach.
 * It divides the array into two halves, recursively sorts them, and then merges the sorted halves.
 *
 * 🔍 Example:
 * Input:  [2, 3, 1, 5, 6, 7]
 * Output: [1, 2, 3, 5, 6, 7]
 *
 * ⚙️ Working Principle:
 * 1. Recursively divide the array into two halves until each subarray has one element.
 * 2. Merge the subarrays by comparing elements and building a sorted array.
 * 3. Copy the merged elements back to the original array.
 *
 * 🧮 Time Complexity:
 *  - Best Case: O(n log n)
 *  - Average Case: O(n log n)
 *  - Worst Case: O(n log n)
 *  - Space Complexity: O(n)  (uses auxiliary array for merging)
 *
 * 🧠 Key Insight:
 * Merge Sort guarantees O(n log n) performance regardless of input order,
 * making it one of the most efficient and stable sorting algorithms.
 * It’s ideal for learning recursion and the concept of divide-and-conquer.
 *
 * 🧑‍💻 Author: Arun Palanivel
 * 🗓️ Date: November 2025
 * 🔗 Part of: Striver’s A2Z DSA Sheet — Step 2 (Sorting Algorithms)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class Merge_Sort {
    public static void merge(int[] arr, int low, int mid, int high){
        int i = low;
        int j = mid+1;
        int k = low;
        int[] b = new int[arr.length];

        while (i<=mid && j<=high){
            if(arr[i] <= arr[j]){
                b[k] = arr[i];
                i++;
            }
            else {
                b[k] = arr[j];
                j++;
            }
            k++;
        }
        if(i> mid){
            while (j<=high){
                b[k] = arr[j];
                j++;
                k++;
            }
        }
        else {
            while (i<=mid){
                b[k] = arr[i];
                i++;
                k++;
            }
        }
        for (int z = low; z<=high;z++){
            arr[z] = b[z];
        }
    }
    public static void mergesort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high) /2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            merge(arr,low,mid,high);
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
        int low = 0;
        int high = n-1;

        System.out.print("Before Sorting: ");
        display(arr,n);
        System.out.println();
        mergesort(arr,low,high);
        System.out.print("After Sorting: ");
        display(arr,n);

    }
}
