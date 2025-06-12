// Problem: String to Integer (atoi)
// Platform Available : Leetcode - 8 , GFG.
// Difficulty: Medium.
// Companies tag : Morgan Stanley , Amazon , Microsoft , Payu , Adobe , Code Brew , Cisco
// Google , Samsung.

public class ImplementATOI {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int myAtoi(String str) {
        // STEP 1 : Removing leading whitespace.
        str = str.trim();

        // STEP 2 : Create a Sign varaible that track sign either
        // positive or negative.
        int sign = 1; // initially it represent '+'.

        // STEP 3 : initialize res variable that hold integer val.
        // take long because we are handeling excede 32 bit integer.
        long res = 0;
        int i = 0;

        // Edge Case.
        if (str.length() == 0)
            return 0;

        // STEP 4 : Check any sign occured.
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            // Update sign.
            sign = (str.charAt(i) == '-') ? -1 : 1;
            i++; // Move.
        }

        // STEP 5 : iterate i < str.length and also the character is digit check.
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            // Extract digit.
            int digit = str.charAt(i) - '0';

            // Form res.
            res = (res * 10) + digit;

            // Check integer out of 32 bit integer check for.
            if ((sign * res) > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if ((sign * res) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++; // Move forward.
        }

        // STEP 6 : return ans convert into int.
        return (int) res * sign;
    }
}