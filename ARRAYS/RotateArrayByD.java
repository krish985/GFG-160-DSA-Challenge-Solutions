// Problem: Rotate an Array by d - Counterclockwise or Left.
// Link: https://www.geeksforgeeks.org/array-rotation/.
// Difficulty: Medium.
// Companies tag : Amazone , MicroSoft , MaqSoftware.

public class RotateArrayByD {
    // Time Complexity : O(n).
    // Space Complexity : O(1).
    public static void reverseArr(int nums[], int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;  // increament.
            end--;    // decrement.
        }
    }
    public static void rotateArr(int arr[] , int d){
        // Handle case where d > n.
        d = d % arr.length;

        // Step 1 : Reverse whole array.
        int n = arr.length;
        reverseArr(arr, 0, n-1);

        // Step 2 : reverse total length - k elemnt.
        reverseArr(arr, 0, n - 1 - d);

        // Step 3 : reverse last k elemnt.
        reverseArr(arr, n-d, n-1);
    }
    // Example input : 1 , 2 , 3 , 4 , 5  : d = 2.
    // STEP 1 :  5 , 4 , 3 , 2 , 1.
    // STEP 2 :  3 , 4 , 5 , 2 , 1.
    // STEP 3 :  3 , 4 , 5 , 1 , 2.  OUTPUT.

}
