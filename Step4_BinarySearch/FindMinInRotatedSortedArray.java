/**
 * 🧩 Problem #30 - Find Minimum in Rotated Sorted Array
 * 🔢 LeetCode Problem: 153 (Find Minimum in Rotated Sorted Array)
 * Step: 4 (Binary Search / Arrays)
 *
 * 🧠 Approach Implemented:
 *
 * - Use binary search on the rotated sorted array.
 * - At any time, one half of the array is sorted.
 *
 * 1️⃣ If nums[low] <= nums[mid]:
 *      → Left half is sorted.
 *      → Therefore nums[low] is the minimum of this half.
 *      → Compare it with current global minimum.
 *      → Move to right half (low = mid + 1)
 *
 * 2️⃣ Else:
 *      → Right half is sorted.
 *      → nums[mid] is a potential minimum.
 *      → Update global minimum.
 *      → Move to left half (high = mid - 1)
 *
 * - Continue until search space is exhausted.
 *
 * ⚙️ Working Principle:
 * - A rotated sorted array has a pivot.
 * - The minimum element is the only element where:
 *      nums[i] < nums[i - 1]
 * - Binary search efficiently narrows down the unsorted portion
 *   to locate this pivot point.
 *
 * 🧮 Time & Space Complexity:
 * - Time Complexity: O(log n)
 * - Space Complexity: O(1)
 *
 * 🔢 Example:
 * Input:
 *   [3, 4, 5, 1, 2]
 *
 * Output:
 *   1
 *
 * 📅 Date: 2025-11-30
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 4
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class FindMinInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[low] <= nums[mid]){
                min = Math.min(nums[low], min);
                low = mid+1;
            }
            else{
                min = Math.min(nums[mid], min);
                high = mid-1;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr= {3,4,5,1,2};
        System.out.println(findMin(arr));
    }

}
