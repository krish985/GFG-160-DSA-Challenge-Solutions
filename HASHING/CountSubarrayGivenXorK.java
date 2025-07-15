import java.util.HashMap;

// Problem: SubArray Sum Equals XOR k.
// Problem Link :  https://www.geeksforgeeks.org/dsa/count-number-subarrays-given-xor/
// Difficulty: Medium.
// Companies tag : Amazone , Microsoft , Adobe , Google , Flipkart Walmart labs
// Samsung , Paytm , Ola Cabs , Zoho , Goldman sachs , Curefit.

public class CountSubarrayGivenXorK {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static int subarrayXor(int arr[] , int k){
        // STEP 1 : Create a Hashmap that store prefixXor
        // and their frequency.
        HashMap<Integer,Integer> map = new HashMap<>();

        // Edge Case : if prefixXor ^ k in that's case.
        map.put(0, 1);

        // STEP 2 : Initialize some variable.
        int prefixXor = 0;
        int countSubarray = 0;

        // STEP 3 : Iterate over the array.
        for(int i=0; i<arr.length; i++){
            // compute prefixXor or complement.
            prefixXor^= arr[i];
            int complement = prefixXor - k;

            // If complement exist add into countsubarray their frequency.
            if(map.containsKey(complement)){
                countSubarray+= map.get(complement);
            }

            // add prefixXor into map if exist store freq by 1.
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        // STEP 4 : Return ans.
        return countSubarray;
    }
}
