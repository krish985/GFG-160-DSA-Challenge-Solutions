import java.util.HashMap;

        // prefixsum[i] == k it's give 0 so you look up on the map
        // that's why adding their frequency to 1.
        map.put(0, 1);
        int count = 0;    // It Track subarray.

        // STEP 3 : Iterate over the prefix Sum Array.
        for(int i=0; i<prefixSum.length; i++){
            // Extract Complement.
            int complement = prefixSum[i] - k;

            // Check for map complement exist.
            if(map.containsKey(complement)){
                // If Exist.
                count+= map.get(complement);
            }

            // Add into map if already present update frequency by 1.
            map.put(prefixSum[i] , map.getOrDefault(prefixSum[i], 0) + 1);
        }

        // STEP 4 : Return Subarray sum Equal k count.
        return count;
    }
}
