/**
 * 🧩 Problem #23 - Longest Consecutive Sequence
 * 🔢 LeetCode Problem: 128 (Longest Consecutive Sequence)
 * Step: 3 (Arrays)
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force Approach (bruteForce):
 * - For every element arr[i], check if arr[i] + 1 exists in the array using linear search.
 * - Keep increasing the count as long as consecutive numbers exist.
 * - Maintain the maximum length found so far.
 * - Extremely slow because each search is O(n).
 *
 * 2️⃣ Better Approach Using Sorting (better):
 * - Sort the array using Merge Sort (custom implementation).
 * - Iterate through sorted array and count streaks of consecutive numbers.
 * - Skip duplicates but break streaks when continuity is lost.
 * - Sorting makes this faster compared to brute force.
 *
 * 3️⃣ Optimal Approach Using HashSet (optimal):
 * - Insert all elements into a HashSet for O(1) lookup.
 * - A number is the “start” of a sequence if (num - 1) does NOT exist.
 * - From each valid start, count forward (num + 1, num + 2, …).
 * - Track the longest streak.
 * - This gives the best time complexity.
 *
 * ⚙️ Working Principle:
 * - Brute force repeatedly searches for every next number.
 * - Better approach removes search cost using sorting.
 * - Optimal approach identifies sequence starting points and expands only once.
 *
 * 🧮 Time & Space Complexity:
 * - Brute Force:
 *   Time: O(n²) — nested linear searches
 *   Space: O(1)
 *
 * - Better (Sorting):
 *   Time: O(n log n) — merge sort
 *   Space: O(1) or O(n) depending on sort implementation
 *
 * - Optimal:
 *   Time: O(n) — each number processed once
 *   Space: O(n) — HashSet
 *
 * 🔢 Example:
 * Input:  [102, 4, 100, 1, 101, 3, 2]
 * Output: 4
 * Explanation: Longest consecutive sequence → [1, 2, 3, 4]
 *
 * 📅 Date: 2025-11-28
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */



import java.util.HashSet;

public class LongestConsecutive {
    public static int bruteForce(int[] arr, int n){
        int longest = 1;
        for(int i=0;i<n;i++){
            int x = arr[i];
            int count = 1;
            while (linearSearch(arr, x + 1)){
                x++;
                count++;

            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
    public static boolean linearSearch(int[] arr, int num){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }

    public static int better(int[] arr, int n){
        MergeSort.mergesort(arr,0,n-1);
        int longest = 1;
        int counter = 0;
        int lastSmallest = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(arr[i]-1 == lastSmallest){
                lastSmallest = arr[i];
                counter++;
            }else if (arr[i] != lastSmallest) {
                counter = 1;
                lastSmallest = arr[i];

            }
            longest = Math.max(longest,counter);
        }
        return longest;
    }

    public static int optimal(int[] arr, int n){
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr) set.add(num);

        int longest = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int counter = 1;
                int currentNum = num;
                while (set.contains(currentNum+1)){
                    currentNum++;
                    counter++;
                }
                longest = Math.max(longest,counter);
            }

        }
        return longest;

    }

    public static void main(String[] args) {
        int[] arr = {102,4,100,1,101,3,2,1,1};
        int n = arr.length;
        System.out.println(bruteForce(arr,n));

        int[] arr1 = {1,2,1,2,1,2,3,4,3,100,101,100,102,101};
        int n1 = arr1.length;
        System.out.println(better(arr1,n1));

        int[] arr2 = {1,2,1,2,1,2,3,4,3,100,101,100,102,101};
        System.out.println(optimal(arr2,n1));

    }

}
