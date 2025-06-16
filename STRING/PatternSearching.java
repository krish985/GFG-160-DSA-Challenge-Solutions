import java.util.ArrayList;
// Problem: KMP Algorithm for Pattern Searching.
// Link :https://www.geeksforgeeks.org/dsa/kmp-algorithm-for-pattern-searching/
// Difficulty: HARD.
// Companies tag : Google , Amazon , Microsoft , Meta , Adobe , Linkdin , Salesforce
// oracle , Zoho , Curefit.

public class PatternSearching {
    // TIME COMPLEXITY : O(N + M) : n traversing txt m for calculate lps.
    // SPACE COMPLEXITY : O(M) : storeing pattern lps.
    public static void evaluteLPS(String pat, int lps[]) {
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

    public static ArrayList<Integer> search(String txt, String pat) {
        // STEP 1 : Calculate size of string.
        int n = txt.length();
        int m = pat.length();

        // STEP 2 : Calculate lps of pat string.
        int lps[] = new int[m];

        evaluteLPS(pat, lps); // Call func to calculate.

        // STEP 3 : Craete pointer i and j and Arraylist to store ans.
        int i = 0; // tracks txt.
        int j = 0; // tracks pat.
        ArrayList<Integer> result = new ArrayList<>();

        // STEP 4 : Iterate txt.length.
        while (i < n) {
            // if both word are equal move forward.
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                // if any point of time j reach m it means found first.
                // pattern return their starting idx.
                if (j == m) {
                    result.add(i - j); // it give starting idx.
                }

            } else {
                // Avoiding restarting from screatch.
                // if it is not equal.
                if (j != 0) {
                    // go j-1.
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        // return result.
        return result;
    }
}
