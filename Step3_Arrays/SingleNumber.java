/**
 * 🧩 Problem #13 – Single Number (Find the Unique Element)
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 🔗 Related LeetCode Problem: #136 – Single Number
 *
 * 📘 Description:
 * Given an array of integers where every element appears twice except for one,
 * find the element that appears exactly once.
 *
 * ⚙️ Example:
 * Input:  [1, 1, 2, 3, 3, 4, 4]
 * Output: 2
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (Nested Loops)
 *    - For each element, count its frequency by scanning the entire array.
 *    - If the count == 1, that’s the unique element.
 *    - Time Complexity: O(n²)
 *    - Space Complexity: O(1)
 *
 * 2️⃣ Optimal (XOR Property)
 *    - XOR of two identical numbers cancels out (a ^ a = 0).
 *    - XOR of any number with 0 remains the same (a ^ 0 = a).
 *    - Therefore, XORing all elements gives the unique one.
 *    - Example: 1 ^ 1 ^ 2 ^ 3 ^ 3 ^ 4 ^ 4 = 2
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 *
 * ⚡ Bitwise Insight:
 * - XOR is both commutative and associative.
 * - This makes the order of operations irrelevant — so we can XOR all numbers in one pass.
 *
 * 🧩 Edge Cases:
 * - Single-element array → return that element directly.
 * - All pairs except one unique → always works.
 *
 * 🧠 Concept Strengthened:
 * - Bit Manipulation (XOR trick)
 * - Frequency counting vs. optimized bitwise logic
 *
 * 📅 Date: 2025-11-12
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class SingleNumber {
    public static int bruteForce(int[] arr, int n){
        int num = 0;
        for(int i=0; i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[j] == arr[i]){
                    count += 1;
                }
            }
            if (count == 1){
                num =  arr[i];
            }
        }
        return num;
    }

    public static int optimal(int[] arr, int n){
        int xor = 0;
        for (int i:arr){
            xor = xor ^ i;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] arr ={1,1,2,3,3,4,4};
        int n = arr.length;
        System.out.println("The single number: " +bruteForce(arr,n));
        System.out.println("The single number: " +optimal(arr,n));


    }
}
