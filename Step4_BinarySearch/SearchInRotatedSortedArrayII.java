/**
 * 🧩 Problem #29 - Search in Rotated Sorted Array II (With Duplicates)
 * 🔢 LeetCode Problem: 81 (Search in Rotated Sorted Array II)
 * Step: 4 (Binary Search / Arrays)
 *
 * 🧠 Approach Implemented:
 *
 * - Perform a modified binary search similar to Problem #28, but
 *   handle **duplicate elements** which break the simple logic.
 *
 * 1️⃣ Key Difficulty:
 * - When duplicates exist, nums[low], nums[mid], nums[high] can be equal.
 * - In this case, we cannot determine which half (left or right)
 *   is sorted, so we shrink the search space:
 *        low++
 *        high--
 *
 * 2️⃣ Standard Rotated Array Binary Search:
 * - If left half is sorted → nums[low] <= nums[mid]
 *      - Check if target lies inside that range.
 * - Else → right half is sorted.
 *      - Check if target lies inside that range.
 *
 * - Continue narrowing the search boundaries until low > high.
 *
 * ⚙️ Working Principle:
 * - Duplicates cause ambiguity; removing edges (low++, high--)
 *   allows the array to eventually become searchable like Problem #28.
 * - The overall average time is O(log n), but worst case can degrade
 *   to O(n) due to duplicate skipping.
 *
 * 🧮 Time & Space Complexity:
 * - Time Complexity: O(log n) average, O(n) worst-case (due to duplicates)
 * - Space Complexity: O(1)
 *
 * 🔢 Example:
 * Input:
 *  nums = [2, 5, 6, 0, 0, 1, 2]
 *  target = 0
 *
 * Output:
 *  true
 *
 * 📅 Date: 2025-12-02
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 4
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return true;

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;

            }

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
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(arr,target));
    }
}
