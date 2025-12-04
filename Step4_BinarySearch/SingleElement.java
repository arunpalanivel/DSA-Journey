/**
 * 🧩 Problem #32 - Single Element in a Sorted Array
 * 🔢 LeetCode Problem: 540 (Single Element in a Sorted Array)
 * Step: 4 (Binary Search / Arrays)
 *
 * 🧠 Approach Implemented:
 *
 * - The array is sorted, and every element appears exactly twice **except one**.
 * - Use binary search to find the single element in O(log n) time.
 *
 * 🔍 Key Logic:
 * - Pairs always start at even indices:
 *      (0,1), (2,3), (4,5), ...
 *
 * - If nums[mid] == nums[mid + 1], then the single element must be on the **right**.
 *      → low = mid + 2
 *
 * - If nums[mid] != nums[mid + 1], then the single element is on the **left**.
 *      → high = mid - 1
 *
 * - To keep mid aligned with pair-start positions:
 *      If mid is odd → decrement mid by 1.
 *
 * - Eventually low == high → this index holds the unique element.
 *
 * ⚙️ Why This Works:
 * - Before the single element, pairs are perfectly aligned.
 * - After the single element, the pairing gets shifted.
 * - Binary search detects where this misalignment starts.
 *
 * 🧮 Time & Space Complexity:
 * - Time Complexity: O(log n)
 * - Space Complexity: O(1)
 *
 * 🔢 Example:
 * Input:
 *   [1, 1, 2, 3, 3, 4, 4, 8, 8]
 *
 * Output:
 *   2
 *
 * 📅 Date: December 4, 2025
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 4
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class SingleElement {
    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        while(low < high){
            int mid = (low + high)/2;

            if(mid % 2 == 1){
                mid--;
            }

            if(nums[mid] == nums[mid+1]) low = mid+2;
            else high = mid-1;
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr));
    }
}
