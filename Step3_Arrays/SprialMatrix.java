/**
 * 🧩 Problem #26 - Spiral Matrix Traversal
 * 🔢 LeetCode Problem: 54 (Spiral Matrix)
 * Step: 3 (Arrays)
 *
 * 🧠 Approach Implemented:
 * - Use four boundary variables to simulate peeling layers of the matrix:
 *      top, bottom, left, right
 * - Move in four directions in each iteration:
 *      1) Left → Right  (top row)
 *      2) Top → Bottom  (right column)
 *      3) Right → Left  (bottom row)
 *      4) Bottom → Top  (left column)
 * - After each traversal, shrink the corresponding boundary.
 * - Continue until all layers are processed.
 *
 * ⚙️ Working Principle:
 * - The algorithm extracts elements in spiral form by narrowing down the
 *   boundaries after completing each side.
 * - Conditions ensure we don't re-traverse rows or columns when the matrix
 *   has uneven dimensions.
 *
 * 🧮 Time & Space Complexity:
 * - Time Complexity: O(m × n)
 *   (Every element is visited exactly once)
 * - Space Complexity: O(1) excluding the output
 *   (Result list stores all elements)
 *
 * 🔢 Example:
 * Input:
 *  [1, 2, 3]
 *  [4, 5, 6]
 *  [7, 8, 9]
 *
 * Output:
 *  [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * 📅 Date: 2025-11-30
 * 🧑‍💻 Author: Arun Palanivel
 * 🔗 Source: Striver’s A2Z DSA Sheet — Step 3 (Arrays)
 * 📂 Repository: https://github.com/arunpalanivel/DSA-Journey
 */



import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;

        while(top <= bottom && left <= right){
            for(int i=left;i<=right;i++){
                results.add(matrix[top][i]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                results.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i=right; i>= left;i--){
                    results.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i=bottom;i>=top;i--){
                    results.add(matrix[i][left]);
                }
                left++;
            }

        }
        return results;
    }

    public static void main(String[] args) {
        SprialMatrix sm = new SprialMatrix();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> result = sm.spiralOrder(matrix);
        System.out.println(result);
    }
}
