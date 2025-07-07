// Problem: Search in row wise sorted matrix.
// Problem Link : https://www.geeksforgeeks.org/dsa/search-in-matrix-where-only-individual-rows-are-sorted/
// Difficulty:  EASY.
// Companies tag: Amazon , Microsoft , Flipkart , Adobe , TCS Digital , Infosys , Wipro , Cognizant 
// Accenture , Capgemini , HCL

public class SearchInRowWiseSortedMatrix {
    // TIME COMPLEXITY : O(N * Log M).
    // SPACE COMPLEXITY : O(1).
    public static boolean binarySearch(int arr[], int target) {
        // Apply Standard Binary Search.
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            }
            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // Not found return false,
        return false;
    }

    public static boolean searchRowMatrix(int matrix[][], int target) {
        // STEP 1 : Apply Binary Search to find target in every row.
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target)) {
                // Found.
                return true;
            }
        }

        // STEP 2 : Not able to find return false.
        return false;
    }
}
