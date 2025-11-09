/**
 * 🧩 Problem #08 – Linear Search in an Array
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 *
 * 📘 Description:
 * Given an array of integers and a target number, find the index of the target
 * element using Linear Search. If the element is not found, return -1.
 *
 * 🔍 Example:
 * Input:  arr = [1, 2, 3, 4], target = 2
 * Output: 1
 * (Because arr[1] = 2)
 *
 * 🧠 Approach:
 * - Traverse the array sequentially.
 * - For each element, check if it matches the target.
 * - If a match is found, return the index immediately.
 * - If the loop completes without finding the target, return -1.
 *
 * ⚙️ Time & Space Complexity:
 * - Time Complexity: O(n)
 * - Space Complexity: O(1)
 *
 * ✅ Example Walkthrough:
 * arr = [1, 2, 3, 4], num = 3
 * Iteration 1: arr[0] = 1 → not match
 * Iteration 2: arr[1] = 2 → not match
 * Iteration 3: arr[2] = 3 → match found → return 2
 *
 * 🧩 Edge Cases:
 * - Element not found → returns -1
 * - Empty array → returns -1
 * - Multiple occurrences → returns the first occurrence index
 *
 * 🧑‍💻 Author: Arun Palanivel
 * 📅 Date: 2025-11-10
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class LinearSearch {
    public static int linearSearch(int[] arr, int num){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int result = linearSearch(arr,2);
        System.out.println(result);
    }
}
