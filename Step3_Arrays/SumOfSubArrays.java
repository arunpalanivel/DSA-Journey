/**
 * 🧩 Problem #19 – Maximum Subarray Sum (Kadane’s Algorithm)
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 🔗 Related LeetCode Problem: #53 – Maximum Subarray
 *
 * 📘 Description:
 * Given an integer array, find the maximum possible sum of any contiguous subarray.
 * The subarray must contain at least one element.
 *
 * Example:
 *   Input:  [-2, -3, 4, -1, -2, 1, 5, -3]
 *   Output: 7
 *   Explanation: The subarray [4, -1, -2, 1, 5] has the maximum sum = 7
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (Three Loops)
 *    - Generate every possible subarray using 3 nested loops.
 *    - For each subarray, compute its sum and update the maximum.
 *    - Time Complexity: O(n³)
 *    - Space Complexity: O(1)
 *
 * 2️⃣ Better (Prefix-like Optimization, Two Loops)
 *    - Fix the start index and expand the subarray by moving the end index.
 *    - Accumulate the sum as you extend the subarray (avoid third loop).
 *    - Time Complexity: O(n²)
 *    - Space Complexity: O(1)
 *
 * 3️⃣ Optimal (Kadane’s Algorithm)
 *    - Iterate through the array maintaining a current running sum.
 *    - If the running sum becomes negative → reset it to zero.
 *    - Track the maximum running sum seen so far.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 *
 * 🔍 Why Kadane’s Works:
 * - Negative running sums only reduce future totals, so they are discarded.
 * - Positive sums are carried forward to improve the total of upcoming values.
 *
 * 🧠 Key Insight:
 * Kadane’s is one of the most famous DP/Greedy hybrid algorithms.
 * It appears frequently in:
 *    ✔ FAANG interviews
 *    ✔ Sliding window problems
 *    ✔ DP optimizations
 *    ✔ Any problem involving “maximum sum subarray”
 *
 * 🧩 Edge Cases:
 * - All negative numbers: Kadane’s still works because maxSum starts at Integer.MIN_VALUE.
 * - Single-element arrays.
 *
 * 📅 Date: 2025-11-17
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class SumOfSubArrays {
    public static int bruteForce(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }

    public static int better(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum,sum);
            }

        }
        return maxSum;
    }

    public static int optimal(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            maxSum = Math.max(maxSum,sum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        int n = arr.length;
        System.out.println(bruteForce(arr,n));
        System.out.println(better(arr,n));
        System.out.println(optimal(arr,n));
    }
}


