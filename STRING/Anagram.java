import java.util.Arrays;

// Problem: Valid Anagram.
// Platform Available : Leetcode - 242 , GFG.
// Difficulty: EASY.
// Companies tag : TCS , Amazon , Flipkart , Adobe , Infosys , Wipro ,  Google
// Goldman Sachs , Media.net , Nagarrro.

public class Anagram {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1). Because take fixed sized of freq array.
    public static boolean isAnagram(String str1, String str2) {
        // STEP 1 : Check both string length equal then procede further.
        if (str1.length() != str2.length()) {
            // Not a Anagram.
            return false;
        }

        // STEP 2 : Create a frequency array that count the character for both string.
        int freq1[] = new int[26];
        int freq2[] = new int[26]; // 26 character in alphabet.

        // STEP 3 : Iterate over the string and calculate frequency.
        for (int i = 0; i < str1.length(); i++) {
            // Char - 'a' Give you the idx of character.
            freq1[str1.charAt(i) - 'a']++;
            freq2[str2.charAt(i) - 'a']++; // ASCII value of 'a' is 97.
        }

        // STEP 4 : Check freq1 and freq2 frequency are equal it means it's a Anagram.
        // return.
        return Arrays.equals(freq1, freq2);
    }
}
