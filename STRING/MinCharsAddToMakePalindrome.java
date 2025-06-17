// Problem: Minimum Characters to Add at Front for Palindrome.
// Link :https://www.geeksforgeeks.org/dsa/minimum-characters-added-front-make-string-palindrome/
// Difficulty: HARD.
// Companies tag : Amazon , Microsoft , Flipkart , Adobe , Walmart Labs , SamSung , DE SHAW
// Goldman Sachs , TCS Digital , Capgemini (elite) , Infosys (HackWithInfy).

public class MinCharsAddToMakePalindrome {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N) : because using lps array.
    public static void computeLps(String pat, int lps[]) {
        // Longest perfix suffix.
        // lps[i] = 0idx to i --> prefix and suffix length equal. that length will
        // your lps[i].

        // STEP 1 : lps[0] = 0.
        lps[0] = 0;
        int m = pat.length();
        int i = 1; // i go patern length.
        int length = 0; // it use for check suffix.

        // STEP 2 : iterate over pattern calculate lps.
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                // Found.
                length++;
                lps[i] = length;
                i++; // increment counter.
            } else {
                // length != 0 find j-1 lps.
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    // if j zero store 0 not found lps.
                    // move .
                    lps[i] = 0;
                    i++; // MOve counter.
                }
            }
        }
    }

    public static int minChar(String str) {
        // STEP 1 : form a reverse string.
        int n = str.length(); // Store original str length.
        StringBuilder rev = new StringBuilder(str).reverse();

        // STEP 2 : Form string original str # rev string.
        // abc -> abc#cba.
        str = str + "#" + rev.toString();

        // STEP 3 : compute lps of that string.
        int lps[] = new int[str.length()];
        computeLps(str, lps);

        // STEP 4 : calculate min char add to make palindrome.
        // do original str length - lps lastIdx length.
        return n - lps[lps.length - 1];
    }
}
