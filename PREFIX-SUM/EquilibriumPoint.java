// Problem: Equilibrium Point .
// Platform Available : Leetcode 724 , GFG.
// Difficulty : Easy.
// Companies tag : Amazon , Adobe , Google , Facebook , Microsoft , Uber , TCS , Infosys 
// Capgemini , Congnizant , Acceneture , Paytm , Goldman Sachs , Walmart Labs.

public class EquilibriumPoint {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int findEquilbrium(int arr[]){
        // STEP 1 : Calculate the sum of all element in given array.
        int totalSum = 0;

        for(int i=0; i<arr.length; i++){
            totalSum+= arr[i];
        }

        // STEP 2 : Take a left sum variable that track running left sum
        // and totalSum act like a right sum.
        int leftSum = 0;

        // STEP 3 : Iterate over the array.
        for(int i=0; i<arr.length; i++){
            // subtract curr val arr[i] to total sum because if we subtract 
            // it will give right sum.
            totalSum-= arr[i];

            // if any point of time (leftSum == rightSum) return i.
            if(leftSum == totalSum){
               return i;
            }

            // now add curr val into left sum .
            leftSum+= arr[i];
        }

        // STEP 4 : If not found equilibriam point return -1.
        return -1;
    }
}