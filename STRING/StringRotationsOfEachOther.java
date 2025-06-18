// Problem: Check if Strings Are Rotations of Each Other.
// Platforms Available : Leetcode 796 , GFG
// Difficulty:  EASY & using KMP(HARD).
// Companies tag : Oracel , Amazon , Cisco , IBM , Microsoft.
// Tcs (digital).

public class StringRotationsOfEachOther {
    // TIME COMPLEXITY : O(N + M).
    // SPACE COMPLEXITY : O(M).
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

    public static boolean kmpSearch(String txt, String pat) {
        // STEP 1 : Calculate length
        int n = txt.length();
        int m = pat.length();

        // STEP 2 : Calculate lps of pat string.
        int lps[] = new int[pat.length()];
        computeLps(pat, lps);

        int i = 0;
        int j = 0;
        
        // STEP 3 : Pattern matching.
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    // found pattern
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        // Not found pattern.
        return false;
    }

    public static boolean areRotations(String s1, String s2) {
        // Main Function.
        // STEP 1 : Check both length != return false.
        if (s1.length() != s2.length()) {
            return false;
        }

        // STEP 2 : Create combined string s1 + s1.
        // if rotation exist present in combined string.
        // like : s1 : abcd = abcdabcd s2 : cdab.
        String combined = s1 + s1;
        return kmpSearch(combined, s2);
    }
}
