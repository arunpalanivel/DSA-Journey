/**
 * 🧩 Problem #14 – Max Consecutive Ones
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 🔗 Related LeetCode Problem: #485 – Max Consecutive Ones
 *
 * 📘 Description:
 * Given a binary array `nums`, find the maximum number of consecutive 1's in the array.
 *
 * ⚙️ Example:
 * Input:  [1, 1, 0, 0, 1, 1, 1, 1]
 * Output: 4
 *
 * 🧠 Approach (Optimal):
 * - Traverse the array once.
 * - Maintain a running count (`count`) of consecutive 1's.
 * - When a 0 is encountered, reset `count` to 0.
 * - Keep track of the maximum count (`maxi`) found so far.
 *
 * 🔍 Dry Run:
 * nums = [1, 1, 0, 1, 1, 1]
 * Step-by-step:
 * 1 → count = 1, max = 1
 * 1 → count = 2, max = 2
 * 0 → count = 0
 * 1 → count = 1
 * 1 → count = 2
 * 1 → count = 3 → ✅ max = 3
 *
 * ✅ Final Answer = 3
 *
 * ⏱️ Time Complexity: O(n)
 * 🧮 Space Complexity: O(1)
 *
 * 🧩 Edge Cases:
 * - All 1’s → returns array length.
 * - All 0’s → returns 0.
 * - Empty array → returns 0.
 *
 * 🧠 Concept Strengthened:
 * - Sequential state tracking
 * - Maintaining running counters
 * - Real-world pattern detection (used in signal/bitstream problems)
 *
 * 📅 Date: 2025-11-12
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxi = 0;

        for(int i=0; i<nums.length;i++){
            if(nums[i] == 1){
                count++;
                maxi = Math.max(maxi, count);
            }
            else{
                count = 0;
            }
        }
        return maxi;

    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1,1,1,1};
        int result = findMaxConsecutiveOnes(arr);
        System.out.println("The Maximum Consecutive Ones: " + result);
    }



}
