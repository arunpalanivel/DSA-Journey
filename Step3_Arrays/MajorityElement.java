/**
 * 🧩 Problem #18 — Majority Element (Moore’s Voting Algorithm)
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 🔗 Related LeetCode Problem: #169 — Majority Element
 *
 * 📘 Problem Statement:
 * Given an array of size `n`, return the element that appears more than `n/2` times.
 * This element is guaranteed to exist.
 *
 * Example:
 * Input:  [2, 2, 1, 2, 2, 3]
 * Output: 2
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force (Nested Loops)
 *    - For every element, count its occurrences.
 *    - If count > n/2 → return element.
 *    - Time Complexity: O(n²)
 *    - Space Complexity: O(1)
 *
 * 2️⃣ Better (HashMap Frequency Count)
 *    - Use a HashMap to store frequency of each element.
 *    - Return the element whose frequency > n/2.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 *
 * 3️⃣ Optimal (Moore’s Voting Algorithm)
 *    - Maintain a `candidate` and a `count`.
 *    - If count becomes 0 → pick new candidate.
 *    - If number equals candidate → count++
 *      else → count--
 *    - The final candidate is the majority element.
 *
 *    🕒 Time Complexity: O(n)
 *    🧠 Space Complexity: O(1)
 *
 * 🎯 Why Moore’s Voting Works?
 * - Majority element appears more than half the time.
 * - All other elements combined cannot cancel its total frequency.
 *
 * 🧩 Example Walkthrough:
 * arr = [2,2,1,2,2,3]
 *
 * Candidate: 2 → Count increases
 * A few decrements happen, but 2 survives all cancellations.
 * Final Answer = 2
 *
 * 🌟 Key Notes:
 * - Moore's Algorithm gives the correct majority only when majority is guaranteed.
 * - If not guaranteed, a second pass is needed — but not required here.
 *
 * 📅 Date: 2025-11-XX
 * 🧑‍💻 Author: Arun Palanivel
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int bruteForce(int[] arr, int n){
        for(int i=0; i<n;i++){
            int count = 0;
            for (int j = 0; j<n;j++){
                if (arr[i] == arr[j]) count++;
            }
            if(count > n/2) return arr[i];
        }
        return -1;
    }

    public static int better(int[] arr, int n){
        HashMap<Integer,Integer> elements = new HashMap<>();

        for(int i=0; i<n;i++){
            int value = elements.getOrDefault(arr[i],0);
            elements.put(arr[i],value+1);
        }
        for(Map.Entry<Integer,Integer> values: elements.entrySet()){
            if(values.getValue() > n / 2) return values.getKey();
        }
        return -1;
    }

    public static int optimal(int[] arr, int n){
        int count = 0;
        int el = 0;
        for(int i=0;i<n;i++){
            if(count == 0) {
                el = arr[i];
                count++;
            }
            else if(arr[i] == el) count++;
            else count--;
         }
        return el;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,1,2,2,3};
        int n = arr.length;
        System.out.println(bruteForce(arr,n));
        System.out.println(better(arr,n));
        System.out.println(optimal(arr,n));
    }
}
