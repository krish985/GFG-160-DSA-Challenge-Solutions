import java.util.ArrayList;
import java.util.HashSet;

// Problem: Unions Of Two Array.
// Platform https://www.geeksforgeeks.org/dsa/union-of-two-arrays-with-distinct-elements/.
// Difficulty: Easy.
// Companies tag : Amazon , Microsoft , TCS (CodeVita / Ninja / Digital) , Accenture
// Wipro , Infosys , Cognizant , Capgemini , Flipkart , Paytm , HCL , Zoho.

public class UnionsOfArray {
    // TIME COMPLEXITY : O(N + M).
    // SPCAE COMPLEXITY : O(N + M).
    public static ArrayList<Integer> findUnion(int A[],int B[]){
        // STEP 1 : Create a hashset that store unique element.
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();  // For storing ans.

        // STEP 2 : Iterate first array and add distinct value.
        for(int num : A){
            set.add(num);
        }

        // STEP 3 : Iterate Second array and add distinct value.
        for(int num : B){
            set.add(num);
        }

        // STEP 4 : Iterate Hashset and add their value into list.
        for(int val : set){
            ans.add(val);
        }

        // STEP 5 : Return that list.
        return ans;
    }
}
