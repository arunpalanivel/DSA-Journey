/**
 * 🧩 Problem #04 - Remove Duplicates from a Sorted Array
 * 🔗 LeetCode Problem #26: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Step: 3 (Arrays)
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (Using LinkedHashSet):
 *    - Insert all array elements into a LinkedHashSet to automatically remove duplicates
 *      (it maintains insertion order as well).
 *    - Copy all unique elements back into the original array.
 *    - Return the count of unique elements.
 *    - Time Complexity: O(2n) ≈ O(n)
 *    - Space Complexity: O(n)
 *
 * 2️⃣ Optimal (Two-Pointer Technique):
 *    - Use two pointers: `i` (tracks unique element position) and `j` (scans the array).
 *    - Whenever a new unique element is found (arr[j] != arr[i]),
 *      increment `i` and replace arr[i] with arr[j].
 *    - At the end, (i + 1) gives the total count of unique elements.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 *
 * ⚙️ Additional Note:
 * - In **C++**, inserting into a `set` takes O(log n) time per element
 *   because it is implemented as a balanced binary search tree (Red-Black Tree).
 *   Therefore, total complexity = O(n log n + n).
 *
 * - In **Java**, `LinkedHashSet` is implemented using a hash table + linked list,
 *   providing O(1) average insertion time (amortized).
 *   Hence, total complexity = O(2n) ≈ O(n).
 *
 * 🔢 Example:
 * Input:  [1, 1, 1, 2, 2, 3, 3, 3, 3]
 * Output: 3
 * (Unique elements: [1, 2, 3])
 *
 * ⚙️ Explanation:
 * - Brute Force uses extra space (LinkedHashSet) but is simple and readable.
 * - The Optimal method modifies the array in-place without using any extra data structures.
 * - Both achieve the same result, but the in-place two-pointer approach is more efficient.
 *
 * 🧠 Note:
 * I had solved this same problem on LeetCode around 8 months ago,
 * and interestingly, the optimal logic remains exactly the same —
 * proving that once you understand patterns deeply, the best solution stays timeless.
 *
 * 📅 Date: 2025-11-09
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static int brute(int[] arr, int n){
        Set <Integer> set = new LinkedHashSet<Integer>();
        for(int i=0; i<n;i++){
            set.add(arr[i]);
        }
        int index = 0;
        for(int i : set){
            arr[index] = i;
            index++;
        }
        return index;
    }
    public static int removeDuplicates(int[] arr, int n){
        int i = 0;
        for(int j=1;j<n;j++){
            if(arr[j] != arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3,3};
        int n = arr.length;
        int result = removeDuplicates(arr,n);
        System.out.print("Unique Elements: " + result);
    }
}
