// Problem: Sort an array of 0s, 1s and 2s.
// Platform Available : Leetcode 75 , GFG.
// Difficulty: Medium.
// Companies tag : Paytm , Flipkart , Morgan Stanley , Amazon , Microsoft , OYO Rooms 
// Samsung , Snapdeal , Hike , MakeMyTrip , Ola Cabs , Walmart , MAQ Software , Adobe 
// Yatra.com , SAP Labs , Qualcomm , Apple , Google , Razorpay , Grow , Paytm , swiggy
// Zomato , Meta.

public class Sort0s1sAnd2S {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static void sort012(int arr[]) {
        // STEP 1 : Understand DNF (Dutch National Flag) Algorithm.
        // in 0 lie -> 0 to low - 1.
        // in 1 lie -> low to mid - 1.
        // in 2 lie -> high + 1 to n-1.
        // Note* : mid to high part unsorted we have to sort that.
        // initially array lie into this case.

        // STEP 2 : Create pointer low mid that point 0 idx and high point n-1.
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        // STEP 3 : Iterate untill mid <= high.
        while (mid <= high) {
            // We have Three Case.
            if (arr[mid] == 0) {
                // In that case swap low to mid and move low and mid pointer
                // one step ahead.
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;

            } else if (arr[mid] == 1) {
                // In that case do nothing simply move mid pointer.
                mid++;

            } else if (arr[mid] == 2) {
                // In that case swap mid to high and move high pointer
                // 1 step backward.
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}