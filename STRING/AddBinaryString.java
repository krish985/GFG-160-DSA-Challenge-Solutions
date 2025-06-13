// Problem: Add Binary Strings.
// Platform Available : Leetcode - 67 , GFG.
// Difficulty: Medium.
// Companies tag : TCS Digital , Amazon , Microsoft , Meta , Infosys , Wipro , Accenture
// Capgemini , Cognizant , Samsung R&D.

public class AddBinaryString {
    // TIME COMPLEXITY : O( n + m) where n is str1 and m is str2.
    // SPACE COMPLEXITY : O( n + m) where n is str1 and m is str2.
    public static String trimLeadingZero(String str) {
        // Remove all the zero from starting.
        // Example : 00100 // After removing 100.
        int firstIdx = str.indexOf('1');
        return (firstIdx == -1) ? "0" : str.substring(firstIdx);
    }

    public static String addBinary(String str1, String str2) {
        // STEP 1 : For GFG solution remove leading zeroes from starting.
        // For leetcode solution skip Step1,
        str1 = trimLeadingZero(str1);
        str2 = trimLeadingZero(str2);

        // STEP 2 : pointer point to string last idx.
        int s1 = str1.length() - 1;
        int s2 = str2.length() - 1;
        int carry = 0; // that track all the carry.

        // NOTE*
        // 1 + 1 = 0 carry 1.
        // 0 + 1 = 1.
        // 1 + 0 = 1.

        // STEP 3 : Create a stringBuilder that store ans.
        StringBuilder res = new StringBuilder();

        // STEP 4 : iterate over the string backward.
        while (s1 >= 0 || s2 >= 0 || carry == 1) {
            // Add carry into sum.
            int sum = carry;

            // add s1 and s2 val into sum variable.
            if (s1 >= 0) {
                sum += str1.charAt(s1) - '0';
                s1--; // Move backward.
            }
            if (s2 >= 0) {
                sum += str2.charAt(s2) - '0';
                s2--; // Move backward.
            }

            // Now add sum % 2 into res sb.
            res.append(sum % 2);
            carry = sum / 2;
        }

        // STEP 5 : Convert stringbuilder into string and also reverse that string.
        return res.reverse().toString();

    }
}
