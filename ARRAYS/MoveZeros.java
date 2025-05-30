// Problem: Move Zeroes.
// Platform Available : LEETCODE - 283 , GFG.
// Difficulty: Easy.
// Companies tag : Paytm , Amazone , MicroSoft , SamSung , SapLabs , Linkdin , BloomBerg.

public class MoveZeros {
    public static void pushZeroToEnd(int arr[]) {
        // Time Complexity : O(N).
        // Space Complexity : O(1).

        // STEP 1: initialize j counter that will help to add non zero value first.
        int j = 0;

        // STEP 2 : iterate over the array and first fill non zero value.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++; // Move forward.
            }
        }

        // STEP 3 : Now add remaning value 0 j < arr.length.
        while (j < arr.length) {
            arr[j] = 0;
            j++;
        }
    }
}