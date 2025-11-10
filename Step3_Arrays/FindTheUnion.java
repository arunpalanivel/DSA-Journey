/**
 * 🧩 Problem #09 – Find the Union of Two Sorted Arrays
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 *
 * 📘 Description:
 * Given two sorted arrays `arr1` and `arr2`, find their union.
 * The union should contain all unique elements from both arrays in sorted order.
 *
 * ⚙️ Example:
 * Input:
 *   arr1 = [1, 1, 2, 3, 3, 4, 5, 5]
 *   arr2 = [2, 3, 4, 5, 6]
 * Output:
 *   [1, 2, 3, 4, 5, 6]
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (Using Set)
 *    - Insert all elements of both arrays into a LinkedHashSet.
 *    - LinkedHashSet removes duplicates and preserves insertion order.
 *    - Convert the set to a list or print directly.
 *    - Time Complexity: O(n1 + n2)
 *    - Space Complexity: O(n1 + n2)
 *
 * 2️⃣ Optimal (Two-Pointer Technique)
 *    - Since both arrays are sorted:
 *      - Use two pointers `i` and `j`.
 *      - Compare arr1[i] and arr2[j]:
 *         - Add the smaller one to the result (if not duplicate).
 *         - Move the corresponding pointer.
 *      - Continue until both arrays are traversed.
 *    - Time Complexity: O(n1 + n2)
 *    - Space Complexity: O(1) (if we print directly)
 *
 * ✅ Key Observations:
 * - Duplicates are skipped by checking the last added element in the result.
 * - This two-pointer logic is reusable for merge, intersection, and difference operations too.
 *
 * 🧩 Edge Cases:
 * - One array empty → return the other.
 * - All elements same → output single unique element.
 * - Different lengths → works seamlessly.
 *
 * 🔢 Example Walkthrough:
 * arr1 = [1, 2, 3]
 * arr2 = [2, 3, 4]
 * → Union = [1, 2, 3, 4]
 *
 * 📅 Date: 2025-11-11
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


import java.util.*;

public class FindTheUnion {
    public static void bruteForce(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        Set<Integer> set = new LinkedHashSet<Integer>();

        for(int i: arr1){
            set.add(i);
        }
        for(int i: arr2){
            set.add(i);
        }
        List<Integer> union = new ArrayList<>(set);
        System.out.print("Union: " + union);

    }
    public static void optimal(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;

        List<Integer> union = new ArrayList<>();

        while (i<n1 && j<n2){
            if(arr1[i] <= arr2[j]){
                if(union.isEmpty() || union.get(union.size() -1) != arr1[i] ){
                    union.add(arr1[i]);
                }
                i++;
            }
            else{
                if(union.isEmpty() || union.get(union.size() -1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++;

            }
        }
        while (i<n1){

            if(union.isEmpty() || union.get(union.size() -1) != arr1[i] ) {
                union.add(arr1[i]);
            }
            i++;

        }
        while (j<n2){
            if(union.isEmpty() || union.get(union.size() -1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++;

        }
        System.out.println("Union of Two Sorted Arrays: " + union);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,3,4,5,5};
        int[] arr2 = {2,3,4,5,6};
        bruteForce(arr1,arr2);
        System.out.println();
        optimal(arr1,arr2);

    }

}
