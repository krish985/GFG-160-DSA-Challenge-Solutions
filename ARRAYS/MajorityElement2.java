import java.util.ArrayList;
import java.util.List;

// Problem: Majority Element 2.
// Platform Available : Leetcode 229 , GFG.
// Difficulty: Medium.
// Companies tag : Amazone , MicroSoft , Apple , BloomBerg , Uber , Zenefits.

public class MajorityElement2 {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static List<Integer> findMajority(int nums[]) {
        // Edge Case.
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // STEP 1 : Apply Extension of Boyre more voting algorithm.
        // count two majority candidate.
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;

        // STEP 2 : iterate over the array for candidate selection.
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                // reset candidate and make curr elemnt
                // to potential candidate.
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                // reset candidate and make curr elemnt
                // to potential candidate.
                candidate2 = nums[i];
                count2 = 1;
            } else {
                // if voilet all the condition
                // decrease both count by 1.
                count1--;
                count2--;
            }
        }

        // STEP 3 : Create list for storeing ans.
        List<Integer> res = new ArrayList<>();

        // STEP 4 : now verification again the occurence.
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            }
        }

        // STEP 5 : last check.
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }

        // STEP 6 : Not impoertant but gfg not acccept code withount sorting.
        // leetcode accepet.
        if (res.size() == 2 && res.get(0) > res.get(1)) {
            int temp = res.get(0);
            res.set(0, res.get(1));
            res.set(1, temp);
        }

        // return ans.
        return res;
    }
}
