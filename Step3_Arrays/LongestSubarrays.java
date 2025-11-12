/**
 * 🧩 Problem #15 – Longest Subarray with Sum K (Positive Numbers)
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 *
 * 📘 Description:
 * Given an array of positive integers `arr` and a target sum `k`,
 * find the length of the longest contiguous subarray whose elements add up exactly to `k`.
 *
 * ⚙️ Example:
 * Input:
 *   arr = [1, 2, 3, 1, 1, 1, 1, 3, 3]
 *   k = 6
 * Output:
 *   4
 * Explanation:
 *   The longest subarray with sum 6 is [3, 1, 1, 1], which has length 4.
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (O(N²) approach)
 *    - Iterate through all possible subarrays.
 *    - For each subarray (i to j), calculate its sum.
 *    - If the sum equals k, update the maximum length.
 *    - Time Complexity: O(N²)
 *    - Space Complexity: O(1)
 *
 * 2️⃣ Optimal Approach (Two-Pointer / Sliding Window)
 *    - Since the array contains **only positive numbers**, we can use two pointers (`left` and `right`).
 *    - Expand `right` and keep adding elements to `sum`.
 *    - If `sum` exceeds `k`, shrink the window by moving `left` forward.
 *    - If `sum == k`, update the maximum length.
 *    - Continue until `right` reaches the end.
 *    - Time Complexity: O(N)
 *    - Space Complexity: O(1)
 *
 * 🔍 Example Walkthrough:
 * arr = [1, 2, 3, 1, 1, 1, 1, 3, 3], k = 6
 *
 * Step 1: Start with left=0, right=0, sum=1
 * Step 2: Move right and keep track of sum
 * Step 3: Whenever sum > k, move left until sum ≤ k
 * Step 4: If sum == k, record subarray length
 *
 * ✅ Longest subarray = [3, 1, 1, 1] → length = 4
 *
 * ⚡ Key Observations:
 * - Works efficiently only for **positive integers**.
 * - If the array contains negative numbers, this approach won’t work —
 *   a prefix sum or hashmap-based method is needed.
 *
 * 🧩 Edge Cases:
 * - No subarray found → returns 0
 * - Entire array sums to k → returns n
 * - Single element equals k → returns 1
 *
 * 📅 Date: 2025-11-12
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class LongestSubarrays {
    public static int bruteForce(int[] arr, int k){
        int n = arr.length;
        int longest = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += arr[j];
                if(sum == k){
                    longest = Math.max(longest, j-i+1);
                }
            }
        }
        return longest;
    }

    public static int optimal(int[] arr, int k){
        int n = arr.length;
        int longest = 0;
        int left = 0;
        int right = 0;
        int sum = arr[0];

        while (right < n){
            while (left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                longest = Math.max(longest, right - left +1);
            }
            right++;
            if(right < n){
                sum += arr[right];
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,3,3};
        int k = 6;
        System.out.println(bruteForce(arr,k));
        System.out.println(optimal(arr,k));
    }
}
