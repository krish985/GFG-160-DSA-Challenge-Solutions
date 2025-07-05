// Problem: Rotate By 90 Degree AntiClockwise.
// Platforms Available : Leetcode 48 (simmilar clockwise rotation) , GFG
// Difficulty:  Medium.
// Companies tag : Paytm , Microsoft , Samsung , Adobe , Oracle , Nagroo
// Makemytrip , Samsung R&D , Google , Flipkart.

public class RotateBy90Degree {
    // TIME COMPLEXITY : O(N^2).
    // SPACE COMPLEXITY : O(1).
    public static void transpose(int matrix[][]){
        // Tanspose means Row became column.
        // Row equavalient to column.
        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix.length; j++){
                // Swap values.
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void revByColumn(int matrix[][]){
        // Reverse ervery column.
        int n = matrix.length;
        for(int col=0; col < n; col++){
            // take top or bottom idx.
            int top = 0;
            int bottom = n-1;
            while(top < bottom){
                // swap.
                int temp = matrix[top][col];
                matrix[top][col] = matrix[bottom][col];
                matrix[bottom][col] = temp;

                // then move pointers.
                top++;
                bottom--;
            }
        }
    }
    public static int[][] rotateAntiClockWise(int matrix[][]){
        // STEP 1 : Transpose the matrix.
        transpose(matrix);

        // STEP 2 : Reverse matrix by column.
        revByColumn(matrix);

        // STEP 3 : return matrix.
        return matrix;
    }
}
