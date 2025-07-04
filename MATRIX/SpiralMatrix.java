import java.util.ArrayList;

// Problem: Spiral Matrix.
// Platforms Available : Leetcode 54 , GFG
// Difficulty:  Medium.
// Companies tag : Paytm , Flipkart , Morgan Stanley , Microsoft , OYO Rooms , Snapdeal
// D-E-Shaw , MakeMyTrip , Oracle , MAQ Software , Adobe , nearbuy , Nagarro ,BrowserStack 
// Salesforce , Zoho , Amazone , Google , Meta , Apple , Bloomberg , Intuite , Ebay
// Linkdin , SnapChat , Twitch , Uber , Visa , Walmart , Zillow , Cisco , Swiggy


public class SpiralMatrix {
    // TIME COMPLEXITY : O(row * col).
    // SPACE COMPLEXITY : O(row * col).
    public static ArrayList<Integer> spiralOrder(int matrix[][]){
        // STEP 1 : Create a Arraylist of interger that store spiral order.
        ArrayList<Integer> list = new ArrayList<>();

        // STEP 2 : Calculate row and col of matrix.
        int row = matrix.length;
        int col = matrix[0].length;

        // STEP 3 : Initialize pointers.
        int topRow = 0;
        int bottomRow = row - 1;
        int leftCol = 0;
        int rightCol = col - 1;
        int totalElement = 0;    // it tracks total element.

        // STEP 4 : Iterate untill you add (row * col) elemnt into list.
        // and every step also check (totalElemnt < (row * col)) because 
        // any point of time spiral complete why you are iterating.
        while(totalElement < (row * col)){
            // topRow --> leftCol to rightCol.
            for(int j=leftCol; j<=rightCol && totalElement < (row * col); j++){
                list.add(matrix[topRow][j]);
                totalElement++;
            }
            topRow++;   // Moved By + 1.

            // rightCol --> topRow to bottomRow.
            for(int i=topRow; i<=bottomRow && totalElement < (row * col); i++){
                list.add(matrix[i][rightCol]);
                totalElement++;
            }
            rightCol--;   // Decrease by 1.

            // bottomRow --> rightCol to leftCol.
            for(int j=rightCol; j>=leftCol && totalElement < (row * col); j--){
                list.add(matrix[bottomRow][j]);
                totalElement++;
            }
            bottomRow--;   // decrease by 1.

            // leftCol --> bottomRow to topRow.
            for(int i=bottomRow; i>=topRow && totalElement < (row * col); i--){
                list.add(matrix[i][leftCol]);
                totalElement++;
            }
            leftCol++;   // moved by 1.
        }

        // return spiral order list.
        return list;

    }
}
