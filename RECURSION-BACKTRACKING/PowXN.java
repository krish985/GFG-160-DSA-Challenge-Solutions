// Problem: Pow(x,n).
// Platform Availaible: Leetcode 50, GFG
// Difficulty : Medium.
// Companies tag : Google , Amazone , Microsoft , Meta , Apple , Flipkart , Ola 
// Zomato , Swiggy , Paytm , Alibaba , Tencent , ByteDance , Cisco , Adobe
// Bloomberg , Goldman Sachs.

public class PowXN {
    // TIME COMPLEXITY : O(LOG N).
    // SPACE COMPLEXITY : O(LOG N).
    public static double pow(double x , long n){
        // STEP 1 : Write Base Case if any point of time
        // n became 0 return 1.0 double.
        if(n == 0){
            return 1.0;
        }

        // STEP 2 : Everytime decrease n / 2 because in recursion
        // if i know about n / 2 simply multiply another n / 2 
        // and make = n.
        double half = pow(x, n/2);

        // STEP 3 : Backtracking steps.
        // if n is even multiple (half * half)
        if(n % 2 == 0){
            return half * half;
        }else{
            // do (half * half) * n
            return (half * half) * n;
        }
    }
    public static double calPow(double x , int n){
        // STEP 1 : Check n if it is negative change 
        // into long positive.
        if(n < 0){
            // Converting long because input ramge 2^31.
            long val = (long) n;
            val = Math.abs(val);
            
            // Call pow func divide 1.0 for reciprocal.
            return 1.0 / pow(x , val);
        }else{
            // make simple code.
            return pow(x , n);
        }
    }
}
