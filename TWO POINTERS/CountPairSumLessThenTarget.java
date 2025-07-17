import java.util.Arrays;

// Problem: Count Pairs Whose Sum is Less than Target.
// Platform Available : Leetcode 2824 , GFG.
// Difficulty: Easy.
// Companies tag : Amzone , Google , Adobe , Goldman Sachs , Visa , DE shaw , Intuite , Fipkart
// Apple , Uber , Walmart Global Tech , Samsung , Curefit , Zomatao , Razorpay , Phonepay , Mesho
// Grow , Ola , FreshWork , Zensar , Accenture , Mindtree , L&T infotech , Masia School , gfg 
// Scaller , Coding Ninja's , Vedantu.

public class CountPairSumLessThenTarget {
    // TIME COMPLEXITY : O(N Log N + left < right).
    // SAPCE COMPLEXITY : O(1).
    public static int countPairs(int arr[],int target){
        // STEP 1 : SORT the array for applying two pointer.
        Arrays.sort(arr);

        // STEP 2 : Take a left or right pointer Initially.
        // left point 0 or right point n-1.
        int left = 0;
        int right = arr.length - 1;
        int count = 0;    // For Counting Pairs.

        // STEP 3 : Iterate untill left < right.
        while(left < right){
            // Take pair sum.
            int sum = arr[left] + arr[right];

            // sum < target add right - left into count because if that's
            // make pair previous element also make a pair because array
            // is sorted.
            if(sum < target){
                count+= (right - left);
                left++;
            }else{
                // Greate then equals.
                right--;
            }
        }

        // STEP 4 : Return pair count.
        return count;
    }
}
