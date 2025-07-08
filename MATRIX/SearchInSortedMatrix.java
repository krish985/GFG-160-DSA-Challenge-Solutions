// Problem : Search in Sorted 2d Matrix.
// PlatForm Availabel : Leetcode - 74 , GFG.
// Difficulty :  Medium.
// Companies tag : Amazon, Google, Microsoft, Facebook, Apple, Adobe, Oracle, Samsung, Flipkart
// TCS Digital, Infosys, Wipro, Cognizant, Accenture, Capgemini, HCL, PayPal, Walmart Labs, Zoho
// LinkedIn, Intuit, Atlassian, Salesforce, Cisco, Goldman Sachs, JPMorgan Chase, Uber, Twitter
// ByteDance, TikTok, Bloomberg, Nvidia, IBM, Dell, SAP, Expedia, Booking.com, ZS Associates
// Mindtree, Tech Mahindra, DXC Technology, LTI, Mu Sigma, Nagarro, ThoughtWorks, Deloitte

public class SearchInSortedMatrix {
    // TIME COMPLEXITY : O(Log (m*n)).
    // SPACE COMPLEXITY : O(1).
    public static boolean searchInRow(int arr[],int target){
        // STEP 1 : Apply typical Binary Search.
        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            // Calculate mid.
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                // Found.
                return true;
            }else if(target < arr[mid]){
                start = mid + 1;
            }else if(target > arr[mid]){
                end = mid - 1;
            }
        }
        // Not able to found return false.
        return false;
    }
    public static boolean searchInMatrix(int matrix[][],int target){
        // STEP 1 : Calculate row and col.
        int row = matrix.length;
        int col = matrix[0].length;
        int startRow = 0;
        int endRow = row - 1;

        // STEP 2 :  Apply Binary Serach on 2D matrix.
        while(startRow <= endRow){
            // Calculate midRow.
            int midRow = startRow + (endRow - startRow) / 2;

            // check value lie between midRow range compare with
            // starting cell or ending cell.
            if(matrix[midRow][0] <= target && target <= matrix[midRow][col-1]){
                // Means value lie between this range if available return true
                // else false.
                return searchInRow(matrix[midRow],target);
            }
            // target < first mid cell.
            if(target < matrix[midRow][0]){
                // Move Up.
                endRow = midRow - 1;  
            }else if(target > matrix[midRow][0]){
                // Move down
                startRow = midRow + 1;
            }
        }

        // STEP 3 : Not able To Found.
        return false;
    }
}
