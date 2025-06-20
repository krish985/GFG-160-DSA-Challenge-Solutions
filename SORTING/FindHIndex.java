// Problem: Find H - Index.
// Platform Available : Leetcode 274 , GFG.
// Difficulty: Medium.
// Companies tag : Google , Meta , Amazone , BloomBerg , Apple , ByteDance , Linkdin
// Uber.

public class FindHIndex {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static int hIndex(int citations[]) {
        // STEP 1 : Find the h idx of citiations.
        // create a count array store frequency.

        // [6, 5, 3, 1, 0]
        // 1st paper: 6 citations → ≥ 1 → ✅
        // 2nd paper: 5 citations → ≥ 2 → ✅
        // 3rd paper: 3 citations → ≥ 3 → ✅
        // 4th paper: 1 citation → < 4 → ❌ → STOP here
        // So 3 papers have ≥ 3 citations → H-index = 3

        int n = citations.length;
        int count[] = new int[n + 1];

        for (int val : citations) {
            if (val > n) {
                count[n]++;
            } else {
                count[val]++;
            }
        }

        // STEP 2 : iterate high to low and add if any point of time.
        // total >= h in that case return h.
        int total = 0;
        for (int h = n; h >= 0; h--) {
            // Summing no of paper that have atleast h citations.
            total += count[h];
            if (total >= h) {
                return h;
            }
        }

        // if not found.
        return 0;
    }
}
