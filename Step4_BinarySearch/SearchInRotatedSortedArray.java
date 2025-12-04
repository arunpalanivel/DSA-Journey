/**
 * 🧩 Problem #28 - Search in Rotated Sorted Array
 * 🔢 LeetCode Problem: 33 (Search in Rotated Sorted Array)
 * Step: 4 (Binary Search on Answers / Arrays)
 *
 * 🧠 Approach Implemented:
 * - Use a modified binary search on the rotated sorted array.
 * - At any point, ONE HALF of the array is always sorted:
 *      1) Left half sorted → nums[low] <= nums[mid]
 *      2) Right half sorted → nums[mid] <= nums[high]
 *
 * - Based on which half is sorted, determine where the target lies:
 *      ✔ If target lies inside the sorted half → shrink search to that half.
 *      ✔ Otherwise → move to the unsorted half.
 *
 * - Continue until low > high or target is found at nums[mid].
 *
 * ⚙️ Working Principle:
 * - A rotated sorted array contains a pivot, but binary search can still be applied
 *   by identifying the sorted half each time.
 * - This method preserves the O(log n) efficiency of classic binary search.
 *
 * 🧮 Time & Space Complexity:
 * - Time Complexity: O(log n)
 * - Space Complexity: O(1)
 *
 * 🔢 Example:
 * Input:
 *  nums = [7, 8, 9, 1, 2, 3, 4, 5, 6]
 *  target = 1
 *
 * Output:
 *  3
 *
 * 📅 Date: 2025-12-02
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 4
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int target = 1;
        System.out.println(search(arr,target));
    }

}
