// Problem: Sorted and Rotated Minimum.
// Platform Availaible : Leetcode - 153 , GFG.
// Difficulty: Easy.
// Companies tag : Amazone , Morgan Stanley , Microsoft , Samsung , Snapdeal , Adobe
// Times internet , Meta , Bloomberge , Apple , Google , Oracle , VMware.

public class SortedAndRotatedMinimum {
    // TIME COMPLEXITY : O(Log N).
    // SPACE COMPLEXITY : O(1).
    public static int findMin(int arr[]){
        // STEP 1 : Calculate start or end pointing 1idx  or lastidx.
        int start = 0;
        int end = arr.length - 1;
        int ans = Integer.MAX_VALUE;  // Store minimum ans.

        // STEP 2 : Apply binary search.
        while( start <= end ){
            // Optimization part if sorted.
            if(arr[start] <= arr[end]){
                ans = Math.min(ans , arr[start]);
                break;
            }
            
            // Calculate mid.
            int mid = start + (end - start) / 2;

            // Either left half or high half sorted.
            // consition arr[start] <= arr[mid] means left half sorted.
            if(arr[start] <= arr[end]){
                // Sorted evalte minimum.
                ans = Math.min(ans , arr[start]);
                start = mid + 1;   // eliminate left half looking right half.
            }else{
                // means right half sorted.
                ans = Math.min(ans , arr[mid]);
                end = mid  - 1;   // eliminate right half
            }
        }

        // return min val.
        return ans;
    }
}
