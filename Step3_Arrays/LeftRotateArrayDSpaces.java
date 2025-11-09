/**
 * 🧩 Problem #06 – Left Rotate an Array by D Spaces
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 *
 * 📘 Description:
 * Given an array of integers and an integer D, rotate the array to the left by D positions.
 * Each element shifts left by one index D times, and the elements that move past the first index
 * appear at the end of the array.
 *
 * 🔍 Example:
 * Input:  arr = [1, 2, 4, 7, 7, 5], D = 2
 * Output: [4, 7, 7, 5, 1, 2]
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (Using Temporary Array)
 *    - Copy the first D elements to a temporary array.
 *    - Shift the remaining elements of the main array left by D positions.
 *    - Copy the temporary elements back to the end.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(D)
 *
 * 2️⃣ Optimal (Reversal Algorithm)
 *    - Step 1: Reverse the first D elements.
 *    - Step 2: Reverse the remaining (n - D) elements.
 *    - Step 3: Reverse the entire array.
 *    - This performs the rotation **in-place** with O(1) extra space.
 *    - Time Complexity: O(2n) ≈ O(n)
 *    - Space Complexity: O(1)
 *
 * ⚙️ Example Walkthrough:
 * arr = [1, 2, 3, 4, 5, 6], D = 2
 * Step 1: Reverse first 2 → [2, 1, 3, 4, 5, 6]
 * Step 2: Reverse remaining → [2, 1, 6, 5, 4, 3]
 * Step 3: Reverse all → [3, 4, 5, 6, 1, 2]
 *
 * 🧩 Edge Cases:
 * - D > N → use D % N to handle extra rotations.
 * - D = 0 → no rotation needed.
 * - Works with duplicate values as well.
 *
 * 📅 Date: 2025-11-10
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class LeftRotateArrayDSpaces {
    public static void bruteForce(int[] arr, int n, int d){
        d = d % n;
        int[] temp = new int[d];
        for(int i=0;i<d;i++){
            temp[i] = arr[i];
        }

        for(int i=d;i<n;i++){
            arr[i-d] = arr[i];
        }
        /*
        int j = 0;
        for(int i=n-d;i<n;i++){
            arr[i] = arr[j];
            j++;
        }
         */
        for(int i=n-d;i<n;i++){
            arr[i] = temp[i-(n-d)];
        }

    }

    public static void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void optimal(int[] arr, int n, int d){
        d = d % n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
    public static void display(int[] arr, int n){
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,4,7,7,5};
        int n = arr.length;
        bruteForce(arr,n,7);
        display(arr,n);
        System.out.println();
        int[] arr1 = {1,2,4,7,7,5};
        int n1 = arr1.length;
        optimal(arr1,n1,7);
        display(arr1,n1);

    }
}
