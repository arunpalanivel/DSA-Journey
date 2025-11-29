/**
 * 🧩 Problem #24 - Set Matrix Zeroes
 * 🔢 LeetCode Problem: 73 (Set Matrix Zeroes)
 * Step: 3 (Arrays)
 *
 * 🧠 Approaches Implemented:
 *
 * 1️⃣ Brute Force Approach (bruteForce):
 * - Scan the entire matrix.
 * - Whenever you find a 0, mark its entire row and column using a temporary value (-1).
 * - After marking, convert every -1 into 0.
 * - Because we mutate the matrix while traversing, the temporary marker prevents incorrect propagation.
 * - Time: O(m * n * (m + n)) due to marking.
 *
 * 2️⃣ Better Approach Using Extra Space (better):
 * - Maintain two arrays: row[m] and col[n].
 * - First pass: mark which rows and columns contain 0.
 * - Second pass: set matrix[i][j] = 0 if row[i] or col[j] is marked.
 * - Uses O(m + n) extra space.
 *
 * 3️⃣ Optimal Approach Using First Row & First Column as Markers (optimal):
 * - Instead of extra arrays, reuse the matrix itself.
 * - Use matrix[0][j] to mark zero columns and matrix[i][0] to mark zero rows.
 * - Track separately if the first row or first column originally contained a zero.
 * - Final pass: update cells based on markers.
 * - Time: O(m * n), Space: O(1).
 *
 * ⚙️ Working Principle:
 * - Brute Force repeatedly marks row/column with a temporary flag.
 * - Better uses external arrays to avoid re-traversal.
 * - Optimal reuses matrix's first row & column as storage to achieve constant space.
 *
 * 🧮 Time & Space Complexity:
 * - Brute Force:
 *   Time: O(m * n * (m + n))
 *   Space: O(1)
 *
 * - Better:
 *   Time: O(m * n)
 *   Space: O(m + n)
 *
 * - Optimal:
 *   Time: O(m * n)
 *   Space: O(1)
 *
 * 🔢 Example:
 * Input:
 *  [1, 1, 1]
 *  [1, 0, 1]
 *  [1, 1, 1]
 *
 * Output:
 *  [1, 0, 1]
 *  [0, 0, 0]
 *  [1, 0, 1]
 *
 * 📅 Date: 2025-11-26
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */

public class SetMatrixZeros {

    // -----------------------------------------------------
    // 1) BRUTE FORCE (Using -1 Marking)
    // -----------------------------------------------------
    public static void bruteForce(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 1) Mark rows and columns that contain a zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    markRows(i, n, matrix);
                    markColumns(j, m, matrix);
                }
            }
        }

        // 2) Convert all -1 markers to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void markRows(int row, int n, int[][] matrix) {
        for (int j = 0; j < n; j++) {
            if (matrix[row][j] != 0) {
                matrix[row][j] = -1;
            }
        }
    }

    public static void markColumns(int col, int m, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -1;
            }
        }
    }


    // -----------------------------------------------------
    // 2) BETTER APPROACH (O(m+n) space)
    // -----------------------------------------------------
    public static void better(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int[] col = new int[n];
        int[] row = new int[m];

        // Identify all zero positions
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Set marked rows & columns to zero
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }


    // -----------------------------------------------------
    // 3) OPTIMAL APPROACH (O(1) space)
    // -----------------------------------------------------
    public static void optimal(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row has any zero
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }

        // Check if first column has any zero
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }

        // Use first row/column as markers
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Apply markers to the matrix
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Zero the first row if needed
        if(firstRowZero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        // Zero the first column if needed
        if(firstColZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }


    // -----------------------------------------------------
    // Helper: Copy Matrix
    // -----------------------------------------------------
    public static int[][] copyMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] copy = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        return copy;
    }

    // -----------------------------------------------------
    // Helper: Print Matrix
    // -----------------------------------------------------
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }


    // -----------------------------------------------------
    // MAIN FUNCTION (Tests Better & Optimal)
    // -----------------------------------------------------
    public static void main(String[] args) {

        int[][] originalMatrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        // Create separate copies so each method runs independently
        int[][] matrixForBrute = copyMatrix(originalMatrix);
        int[][] matrixForBetter = copyMatrix(originalMatrix);
        int[][] matrixForOptimal = copyMatrix(originalMatrix);

        System.out.println("Original Matrix:");
        printMatrix(originalMatrix);

        // -------------------------------------------------
        // TEST BRUTEFORCE METHOD
        // -------------------------------------------------
        System.out.println("\n--- Testing BRUTEFORCE Method ---");
        bruteForce(matrixForBrute);
        printMatrix(matrixForBrute);

        // -------------------------------------------------
        // TEST BETTER METHOD
        // -------------------------------------------------
        System.out.println("\n--- Testing BETTER Method ---");
        better(matrixForBetter);
        printMatrix(matrixForBetter);

        // -------------------------------------------------
        // TEST OPTIMAL METHOD
        // -------------------------------------------------
        System.out.println("\n--- Testing OPTIMAL Method ---");
        optimal(matrixForOptimal);
        printMatrix(matrixForOptimal);
    }

}
