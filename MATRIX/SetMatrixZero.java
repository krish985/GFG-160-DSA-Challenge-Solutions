// Problem : Set Matrix Zeroes.
// PlatForm Availabel : Leetcode - 73 , GFG.
// Difficulty :  Medium.
// Companies Tag : Amazone , Microsoft , Apple , Meta , Nvidia , Adobe , Oracle
// Samsung , Flipkart , Paypal , Intuite , Uber , Goldman Sachs , Jp Morgan.

public class SetMatrixZero {
    // TIME COMPLEXITY : O(m * n).
    // SPACE COMPLEXITY : O(1) (in-place, no extra space)
    public static void setZeroes(int matrix[][]) {
        // STEP 1 : First row and first col use for track zero.
        // but 0,0 it's overlapp sitution that's why we track through
        // variable.
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstCellZero = false; // Initially that's indicate ! zero.

        // STEP 2 : Iterate over the matrix and fill if it is zero make row or col
        // to be zero.
        for (int i = 0; i < row; i++) {
            // it is zero mark true.
            if (matrix[i][0] == 0) {
                firstCellZero = true;
            }
            for (int j = 1; j < col; j++) {
                // if cell is zero keep track.
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;    // Mark row.
                    matrix[0][j] = 0;    // Make col.
                }
            }
        }

        // STEP 3 : Iterate again if it is zero make all the row and col zero.
        // iterate from row 1 col 1.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    // make all row and col to be zero.
                    matrix[i][j] = 0;
                }
            }
        }

        // STEP 4 : Handeling Edge Case.
        // first cell original zero make entier row to be zero.
        if (matrix[0][0] == 0) {
            // iterate first col to end col.
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        // STEP 5 : firstCell zero is true make entire col to be zero.
        if (firstCellZero) {
            // iterate first row to last row.
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
