/**
 * 🧩 Problem #21 - Next Permutation
 * 🔢 LeetCode Problem: 31 (Next Permutation)
 * Step: 3 (Arrays)
 *
 * 🧠 Approach Implemented:
 * - Identify the pivot index (ind) from right where nums[ind] < nums[ind + 1].
 *   This position marks where a higher permutation is still possible.
 * - If no such index exists, the array is in descending order → reverse fully
 *   to get the smallest permutation.
 * - Otherwise:
 *   - From the right, find the smallest number greater than nums[ind].
 *   - Swap it with nums[ind].
 *   - Reverse the subarray from ind+1 to the end to achieve the next lexicographical order.
 *
 * ⚙️ Working Principle:
 * - The pivot indicates the start point where rearranging can form a bigger permutation.
 * - Reversing the suffix ensures the smallest possible sequence after the pivot.
 *
 * 🧮 Time & Space Complexity:
 * - Time Complexity: O(n) — traversal + reversal
 * - Space Complexity: O(1) — in-place modification
 *
 * 🔢 Example:
 * Input:  [1, 2, 3]
 * Output: [1, 3, 2]
 *
 * 📅 Date: 2025-11-26
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

class NextPermutation {
    public static void reverseArray(int[] arr, int start, int end) {
        int i = start;
        int j = end;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1) reverseArray(nums,0,n-1);
        else{
            for(int i=n-1;i>=ind;i--){
                if(nums[i]>nums[ind]){
                    int temp = nums[i];
                    nums[i] = nums[ind];
                    nums[ind] = temp;
                    break;
                }
            }

            reverseArray(nums,ind+1,n-1);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        nextPermutation(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}