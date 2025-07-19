// Problem: 2 Sum - Count Pairs with given Sum in Sorted Array.
// Platform Available : https://www.geeksforgeeks.org/dsa/count-pairs-with-given-sum-in-sorted-array/.
// Difficulty : Easy.
// Companies tag : Adobe , Oracle , Samsung , Walmart labs , Paytm , Google.

public class PairSumInSortedArray {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int findAllPair(int arr[],int target){
        // STEP 1 : Take a left or right pointer right stand
        // for 0 idx and left would be n-1.
        int left = 0;
        int right = arr.length -1;
        int count = 0;    // It track pairs count.

        // STEP 2 :  untill left < right.
        while(left < right){
            // Calculate sum.
            int sum = arr[left] + arr[right];
            // Condition.
            if(sum < target){
                left++;  // Move forward.
            }else if(sum > target){
                right--;  // Move backward.
            }else{
                // preseve left or right val.
                int el1 = arr[left];
                int el2 = arr[right];
                int cnt1 = 0;
                int cnt2 = 0;

                // Count Duplicate from right.
                while(left <= right && arr[left] == el1){
                    cnt1++; left++;
                }

                // Count duplicate from left.
                while(right >= left && arr[right] == el2){
                    cnt2++; right--;
                }

                // if el1 == el2 apply nc2.
                if(el1 == el2){
                    count+= cnt1*(cnt1-1)/2;
                }else{
                    // simply store pair.
                    count+= cnt1*cnt2;
                }
            }
        }

        // STEP 3 : Return count of pairs.
        return count;
    }
}
