// Problem: Container With Most Water.
// Platform Available : Leetcode 11 , GFG.
// Difficulty : Medium.
// Companies tag : Flipkart , Amazone , Google , Adobe , Meta , Walmart labs 
// Paytm , Uber , Samsung R&D.

public class ContainerWithMostWater {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int maxArea(int height[]) {
        // STEP 1 : Take a two pointer and maxwater variable
        // for storeing final ans.
        int lp = 0;
        int rp = height.length - 1;
        int maxwater = 0;

        // STEP 2 : Iterate lp < rp and perform some steps.
        while (lp < rp) {
            // Calculate width (rp - lp).
            int width = (rp - lp);

            // take min height beacuse if you take maxium height it
            // will overflow.
            int h = Math.min(height[lp], height[rp]);

            // calculate curHeight perform (width * h).
            int area = (width * h);

            // Then every time store maxium one .
            maxwater = Math.max(maxwater, area);

            // Then after that move pointer.
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        // STEP 3 : Return max water.
        return maxwater;
    }
}
