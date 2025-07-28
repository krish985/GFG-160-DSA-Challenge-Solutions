// Problem: Product Array Except Itself .
// Platform Availaible: Leetcode 238 , GFG
// Difficulty : Medium.
// Companies tag : Amazon , Google , Microsoft , Adobe ,, Meta , Neflix , Adobe 
// VMware , Cisco , Goldman sachs , DE-SHAW , Morgan Stanley , Accolite , Inyuite
// Flipkart , Opera.

public class ProductArrayExceptItself {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int[] productExceptSelf(int arr[]){
        // STEP 1 : Compute a product of whole array.
        // and also if any zero occured count that zero as well as idx.
        // if two zero occured whole array will 0.
        int zero = 0;
        int idx = -1;
        int product = 1;

        // STEP 2 : Iterate and compute.
        for(int i=0; i<arr.length; i++){
            // if zero occured increase count by 1.
            if(arr[i] == 0){
                zero++;
                idx = i;
            }else{
                // compute product.
                product*= arr[i];
            }
        }

        // STEP 3 : Create result array to store ans.
        int res[] = new int[arr.length];

        // STEP 4 : WE have three case.
        // 1. if zero == 0.
        if(zero == 0){
            // iterate over the original array and divide product and arr[i].
            for(int i=0; i<arr.length; i++){
                res[i] = product / arr[i];
            }
        }else if(zero == 1){
            // 2 case zero == 1.
             // One zero: only one position gets the product, rest stay zero
            res[idx] = product;
        }

        // STEP 5 : if zero > 1 return res as it is.
        return res;
    }
}
