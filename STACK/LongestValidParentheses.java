import java.util.Stack;

// Problem: Longest Valid Parentheses.
// Platform Availaible: Leetcode 32, GFG
// Difficulty : HARD
// Companies tag : Microsoft , Google , Amazon , Adobe , Apple , Uber , Bloomberg , Apple
// Meta , Oracle , SalesForce , Goldman Sachs , Morgan Stanley , JP Morgan , Barclays 
// Tower Research , DE SHAW , Phonepay , Flipkart , Paytm , Ola , Zomato , Swiggy.

public class LongestValidParentheses {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static int maxLength(String str) {
        // STEP 1 : Create a stack for track a sequence that store idx
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // For base this case )().

        // STEP 2 : Create a maxLen variable.
        int maxLen = 0;

        // STEP 3 : Iterate over the string.
        for (int i = 0; i < str.length(); i++) {
            // Extract char.
            char ch = str.charAt(i);

            // Openning occured put their idx into stack.
            if (ch == '(') {
                stack.push(i);

            } else {
                // It means closeing occured.
                // pop the element.
                stack.pop();

                // check if stack is not empty try to calculate max length
                if (!stack.isEmpty()) {
                    maxLen = Math.max(maxLen, i - stack.peek());
                } else {
                    // Stack empty.
                    // add curr idx.
                    stack.push(i);
                }
            }
        }
        // STEP 4 : Return Maxlen.
        return maxLen;
    }
}
