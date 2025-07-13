import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Problem: Group Anagrams .
// Platform Available : Leetcode 49 , GFG.
// Difficulty: Medium.
// Companies tag : Morgan Stanley , Amazon , Microsoft , Snapdeal D-E-Shaw 
// Goldman Sachs , Google , Meta , Apple , Adobe , Flipkart , Salesforce
// Paypal , Nagaroo , Intuite , VMware , Samsung R&D.

public class GroupAnagram {
    // TIME COMPLEXITY : O(N * K).
    // SPACE COMPLEXITY : O(N * K).
    public static String generateHash(String val){
        // Generate unique value for string.
        int hash[] = new int[26];

        for(int i=0; i<val.length(); i++){
            hash[val.charAt(i) - 'a']++;
        }

        StringBuilder str = new StringBuilder();
        for(int i=0; i<hash.length; i++){
            str.append(hash[i] + "");
            str.append("#");
        }

        // return hashkey.
        return str.toString();
    }
    public static ArrayList<ArrayList<String>> anagrams(String str[]){
        // STEP 1 : Create a Hashmap that store hashval and their 
        // corrosponding string.
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        // STEP 2 : Iterate over the string array
        for(String val : str){
            // Generate hashCode for the value.
            String hashCode = generateHash(val);

            // Check if that hash not prsent in map add it.
            if(!map.containsKey(hashCode)){
                map.put(hashCode, new ArrayList<>());
            }
            
            // add corresponding value into hash.
            map.get(hashCode).add(val);
        }

        // STEP 3 : Create a Arraylist of Arraylist then put map
        // value inside this are return.
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> data : map.entrySet()){
            // add value into list.
            list.add(data.getValue());
        }

        // STEP 4 : Return that list that containg all 
        // group of anagrams.
        return list;
    }
}
