import java.util.ArrayList;
import java.util.HashSet;

// Problem: Intersection of Two arrays with Duplicate Elements.
// Platform Available : Leetcode  349, GFG.
// Difficulty: Easy.
// Companies tag : Amazon , Microsoft , Meta , Google , Intuite , Adobe , Oracle
// Uber , Bloomberg , Goldman Sachs , Flipkart , TCS Digital / CodeVita , Infosys SP / DSE role

public class InterSectionOfTwoArray {
    // TIME COMPLEXITY : O(N + M).
    // SPCAE COMPLEXITY : O(N).
    public static ArrayList<Integer> interSection(int A[],int B[]){
        // STEP 1 : Create a hashset that store distinct value
        // because we have to handel duplicate also.
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();  // For Storing Intersection Point

        // STEP 2 : Iterate 1 array and add into a set.
        for(int val : A){
            set.add(val);
        }

        // STEP 3 : Iterate 2 Array and check into set if value avilable
        // in set add into list and remove that from set.
        for(int val : B){
            if(set.contains(val)){
                // Add or Remove.
                list.add(val);
                set.remove(val);  // ensures no duplicate entries in result.
            }
        }

        // STEP 4 : return that list.
        return list;
    }
}
