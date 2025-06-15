// Problem: First Non Repeating Character.
// Platform Available : Leetcode - 387 (Simiiler verion on leetcode) , GFG.
// Difficulty: EASY.
// Companies tag : Flipkart , Amazon , Microsoft , D-E-Shaw , MakeMyTrip , Ola Cabs , SamSung
// Payu , Teradata , Goldman Sachs , MAQ Software , InfoEdge , OATS Systems ,Tejas Network

public class NonRepeatingCharacter {
    public static char firstUniqueChar(String str) {
        // Edge Case : Input Validation.
        if (str.length() == 0) {
            return '$';
        }

        // STEP 1 : Create a frequency array that store frequency of ever character.
        int freq[] = new int[26]; // Alphabet have 26 letter.

        // STEP 2 : Store all frequency in frequency array.
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        // STEP 3 : Iterate string array check line wise if any character have frequency
        // 1.
        // return that character if not return '$'.
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i) - 'a'] == 1) {
                return str.charAt(i);
            }
        }

        // if not found return.
        return '$';
    }
}
