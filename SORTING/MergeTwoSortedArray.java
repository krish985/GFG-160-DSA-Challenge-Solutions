// Problem:  Merge Two Sorted Arrays Without Extra Space.
// Problem Link : https://www.geeksforgeeks.org/dsa/merge-two-sorted-arrays-o1-extra-space/
// Difficulty: Medium.
// Companies tag : Zoho , Microsoft , Snapdeal , Goldman Sachs , Adobe ,Linkedin , Amdocs , Brocade 
// Juniper Networks , Quikr , Synopsys.

public class MergeTwoSortedArray {
    // TIME COMPLEXITY : O(N+M * LOG(N+M)).
    // SPACE COMPLEXITY : O(1).
    public static void mergeArray(int a[], int b[]) {
        // STEP 1 : Calculate the length of both array.
        int n = a.length;
        int m = b.length;

        // STEP 2 : Calculate Gap Using Idea of Shell Sort Algorithm.
        int gap = (int) Math.ceil((n + m) / 2.0);

        // STEP 3 : Iterate until gap > 0.
        while (gap > 0) {
            // Calculate left or right idx
            int left = 0;
            int right = gap;

            // STEP 4 : iterate untill right < n+m.
            while (right < (n + m)) {
                // both lie in a[].
                if (left < n && right < n) {
                    // Greater Swap.
                    if (a[left] > a[right]) {
                        int temp = a[left];
                        a[left] = a[right];
                        a[right] = temp;
                    }
                } else if (left < n && right >= n) { // lie in both a[] b[].
                    // Greater Swap.
                    if (a[left] > b[right - n]) {
                        int temp = a[left];
                        a[left] = b[right - n];
                        b[right - n] = temp;
                    }
                } else if (left >= n && right < (n + m)) { // Both val lie in b[]
                    // Greater swap.
                    if (b[left - n] > b[right - n]) {
                        int temp = b[left - n];
                        b[left - n] = b[right - n];
                        b[right - n] = temp;
                    }
                }
                // Increament both pointer.
                left++;
                right++;
            }

            // STEP 5 : Check gap == 1 set gap to 0 else gap / 2 ceil val.
            gap = (gap == 1) ? 0 : (int) Math.ceil(gap / 2.0);
        }
    }
}