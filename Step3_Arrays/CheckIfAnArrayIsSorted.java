/**
 * 🧩 Problem #03 - Check if an Array is Sorted
 * Step: 3 (Arrays)
 *
 * 🧠 Approach Implemented:
 * - Traverse the array from index 1 to n-1.
 * - Compare each element with its previous one.
 * - If any element is smaller than the previous element, the array is not sorted.
 * - Otherwise, return true after completing the loop.
 *
 * ⚙️ Working Principle:
 * - We assume the array is sorted initially.
 * - The first time we find a violation (arr[i] < arr[i-1]), we return false.
 *
 * 🧮 Time & Space Complexity:
 * - Time Complexity: O(n) — single traversal
 * - Space Complexity: O(1) — constant extra space
 *
 * 🔢 Example:
 * Input: [1, 2, 3, 4, 5]
 * Output: true
 *
 * 📅 Date: 2025-11-08
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class CheckIfAnArrayIsSorted {

    public static boolean isSorted(int[] arr, int n){
        for(int i=1; i<n;i++){
            if(arr[i] >= arr[i-1]){

            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        boolean result = isSorted(arr, n);
        System.out.print("Is Array Sorted: " + result);
    }

}
