/**
 * 🧩 Problem #25 - Rotate Matrix by 90° Clockwise
 * 🔢 LeetCode Problem: 48 (Rotate Image)
 * Step: 3 (Arrays)
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force Approach (bruteForce):
 * - Create a new matrix `result[n][n]`.
 * - For every element matrix[i][j], place it at position:
 *      result[j][(n - 1) - i]
 * - This shifts rows into columns to achieve a 90° clockwise rotation.
 * - Finally, print the `result` matrix.
 * - Uses extra space proportional to n².
 *
 * 2️⃣ Optimal Approach (optimal):
 * - Do the rotation **in-place** without extra matrix.
 *
 * ✨ Step 1: Transpose the matrix
 * - Swap matrix[i][j] with matrix[j][i] for all i < j.
 * - This converts rows into columns.
 *
 * ✨ Step 2: Reverse every row
 * - Reverse each row to complete the 90° clockwise rotation.
 *
 * - This approach is the most efficient and uses **O(1) extra space**.
 *
 * ⚙️ Working Principle:
 * - Brute force simulates rotation using a second matrix.
 * - Optimal uses the well-known transpose + reverse technique.
 *
 * 🧮 Time & Space Complexity:
 * - Brute Force:
 *   Time: O(n²)
 *   Space: O(n²)
 *
 * - Optimal:
 *   Time: O(n²)
 *   Space: O(1)
 *
 * 🔢 Example:
 * Input:
 *  [ 1  2  3  4 ]
 *  [ 5  6  7  8 ]
 *  [ 9 10 11 12 ]
 *  [13 14 15 16 ]
 *
 * Output:
 *  [13  9  5  1 ]
 *  [14 10  6  2 ]
 *  [15 11  7  3 ]
 *  [16 12  8  4 ]
 *
 * 📅 Date: 2025-11-30
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */


public class RotateMatrix {
    public static void bruteForce(int[][] matrix){
        int n = matrix.length;
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[j][(n-1)-i] = matrix[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j] + " ");

            }
            System.out.println();
        }
    }


    public static void optimal(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<=n-2;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }
    public static void reverse(int[] array){
            int start = 0;
            int end = array.length-1;
            while (start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;

            }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11,12},
                {13,14,15,16}
        };
        bruteForce(matrix);
        System.out.println();
        optimal(matrix);
    }
}
