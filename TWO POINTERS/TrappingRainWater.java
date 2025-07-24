// Problem: Trapping Rain Water.
// Platform Available : Leetcode 42 , GFG.
// Difficulty : HARD.
// Companies tag : Meta , Amazone , Apple , Netflix , Google , Microsoft , Adobe
// Uber , Linkdin , Salesforce , Bloomberg , VMware , Intuite , Flipkart , Ola
// Paytm , Cred , Swiggy , Zomato , Razorpay , Grow , Dream 11 , Samsung , Cisco
// Oracle , Nutanix , Qualcomm , Goldman Sachs , Walmart Labs.

public class TrappingRainWater {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int trappedWater(int height[]){
        // STEP 1 : Find Trapped water Between buildings
        // using two pointer approach.
        int right = 0;
        int left = height.length - 1;

        // STEP 2 : Take variable that track running lmax or rmax.
        int lmax = 0;
        int rmax = 0;

        // STEP 3 : Create a waterTrapped variable that store trapped water.
        int waterTrapped = 0;

        // STEP 4 : Iterate left < right.
        while(left < right){
            // Find running lmax or rmax.
            lmax = Math.max(lmax , height[left]);
            rmax = Math.max(rmax, height[right]);

            // check if lmax < rmax then lmax - curr height and store 
            // into water trapped.
            if(lmax < rmax){
                waterTrapped+= (lmax - height[left]);
                left++;   // Move left 1 step ahaead.
            }else{
                // Vice versa.
                waterTrapped+= (rmax - height[right]);
                right--;   // Move 1 step backward.
            }
        }

        // STEP 5 : Return trapped water.
        return waterTrapped;
    }
}
