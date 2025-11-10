/**
 * 🧩 Problem #10 – Intersection of Two Sorted Arrays
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 *
 * 📘 Description:
 * Given two sorted arrays `arr1` and `arr2`, return their intersection.
 * Each element in the result must appear as many times as it shows in both arrays.
 *
 * ⚙️ Example:
 * Input:
 *   arr1 = [1, 1, 2, 3, 3, 4, 5, 5]
 *   arr2 = [2, 3, 4, 5, 6]
 * Output:
 *   [2, 3, 4, 5]
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force:
 *    - For each element in `arr1`, traverse `arr2` to find a match.
 *    - Use a temporary marker array (`temp`) to mark already matched elements.
 *    - If a match is found, add it to the intersection list and break.
 *    - Time Complexity: O(n1 × n2)
 *    - Space Complexity: O(n2)
 *
 * 2️⃣ Optimal (Two-Pointer Technique):
 *    - Since both arrays are sorted:
 *      - Initialize two pointers `i` and `j` at 0.
 *      - Traverse both arrays simultaneously:
 *          - If arr1[i] < arr2[j] → increment i
 *          - If arr1[i] > arr2[j] → increment j
 *          - If arr1[i] == arr2[j] → add element to intersection and move both pointers
 *    - This ensures all common elements are captured efficiently.
 *    - Time Complexity: O(n1 + n2)
 *    - Space Complexity: O(1) (excluding output list)
 *
 * ✅ Key Observations:
 * - Works only if arrays are **sorted** (as per problem statement).
 * - Avoids duplicates automatically since traversal respects ordering.
 * - More memory-efficient compared to brute-force.
 *
 * 🧩 Edge Cases:
 * - One array empty → returns empty intersection.
 * - No common elements → returns empty list.
 * - Arrays with duplicates → handles correctly due to pointer logic.
 *
 * 🔢 Example Walkthrough:
 * arr1 = [1, 2, 3, 4]
 * arr2 = [2, 4, 6]
 * → Intersection = [2, 4]
 *
 * 📅 Date: 2025-11-11
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

import java.util.ArrayList;
import java.util.List;


public class IntersectionOfSorted {
    public static void bruteForce(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] temp = new int[n2];
        List<Integer> intersection = new ArrayList<>();

        for(int i=0;i<n1;i++){
            for(int j=0; j<n2;j++){
                if(arr1[i] == arr2[j] && temp[j] == 0){
                    intersection.add(arr2[j]);
                    temp[j] = 1;
                    break;
                }
                if(arr2[j] > arr1[i]){
                    break;
                }
            }
        }
        System.out.print("Intersection of Two Sorted Arrays: " + intersection);
    }

    public static void optimal(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        List<Integer> intersection = new ArrayList<>();

        while (i<n1 && j<n2){
            if(arr1[i] < arr2[j]) i++;
            else if (arr1[i] > arr2[j]) j++;
            else {
                intersection.add(arr2[j]); // arr[i]
                j++;
                i++;// i++ as well
            }
        }
        System.out.print("Intersection of Two Sorted Arrays: " + intersection);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,3,4,5,5};
        int[] arr2 = {2,3,4,5,6};
        bruteForce(arr1,arr2);
        System.out.println();
        optimal(arr1,arr2);
    }
}
