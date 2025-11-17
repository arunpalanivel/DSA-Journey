/**
 * 🧩 Problem #20 – Rearrange Array Elements by Sign
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 🔗 Related LeetCode Problem: #2149 – Rearrange Array Elements by Sign
 *
 * 📘 Description:
 * Given an array with an equal number of positive and negative integers:
 * Rearrange the array so that:
 *   - Positive numbers appear at even indexes (0,2,4,..)
 *   - Negative numbers appear at odd indexes (1,3,5,..)
 *
 * The order of positives and negatives must remain the same as in the original array.
 *
 * Example:
 *   Input:  [3, 1, -2, -5, 2, -4]
 *   Output: [3, -2, 1, -5, 2, -4]
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (Using Two Temporary Arrays)
 *    - Create two arrays to separately store positive and negative numbers.
 *    - Fill positives[] and negatives[] by scanning the original array.
 *    - Reconstruct the original array:
 *         - Even indexes → positive elements
 *         - Odd indexes  → negative elements
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 *
 * 2️⃣ Optimal (Single Pass + Position Tracking)
 *    - Create a temporary result array `temp[]` of size n.
 *    - Maintain:
 *         positiveIndex = 0 (even positions)
 *         negativeIndex = 1 (odd positions)
 *    - Scan through the array once:
 *         - Place positives at positiveIndex and increment by +2
 *         - Place negatives at negativeIndex and increment by +2
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 *
 * 🔍 Why This Works:
 * - The array is guaranteed to have an equal number of positives and negatives.
 * - Index stepping by +2 ensures perfect alternation.
 * - Stable ordering is maintained since elements are placed in the same sequence they appear.
 *
 * 🧩 Edge Cases:
 * - Already alternating → remains unchanged.
 * - All positives first → still rearranged correctly.
 * - Array size always even (as per problem constraints).
 *
 * 🧠 Key Insight:
 * This pattern (pos at even, neg at odd) appears in many DSA problems.
 * Mastering the index-control technique (i += 2) is essential for future array rearrangement questions.
 *
 * 📅 Date: 2025-11-17
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class RearrangeElements {

    public static int[] brute(int[] nums) {
        int n = nums.length;
        int k = 0;
        int j = 0;
        int[] positives = new int[n/2];
        int[] negatives = new int[n/2];

        for(int i=0; i<n;i++){
            if(nums[i] >= 0){
                positives[k] = nums[i];
                k++;
            }
            else{
                negatives[j] = nums[i];
                j++;
            }
        }

        k = 0;
        j = 0;
        for(int i=0;i<n;i++){
            if(i % 2 == 0){
                nums[i] = positives[k];
                k++;
            }
            else{
                nums[i] = negatives[j];
                j++;
            }
        }
        return nums;
    }
    public static int[] optimal(int[] nums) {

        int positive = 0;
        int negative = 1;
        int[] temp = new int[nums.length];

        for(int i=0; i<nums.length;i++){
            if(nums[i] >= 0){
                temp[positive] = nums[i];
                positive +=2;
            }
            else{
                temp[negative] = nums[i];
                negative +=2;
            }
        }


        return temp;
    }

    public static void display(int[] arr, int n){
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        int[] resultArray = brute(arr);
        display(resultArray, resultArray.length);
        System.out.println();
        int[] resultArray2 = optimal(arr);
        display(resultArray2,resultArray2.length);

    }
}


