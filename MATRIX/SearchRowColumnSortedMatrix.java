// Problem: Search in a Row-Column sorted matrix.
// Platforms Available : Leetcode 240, GFG
// Difficulty:  Medium.
// Companies tag : Google , Amazone , Meta , Netflix , Apple , MicroSoft , Adobe , Salesforce
// Oracle , Intuite , VMware , Qualcomm , Nvidia , Flipkart , Paytm , Zomato , OyoRoom
// Swiggy , MakemyTrip , CureFit , BrowserStack , Razorpay , Phonepe , Inmobi , Zoho
// FreshWork , D.E. Shaw , Goldman Sachs , JP Morgan Chase , Morgan Stanley , Barclays
// HSBC , Citibank , American Express , Uber , Airbnb , Dropbox  , Atlassian , Stripe 
// Booking.com , Snapchat.

public class SearchRowColumnSortedMatrix {
    // TIME COMPLEXITY : O(M + N).
    // SPACE COMPLEXITY : O(1).
    public static boolean searchInMatrix(int matrix[][] ,int target){
        // Observation : If we stand top row last cell.
        // -> if that val > then target go one step back with same row.
        // -> if that val < then target go one step ahead with same col.

        // STEP 1 : Initialize variables.
        int m = matrix.length;    // row length
        int n = matrix[0].length; // col length
        int row = 0;    // point at first row.
        int col = n-1;   // point at first col.

        // STEP 2 : Iterate untill row < m && col >= 0.
        while(row < m && col >= 0){
            // equal to target return true.
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                // go next val col same row update.
                row++;
            }else if(matrix[row][col] > target){
                // go backward row same col decrease.
                col--;
            }
        }

        // STEP 3 : iF not able to found ans return false.
        return false;
    }
}