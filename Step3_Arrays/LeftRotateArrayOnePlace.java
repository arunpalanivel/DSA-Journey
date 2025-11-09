/**
 * 🧩 Problem #05 – Left Rotate an Array by One Place
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 *
 * 📘 Description:
 * Given an array of integers, rotate the array to the left by one position.
 * The first element moves to the last, and every other element shifts one index left.
 *
 * 🔍 Example:
 * Input:  [1, 2, 4, 7, 7, 5]
 * Output: [2, 4, 7, 7, 5, 1]
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ LeftRotate (Basic Approach)
 *    - Store the first element separately.
 *    - Shift all remaining elements to the left by one position.
 *    - Place the first element at the last index.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 *
 * 2️⃣ LeftRotate1 (Simplified Loop Version)
 *    - A cleaner and more direct version of the above approach.
 *    - Uses a single loop without nested indices.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 *
 * ⚙️ Edge Cases:
 * - If the array has only one element, it remains unchanged.
 * - Works correctly for arrays with duplicate values.
 *
 * 🔢 Example Walkthrough:
 * arr = [1, 2, 3, 4]
 * Step 1: Store firstElement = 1
 * Step 2: Shift → [2, 3, 4, _]
 * Step 3: Insert firstElement → [2, 3, 4, 1]
 *
 * 📅 Date: 2025-11-10
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class LeftRotateArrayOnePlace {
    public static void leftRotate(int[] arr, int n){
        int firstElement = arr[0];
        for (int i=1;i<n;i++){
            int j = i-1;
            arr[j] = arr[i];
            if(i == n-1){
                arr[i] = firstElement;
            }
        }
    }

    public static void leftRotate1(int[] arr, int n){
        int firstElement = arr[0];
        for (int i=1;i<n;i++) {
            arr[i - 1] = arr[i];
        }
        arr[n-1] = firstElement;
    }


    public static void display(int[] arr, int n){
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,7,5};
        int n = arr.length;
        leftRotate(arr,n);
        display(arr,n);
    }
}
