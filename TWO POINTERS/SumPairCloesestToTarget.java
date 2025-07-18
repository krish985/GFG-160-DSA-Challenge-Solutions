import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem: Sum Pair closest to target.
// Platform Available : GFG.
// Difficulty : Easy.
// Companies tag : Amazone , Microsoft , SAP lab , Flipkart , Paytm , Visa , Zoho
// Oracle , Accenture , Deloitee.

public class SumPairCloesestToTarget {
    // TIME COMPLEXITY : O(N Log N).
    // SPACE COMPLEXITY : O(1).
    public static List<Integer> sumCloesest(int arr[] , int target){
        // STEP 1 : SORT THE ARRAY Because Applying Two Pointer.
        Arrays.sort(arr);

        // STEP 2 : Take a Left or Right pointer and Diffrence 
        // variable that track diff initially initialize by + infinity.
        int left = 0;
        int right = arr.length -1;
        int diff = Integer.MAX_VALUE;

        // STEP 3 : Create a List of integer that store pairs.
        List<Integer> ans = new ArrayList<>();

        // STEP 4 : iterate over the array.
        while(left < right){
            // Calculate pair sum or curr diff.
            int pairSum = arr[left] + arr[right];
            int currDiff = Math.abs(target - pairSum);

            // Condition if currDiff < diff update diff 
            // with minimum diff.
            if(currDiff < diff){
                diff = currDiff;
                // update ans.
                ans.clear();
                ans.add(arr[left]);
                ans.add(arr[right]);
            }

            // Condition for shrinking.
            if(pairSum < target) left++;
            else if(pairSum > target) right--;
            else {
                ans.clear();
                ans.add(arr[left]);
                ans.add(arr[right]);
                return ans;
            }

        }

        // STEP 5 : Return ans.
        return ans;
    }
}
