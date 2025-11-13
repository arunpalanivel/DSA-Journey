/**
 * 🧩 Problem #16 – Two Sum
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 🔗 Related LeetCode Problem: #1 – Two Sum
 *
 * 📘 Description:
 * Given an array of integers `nums` and an integer `target`,
 * return the indices of the two numbers such that they add up to `target`.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * ⚙️ Example:
 * Input:  nums = [2, 6, 5, 8, 11], target = 14
 * Output: [1, 3]
 * Explanation: Because nums[1] + nums[3] = 6 + 8 = 14
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (Nested Loops)
 *    - Traverse all pairs (i, j) where i < j.
 *    - Check if nums[i] + nums[j] == target.
 *    - Return indices when condition is met.
 *    - Time Complexity: O(n²)
 *    - Space Complexity: O(1)
 *
 * 2️⃣ Optimal Approach (HashMap)
 *    - Use a HashMap to store each element and its index.
 *    - For each element, calculate the `complement = target - nums[i]`.
 *    - If the complement exists in the map, return the pair of indices.
 *    - Otherwise, insert the current element into the map.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 *
 * ⚙️ Example Walkthrough (Optimal):
 * nums = [2, 6, 5, 8, 11], target = 14
 * i = 0 → 2 → complement = 12 → not found → store {2=0}
 * i = 1 → 6 → complement = 8 → not found → store {6=1}
 * i = 2 → 5 → complement = 9 → not found → store {5=2}
 * i = 3 → 8 → complement = 6 → found → return [1, 3]
 *
 * ✅ Key Insights:
 * - Hashing drastically reduces time complexity from O(n²) → O(n).
 * - One-pass approach ensures both searching and inserting occur in the same loop.
 * - Works efficiently for unsorted arrays.
 *
 * 🧩 Edge Cases:
 * - Array with no valid pair → should return empty or handle gracefully.
 * - Negative numbers and zeros are supported.
 * - Only one valid solution guaranteed (per LeetCode constraint).
 *
 * 🧠 Reflection:
 * I had solved this problem long ago using the brute force method.
 * Revisiting it today and solving it using a HashMap felt like seeing
 * the same problem from a completely new perspective —
 * proving that growth is just optimized understanding.
 *
 * 📅 Date: 2025-11-13
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] bruteForce(int[] nums, int target){
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> hash = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(hash.containsKey(complement)){
                result[0] = hash.get(complement);
                result[1] = i;
            }
            hash.put(nums[i], i);
        }
        return result;

    }

    public static void display(int[] arr){
        for (int i=0;i<2;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target =14;
        int[] result1 = bruteForce(arr, target);
        display(result1);
        System.out.println();
        int[] result2 = twoSum(arr, target);
        display(result2);
    }

}
