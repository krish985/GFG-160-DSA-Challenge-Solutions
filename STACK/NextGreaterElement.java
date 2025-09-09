import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

// Problem: Next Greater Element.
// Problem Link : https://www.geeksforgeeks.org/dsa/next-greater-element/
// Difficulty : MEDIUM
// Companies tag : Flipkart , Amazon , Microsoft , MakeMyTrip , Adobe , Paypal
// SalesForce  , Google , Uber.

public class NextGreaterElement {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static ArrayList<Integer> nextLargerElemnt(int arr[]){
        // STEP 1 : Create a stack that store greater element.
        Stack<Integer> stack = new Stack<>();

        // STEP 2 : Create a ArrayList of integer that store ans
        ArrayList<Integer> result = new ArrayList<>();

        // STEP 3 : Iterate from  Backward and find NGL.
        for(int i=arr.length-1; i>=0; i--){
            // if stack ! empty and stack top element <= curr element pop the stack ele.
            if(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            // If stack empty add -1 else add stack peek element.
            if(stack.isEmpty()){
                result.add(-1);
            }else{
                result.add(stack.peek());
            }

            // Finally every time add curr element into stack.
            stack.push(arr[i]);
        }

        // STEP 4 : Sort the result beacuse we iterateing from backward and return
        Collections.sort(result);
        return result;
    }
}
