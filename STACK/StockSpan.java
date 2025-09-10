import java.util.ArrayList;
import java.util.Stack;

// Problem: Stock span problem.
// Problem Link : https://www.geeksforgeeks.org/dsa/the-stock-span-problem/
// Difficulty : MEDIUM
// Companies tag : Flipkart , Accolite , Amazon , Microsoft , Samsung , Adobe , IBM
// Goldman Sachs , FactSet , D.E. Shaw , Google , Meta , 

public class StockSpan {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static ArrayList<Integer> calSpan(int arr[]){
        // STEP 1 : Create stack that hold price idx.
        Stack<Integer> idxStack = new Stack<>();

        // STEP 2 : Create ArrayList that store span as ans.
        ArrayList<Integer> result = new ArrayList<>();

        // STEP 3 : For first element span is one 1 so explicity add span and idx to stack.
        idxStack.push(0);   
        result.add(1);

        // STEP 4 : Iterate from 1 till end.
        for(int i=1; i<arr.length; i++){
            // pop element if stack ! empty and stack top price <= curr price.
            while(!idxStack.isEmpty() && arr[idxStack.peek()] <= arr[i]){
                idxStack.pop();
            }

            // if any point of time stack empty store i + 1
            if(idxStack.isEmpty()){
                result.add(i+1);
            }else{
                // Store curr price idx - stack price idx
                result.add( i - idxStack.peek());
            }

            // Put idx into stack of curr element.
            idxStack.push(i);
        }

        // STEP 5 : Return result as answer.
        return result;
    }
}
