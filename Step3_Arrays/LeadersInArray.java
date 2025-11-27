/**
 * 🧩 Problem #22 - Leaders in an Array
 * Step: 3 (Arrays)
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force Approach (leaders):
 * - For every element arr[i], check all elements to its right.
 * - If no element on the right is greater than arr[i], it is a leader.
 * - Store such leaders and print them.
 *
 * 2️⃣ Optimal Approach (optimal):
 * - A leader is the element that is greater than all elements to its right.
 * - Traverse the array from the end while maintaining a running maximum.
 * - Every time arr[i] > current max, arr[i] is a leader.
 * - This gives leaders in reverse order, but still valid.
 *
 * ⚙️ Working Principle:
 * - Brute force checks “greater than all right elements” using nested loops.
 * - Optimal solution uses reverse traversal to pick leaders in O(n) time.
 *
 * 🧮 Time & Space Complexity:
 * - Brute Force:
 *   Time: O(n²) — for every element, check all elements on the right
 *   Space: O(n) — storing leaders
 *
 * - Optimal:
 *   Time: O(n) — single reverse traversal
 *   Space: O(n) — storing leaders
 *
 * 🔢 Example:
 * Input:  [10, 22, 12, 3, 0, 6]
 * Output: [22, 12, 6]
 *
 * 📅 Date: 2025-11-26
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class LeadersInArray {
    public static void leaders(int[] arr, int n){
        int[] leader = new int[n];
        int index = 0;

        for(int i=0;i<n;i++){
            boolean isLeader = true;
            for(int j=i+1;j<n;j++){
                if(arr[j] > arr[i]) {
                    isLeader = false;
                    break;
                }
            }

            if(isLeader) {
                leader[index] = arr[i];
                index++;
            }
        }
        for (int i=0;i<index;i++){
            System.out.print(leader[i] + " ");
        }
    }

    public static void optimal(int[] arr, int n){
        int[] leader = new int[n];
        int index = 0;
        int max = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(arr[i] > max) {
                max =arr[i];
                leader[index] = max;
                index++;
            }
        }
        for (int i=0;i<index;i++){
            System.out.print(leader[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        int n = arr.length;
        leaders(arr,n);
        System.out.println();
        optimal(arr,n);
    }
}
