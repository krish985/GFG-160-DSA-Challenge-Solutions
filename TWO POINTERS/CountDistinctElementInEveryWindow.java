import java.util.ArrayList;
import java.util.HashMap;

// Problem: Count Distinct Elements In Every Window of Size K.
// Problem Link : https://www.geeksforgeeks.org/dsa/count-distinct-elements-in-every-window-of-size-k/
// Difficulty : Medium.
// Companies tag : Amazone , Accolite , Microsoft ,  Walmart Labs , DE-SHAW , Adobe 
// Flipkart , Google , TCS (Digital) , Goldman Sachs.

public class CountDistinctElementInEveryWindow {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static ArrayList<Integer> countDistinct(int arr[],int k){
        // STEP 1 : Create hashmap for store unique element.
        // it store arr val and their frequency.
        HashMap<Integer,Integer> map = new HashMap<>();

        // STEP 2 : Create a Arraylist for store distinct element
        // in every window k.
        ArrayList<Integer> ans = new ArrayList<>();

        // STEP 3 : Iterate over the array add first 0 to k value into map
        // and add map size into ans that's first window distinct element.
        for(int i=0; i<k; i++){
            // Store val and their frequency.
            map.put(arr[i] , map.getOrDefault(arr[i], 0) + 1);
        }
        ans.add(map.size());

        // STEP 4 : Iterate again k to n.
        for(int i=k; i<arr.length; i++){
            // Add new val.
            map.put(arr[i] , map.getOrDefault(arr[i], 0) + 1);

            // remove first val freq.
            map.put(arr[i-k] , map.get(arr[i-k]) - 1);

            // if that val frequnecy is 0 remove into map.
            if(map.get(arr[i-k]) == 0){
                map.remove(arr[i-k]);
            }

            // then add map size into ans list.
            ans.add(map.size());
        }

        // STEP 5 : Return ans.
        return ans;
    }
}
