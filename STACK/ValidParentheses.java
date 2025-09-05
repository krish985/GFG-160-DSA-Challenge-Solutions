import java.util.Stack;

// Problem:  Valid Parentheses.
// Platform Availaible: Leetcode 20, GFG
// Difficulty : Easy.
// Companies tag : Flipkart , Amazon , Microsoft , OYO Rooms , Snapdeal , Oracle , Walmart 
// Adobe , Google , Yatra.com , Morgan Stanley , Bloomberg , Goldman Sachs , Qualcomm
// Paypal , Uber , Netflix , Meta.

public class ValidParentheses {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static boolean isValid(String s) {
        // STEP 1 : Initialize stack that maintain order Lifo Fashion.
        Stack<Character> stack = new Stack<>();

        // STEP 2 : Iterate over the string.
        for (int i = 0; i < s.length(); i++) {
            // Extract char.
            char ch = s.charAt(i);

            // Check if openning bracket occured add into stack.
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                // It means Closing bracket Occured.
                // if stack empty return false no need to check
                // beacuse already imbalanced.
                if (stack.isEmpty()) {
                    return false;
                }
                // If not empty match pair.
                char peek = stack.peek();
                if ((ch == ']' && peek == '[') || (ch == '}' && peek == '{') || (ch == ')' && peek == '(')) {
                    // Pop element.
                    stack.pop();
                } else {
                    // No match return false.
                    return false;
                }
            }
        }

        // STEP 3 : Check is stack empty return true either false.
        return stack.isEmpty() ? true : false;
    }
}