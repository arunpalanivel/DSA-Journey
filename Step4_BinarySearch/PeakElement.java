/**
 * 🧩 Problem #31 - Peak Element
 * 🔢 LeetCode Problem: 162 (Find Peak Element)
 * Step: 4 (Binary Search / Arrays)
 *
 * 🧠 Approach Implemented:
 * - Use binary search to efficiently locate a peak element.
 * - A peak element is defined as nums[i] > nums[i-1] and nums[i] > nums[i+1].
 *
 * 🔍 Key Observations:
 * - If nums[mid] < nums[mid + 1], then the peak lies on the **right side**.
 *      → low = mid + 1
 * - Else, the peak lies on the **left side or at mid**.
 *      → high = mid
 *
 * - The binary search continues shrinking the range until low == high,
 *   which represents the index of a peak.
 *
 * ⚙️ Why This Works:
 * - The array can be seen as a combination of increasing and decreasing segments.
 * - A global peak is guaranteed to exist because out-of-bound neighbors are
 *   considered -∞ by definition.
 * - Following the slope direction ensures O(log n) convergence to a peak.
 *
 * 🧮 Time & Space Complexity:
 * - Time Complexity: O(log n)
 * - Space Complexity: O(1)
 *
 * 🔢 Example:
 * Input:  [1, 2, 3, 1]
 * Output: 2
 * (Because nums[2] = 3 is a peak)
 *
 * 📅 Date: December 4, 2025
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 4
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class PeakElement {
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<high){
            int mid = (low + high)/2;

            if(nums[mid] < nums[mid+1]) low = mid+1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(findPeakElement(arr));
    }
}
