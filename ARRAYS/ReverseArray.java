// Problem: Reverse  An Array.
// Link: https://www.geeksforgeeks.org/problems/reverse-an-array/1
// Difficulty: Easy.
// Companies tag : BloomBerg , TCS , Meta , Adobe , Google , Infosys ,Uber.
// Capgemini , Morgan Stanley , Amazone , Microsoft , Apple , Paypal.

public class ReverseArray{
    // Time Complexity O(n).
    // Space Complexity O(1).
    public static void reverseArr(int arr[]){
        
        // STEP 1 : initialize variable left or right.
        // where right move backward or left move forward.
        // and swap value until left < right.

        int left = 0;               // point first idx.
        int right = arr.length-1;  // point last idx.

        while(left <=  right){
            // Swap value.
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // STEP 2 : Move both pointer.
            left++;   // forward.
            right--;  // backward.
        }
    }
}