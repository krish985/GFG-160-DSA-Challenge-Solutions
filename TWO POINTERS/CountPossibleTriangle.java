import java.util.Arrays;

// Problem:  Valid Triangle Number .
// Platform Available : Leetcode 611 , GFG.
// Difficulty : Medium.
// Companies tag : Amazone , Microsoft , Google , Meta , Adobe , Intuite , Paytm
// Flipkart , Samsung , DE-SHAW , Citrix , TCS (Digital) , Wipro , HCL.

public class CountPossibleTriangle {
    // TIME COMPLEXITY : O(N ^ 2).
    // SPACE COMPLEXITY : O(1).
    public static int countTriangles(int nums[]){
        // STEP 1 : SORT The array beacuse Applying two pointer.
        Arrays.sort(nums);

        // STEP 2 : Take A count variable that count all posible
        // triangle like where a + b > c  that's the case.
        int count = 0;

        // STEP 3 : Iterate over the array from backward and considread
        // as a k and iterating k to 2 .
        for(int k = nums.length -1; k>=2; k++){
            // Take a pointer i and j k fixed for iteration.
            int i = 0;
            int j = k-1;   // j always k - 1.

            // Then apply 2 pointer aprroach find if two val sum > k
            // in that case store (j-i) into count.
            while(i < j){
                if(nums[i] + nums[j] > nums[k]){
                   // in that case add ( j - i ) beacuse if it is greater previous 
                   // value also be greater for moving forward.
                   count+= (j -i);
                   j--;   // Decrease j by 1.
                }else{
                    // it means < then nums[k]
                   i++; 
                }
            }
        }

        // STEP 4 : Return count.
        return count;
    }
}
