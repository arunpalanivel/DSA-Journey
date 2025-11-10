/**
 * 🧩 Problem #11 – Find the Missing Number in an Array
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 🔗 Related LeetCode Problem: #268 – Missing Number
 *
 * 📘 Description:
 * You are given an array `arr` containing `n-1` distinct integers
 * in the range [1, n]. Find the missing number.
 *
 * ⚙️ Example:
 * Input:  arr = [1, 2, 3, 4, 6], n = 6
 * Output: 5
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force:
 *    - For every number `i` from 1 to n:
 *        → Check if it exists in the array using a nested loop.
 *        → If not found, return `i` as the missing number.
 *    - Time Complexity: O(n²)
 *    - Space Complexity: O(1)
 *
 * 2️⃣ Optimal (Mathematical Formula – Sum Approach):
 *    - The sum of the first n natural numbers is given by:
 *         S₁ = n × (n + 1) / 2
 *    - Compute the actual sum of all elements (S₂).
 *    - The missing number = S₁ – S₂
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 *
 * ✅ Key Observations:
 * - Works efficiently for large n.
 * - Relies on the mathematical property of natural numbers.
 * - No need for sorting or extra space.
 *
 * 🧩 Edge Cases:
 * - Missing first element → e.g., [2,3,4,5] → 1
 * - Missing last element → e.g., [1,2,3,4] → 5
 * - n = 1 → Output 1
 *
 * 🔢 Example Walkthrough:
 * arr = [1, 2, 3, 4, 6], n = 6
 * Expected sum S₁ = 21
 * Actual sum S₂ = 16
 * Missing number = 21 - 16 = 5 ✅
 *
 * 📅 Date: 2025-11-11
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class MissingNumber {
    public static int bruteForce(int[] arr, int n){
        int result = 0;
        for(int i=1;i<=n;i++){
            int flag = 0;
            for(int j=0;j<n-1;j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                result = i;
                break;
            }
        }
        return result;
    }

    public static int optimal(int[] arr, int n){
        int s1 = (n*(n+1)/2);
        int s2 = 0;
        for(int i=0;i<n-1;i++){
            s2+= arr[i];
        }
        return s1-s2;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6};
        int n = 6;
        int result = bruteForce(arr,n);
        System.out.print("Missing Number: " + result);
        System.out.println();
        int result1 = optimal(arr,n);
        System.out.print("Missing Number: " + result1);
    }
}
