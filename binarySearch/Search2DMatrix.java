package binarySearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;
        int n = matrix[0].length - 1;
        while (i < j) {
            if (matrix[(i + j) / 2][0] <= target && matrix[(i + j) / 2][n] >= target) {
                i = j = (i + j) / 2;
            } else if (matrix[(i + j) / 2][0] < target && matrix[(i + j) / 2][n] < target) {
                i = ((i + j) / 2) + 1;
            } else if (matrix[(i + j) / 2][0] > target) {
                j = ((i + j) / 2) - 1;
            }
        }

        int p = 0, q = matrix[0].length - 1;

        while (p <= q) {
            if (matrix[i][(p + q) / 2] > target) {
                q = ((p + q) / 2) - 1;
            } else if (matrix[i][(p + q) / 2] < target) {
                p = ((p + q) / 2) + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
