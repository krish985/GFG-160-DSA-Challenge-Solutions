import java.util.HashSet;
// Problem:  Longest Substring Without Repeating Characters.
// Platform Availaible : Leetcode 3 , GFG.
// Difficulty : Medium.
// Companies tag : Amazon , Microsoft , Housing.com , Adobe , Google , Flipkart
// Walmart Labs , Paytm , Goldman Sachs , Capgemini , Morgan Stanley , Uber
// Apple , Bloomberg , Linkdin , Oracle , Qualcomm , Z-scaller , DE-Shaw.

public class LongestSubstringWithoutRepeatingCharacter {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static int longestUniSubstring(String s) {
        // STEP 1 : Create a hashset to store all unique Characater of string.
        HashSet<Character> set = new HashSet<>();

        // STEP 2 : maitain varaible of maxLength that calculate
        // longest substring without repeating character.
        int maxLength = 0;

        // STEP 3 : also intialize left pointer it stick 0 idx untill found
        // the duplicate of string.
        int left = 0;

        // STEP 4 : iterate over the string and found.
        for (int right = 0; right < s.length(); right++) {
            // if right value already present in set it means
            // found duplicate remove character until you remove
            // the right val.
            while (set.contains(s.charAt(right))) {
                // remove characters from set.
                // for left to untill you remove that occured char.
                set.remove(s.charAt(left));
                left++;
            }
            // if not present it means unique add into set.
            set.add(s.charAt(right));

            // calculate maxLength.
            maxLength = Math.max(maxLength, right - left + 1); // idx start from 0.
        }

        // STEP 5 : return ans.
        return maxLength;
    }
}
