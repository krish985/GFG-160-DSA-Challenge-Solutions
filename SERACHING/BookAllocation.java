// Problem: Allocate Minimum Pages .
// Problem Link : https://www.geeksforgeeks.org/dsa/allocate-minimum-number-pages/
// Difficulty: Medium - Hard.
// Companies tag : Infosys , Amazon , Microsoft , Google , Codenation , Uber
// Zoho , Flipkart , Stripe , Airbnb , Dropbox.

public class BookAllocation {
    // TIME COMPLEXITY : O(LogN * N) N For Range An another n for check is Valid.
    // SPACE COMPLEXITY : O(1).
    public static boolean isValid(int A[], int maxPageAllowed, int k) {
        // STEP 1 : take first student and try to allocate page.
        // initially.
        int pages = 0;
        int students = 1;

        // STEP 1 : Iterate from array and check are able to distribute pages for
        // k student.
        for (int i = 0; i < A.length; i++) {
            // Edge Case if A[i] > maxPageAllowed return false.
            // because we are ! able to distribute.
            if (A[i] > maxPageAllowed) {
                // One book is too large to be assigned
                return false;
            }

            // check if pages + A[i] <= maxAlloedPages add that A[i] into pages.
            if (pages + A[i] <= maxPageAllowed) {
                pages += A[i];
            } else {
                // If Excede value try to distribute another student.
                students++;
                // Start pages count for next student
                pages = A[i]; // Pages update to curr val.
            }
        }

        // last check if students <= k it means you succesfully distribute all pages.
        return (students <= k) ? true : false;

    }

    public static int findPages(int A[], int k) {
        // STEP 1 : if k > A.length return -1.
        // Beacuse at leat one or more students always left.
        if (k > A.length) {
            return -1; // EDGE CASE.
        }

        // STEP 2 : Find the whole sum of given array.
        // Beacuse the worst case student take all books.
        int sumOfAllPages = 0;
        for (int i = 0; i < A.length; i++) {
            sumOfAllPages += A[i];
        }

        // STEP 3 : Apply binary search between 0 to sumOfAllbook.
        int start = 0;
        int end = sumOfAllPages;
        int minPageThatAllocate = 0;

        while (start <= end) {
            // Calculate mid.
            int mid = start + (end - start) / 2;

            // Call is valid func that check that number of max page allowed or not.
            // if Allowed store that mid into minPageThatAllocate and try to find
            // minimum so eliminate right half.
            if (isValid(A, mid, k)) {
                minPageThatAllocate = mid;
                end = mid - 1; // Eliminate right half.
            } else {
                // Go to max half find minimum.
                start = mid + 1; // Elimainate left half.
            }
        }

        // return min page
        return minPageThatAllocate;

    }
}
