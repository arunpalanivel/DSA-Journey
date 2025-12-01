/**
 * 🧩 Problem #27 - Count Subarrays With Sum K
 * 🔢 LeetCode Problem: 560 (Subarray Sum Equals K)
 * Step: 3 (Arrays)
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force Approach (bruteForce):
 * - Generate all possible subarrays using two loops (i, j).
 * - For each subarray, compute the sum using another loop.
 * - If the sum equals k, increase the count.
 * - Extremely slow: triple nested loop.
 *
 * 2️⃣ Better Approach (better):
 * - Still generate all subarrays using two loops.
 * - But compute the sum on the fly by adding the next element.
 * - Eliminates one loop and reduces complexity significantly.
 *
 * 3️⃣ Optimal Approach Using Prefix Sum + HashMap (optimal):
 * - Maintain a running prefix sum.
 * - The idea:
 *      If prefixSum - k exists in the map,
 *      then a subarray ending here has sum = k.
 * - Store prefix sum frequencies in a HashMap.
 * - Initialize map with (0 → 1) to handle cases where prefix itself equals k.
 * - This achieves linear time complexity.
 *
 * ⚙️ Working Principle:
 * - Brute force computes sum from scratch repeatedly.
 * - Better accumulates sum while expanding the subarray.
 * - Optimal uses the mathematical relation:
 *      subarraySum(i..j) = prefix[j] - prefix[i-1]
 *   → if prefix[j] - k exists, we found a valid subarray.
 *
 * 🧮 Time & Space Complexity:
 * - Brute Force:
 *   Time: O(n³)
 *   Space: O(1)
 *
 * - Better:
 *   Time: O(n²)
 *   Space: O(1)
 *
 * - Optimal (Prefix Sum + HashMap):
 *   Time: O(n)
 *   Space: O(n)
 *
 * 🔢 Example:
 * Input:
 *  array = [1, 2, 3, -3, 1, 1, 1, 4, 2, -3]
 *  k = 3
 *
 * Output:
 *  6  (depending on approach)
 *
 * 📅 Date: 2025-12-01
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

import java.util.HashMap;
import java.util.Map;

public class NoOfSubarraysK {
    public static int bruteForce(int[] array, int k) {
        int n = array.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int m = i; m <= j; m++) {
                    sum = sum + array[m];
                }
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int better(int[] array, int k) {
        int n = array.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + array[j];
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int optimal(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int count = 0;
        for (int num : nums) {
            prefix += num;
            int need = prefix - k;
            if (map.containsKey(need)) {
                count += map.get(need);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        System.out.println(bruteForce(array, k));
        System.out.println(better(array, k));
        System.out.println(optimal(array,k));
    }
}



